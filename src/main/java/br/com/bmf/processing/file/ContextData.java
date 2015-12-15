package br.com.bmf.processing.file;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.processing.file.model.Quotation;

public class ContextData {

	private List<Quotation> quotations = new ArrayList<>();
	private Set<Company> companies = new HashSet<>();
	
	public void addCompany(Company company) {
		if (company != null) {
			companies.add(company);
		}
	}
	
	public void addQuotation(Quotation quotation) {
		quotations.add(quotation);
	}
	
	public Set<Company> getCompanies() {
		return companies;
	}
	
	public List<Quotation> getQuotations() {
		return quotations;
	}
	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public List<Quotation> getQuotations(String code) {
		List<Quotation> quotatiosFromCode = new ArrayList<>();
		for (Quotation quotation : quotations) {
			if (quotation.isCode(code)) {
				quotatiosFromCode.add(quotation);
			}
		}
		return quotatiosFromCode;
	}
}
