package br.com.bmf.bovespa.resources;


import java.io.IOException;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bmf.bovespa.resources.response.QuotationResponse;
import br.com.bmf.processing.file.ExtractData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class QuotationsResourceIT extends JerseyTest {

	@Override
	protected Application configure() {
		try {
			ExtractData.instance().loadData(getClass().getResource("/COTAHIST_2014_TEST_LASTQUOTATION.txt").getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResourceConfig(QuotationsResource.class);
	}

	@Test
	public void testListAllCodeSucess() throws IOException {
		target().path("/bmfbovespa").request().
				accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).
				get();
		
	}
	
	@Test
	public void testGetLastQuotationSucess() throws IOException {
		
		QuotationResponse actual = target().path("/bmfbovespa/AAPL34").request().
				accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).
				get(QuotationResponse.class);
		
		Assert.assertEquals(buildExpectedResponse(), actual);
		
	}

	private QuotationResponse buildExpectedResponse() {
		return new QuotationResponse()
					.withCode("AAPL34")
					.withCompany("APPLE DRN")
					.withTradingDate("2014-12-02")
					.withOpenPrice("0000000013212")
					.withMaxPrice("0000000013212")
					.withMinPrice("0000000013212")
					.withAveragePrice("0000000013212")
					.withLastPrice("0000000013212")
					.withTotalTrading("00001")
					.withTotalVolume("000000000011890800");
//		QuotationResponse expected = new QuotationResponse();
//		expected.setAveragePrice("1.0");
//		expected.setCode("AAPL34");
//		expected.setCompany("APPLE DRN");
//		expected.setLastPrice("1.0");
//		expected.setMaxPrice("10.0");
//		expected.setMinPrice("1.0");
//		expected.setOpenPrice("2.0");
//		expected.setTotalTrading("100");
//		expected.setTotalVolume("100");
//		expected.setTradingDate( new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime() );
//		return expected;
	}
	
	@Test
	@Ignore
	public void testGetQuotationDateSucess() throws IOException {
		
		QuotationResponse actual = target().path("/bmfbovespa/PETR4/2014-01-11").request().
				accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).
				get(QuotationResponse.class);
		
		Assert.assertEquals(buildExpectedResponse(), actual);
	}
	
}
