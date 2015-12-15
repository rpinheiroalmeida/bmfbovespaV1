package br.com.bmf.bovespa.resources.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.util.SOUtil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CompanyResponse() {}
	
	public CompanyResponse(String code, String company) {
		setCode(code);
		setCompany(company);
		setHostName(SOUtil.getHostName());
	}

	@XmlElement(name="CODNEG")
	private String code;
	
	@XmlElement(name="NOMRES")
	private String company;
	
	@XmlElement(name="HOST")
	private String hostName;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return String.format("CodeCompanyResponse[code=%s, company=%s]", this.code, this.company);
	}
	
	public static Set<CompanyResponse> transform(Set<Company> companies) {
		Set<CompanyResponse> response = new HashSet<>();
		for (Company company : companies) {
			response.add(transform(company));
		}
		return response;
	}
	
	public static CompanyResponse transform(Company company) {
		return new CompanyResponse(company.getCode(), company.getName());
	}
}

