package br.com.bmf.bovespa.resources;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.processing.file.model.Quotation;
import br.com.bmf.bovespa.resources.response.CompanyResponse;
import br.com.bmf.bovespa.resources.response.QuotationResponse;
import br.com.bmf.bovespa.services.QuotationsService;
import br.com.bmf.bovespa.util.DateUtil;

@Path("/bmfbovespa")
public class QuotationsResource {

	Logger logger = Logger.getLogger("MovieSettingResource");
	
	@Autowired
	private QuotationsService quotationService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response listAllCodes() throws IOException {
		logger.info("ListAllCodes called!");
		
		Set<Company> companies = quotationService.getCompanies();
		return Response.ok().entity(CompanyResponse.transform(companies)).build();
	}
	
	@GET
	@Path("{code}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getLastQuotation(@PathParam("code") String code) {
		logger.info(String.format("Parameter received [%s]", code));
		
		Quotation lastQuotation = quotationService.getLastQuotation(code);
		
		return Response.ok().entity(QuotationResponse.transform(lastQuotation)).build();
	}

	@GET
	@Path("{code}/{dataPregao}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getQuotationDate(@PathParam("code") String code, @PathParam("dataPregao") String dataPregao) throws ParseException {
		logger.info(String.format("Parameters received [%s, %s]", code, dataPregao));
		
		List<Quotation> quotations = quotationService.listQuotationFrom(code, DateUtil.convert2Date(dataPregao) );
		return Response.ok().entity(QuotationResponse.transform(quotations)).build();
	}
	
}
