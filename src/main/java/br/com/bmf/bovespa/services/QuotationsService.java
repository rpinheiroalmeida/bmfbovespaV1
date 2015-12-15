package br.com.bmf.bovespa.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.processing.file.model.Quotation;
import br.com.bmf.bovespa.util.DateUtil;
import br.com.bmf.processing.file.ContextData;
import br.com.bmf.processing.file.ExtractData;

@Service
public class QuotationsService {

//	@PostConstruct
//	public void loadData() throws IOException {
////		String sourceDest = getClass().
//		String fileZip = getClass().getResource("/COTAHIST_A2014.ZIP").getFile();
//		String sourceDest = "/usr";
//		ZipUtil.unzip(fileZip, sourceDest);
//		contextData = ExtractData.instance().loadData(sourceDest);
////				getClass().getResource("/COTAHIST_2014_TEST_LASTQUOTATION.txt").getFile());   
//	}
	
	public ContextData getContextData() {
		return ExtractData.instance().getContextData();
	}
	public List<Quotation> getQuotations() {
		return getContextData().getQuotations();
	}
	
	public Set<Company> getCompanies() {
		return getContextData().getCompanies();
	}

	public Quotation getLastQuotation(String code) {
		Quotation lastQuotation = null;
		List<Quotation> quotations = getContextData().getQuotations(code);
		long maxDiff = Long.MAX_VALUE;
		long diff = 0;
		for (Quotation quotation : quotations) {
			diff = DateUtil.computeDiff(DateUtil.today(), quotation.getTradingDate());
			if (diff < maxDiff) {
				lastQuotation = quotation;
			}
		}
		return lastQuotation;
	}

	public List<Quotation> listQuotationFrom(String code, Date dataPregao) {
		List<Quotation> quotations = getContextData().getQuotations(code);
		List<Quotation> quotationsFromData = new ArrayList<>();
		
		for (Quotation quotation : quotations) {
			if (quotation.getTradingDate().equals(dataPregao)) {
				quotationsFromData.add(quotation);
			}
		}
		return quotationsFromData;
	}
}
