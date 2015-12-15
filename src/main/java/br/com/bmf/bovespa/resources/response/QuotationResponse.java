package br.com.bmf.bovespa.resources.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.bmf.bovespa.processing.file.model.Quotation;
import br.com.bmf.bovespa.util.DateUtil;
import br.com.bmf.bovespa.util.SOUtil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QuotationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public QuotationResponse() {
		setHostName(SOUtil.getHostName());
	}
	
	@XmlElement(name="CODNEG")
	private String code;
	
	@XmlElement(name="NOMRES")
	private String company;
	
	@XmlElement(name="DATA_PREGAO")
	private String tradingDate;
	
	@XmlElement(name="PREMAX")
	private String openPrice;
	
	@XmlElement(name="PREABE")
	private String maxPrice;
	
	@XmlElement(name="PREMIN")
	private String minPrice;
	
	@XmlElement(name="PREMED")
	private String averagePrice;
	
	@XmlElement(name="PREULT")
	private String lastPrice;
	
	@XmlElement(name="TOTNEG")
	private String totalTrading;
	
	@XmlElement(name="VOLTOT")
	private String totalVolume;
	
	@XmlElement(name="HOST")
	private String hostName;
	
	public QuotationResponse withCode(String code) {
		setCode(code);
		return this;
	}
	public QuotationResponse withCompany(String company) {
		setCompany(company);
		return this;
	}
	public QuotationResponse withTradingDate(Date tradingDate) {
		setTradingDate(DateUtil.transform2String(tradingDate));
		return this;
	}
	public QuotationResponse withOpenPrice(String openPrice) {
		setOpenPrice(openPrice);
		return this;
	}
	public QuotationResponse withMaxPrice(String maxPrice) {
		setMaxPrice(maxPrice);
		return this;
	}
	public QuotationResponse withMinPrice(String minPrice) {
		setMinPrice(minPrice);
		return this;
	}
	public QuotationResponse withAveragePrice(String averagePrice) {
		setAveragePrice(averagePrice);
		return this;
	}
	public QuotationResponse withLastPrice(String lastPrice) {
		setLastPrice(lastPrice);
		return this;
	}
	public QuotationResponse withTotalTrading(String totalTrading) {
		setTotalTrading(totalTrading);
		return this;
	}
	public QuotationResponse withTotalVolume(String totalVolume) {
		setTotalVolume(totalVolume);
		return this;
	}
	public QuotationResponse withTradingDate(String dateStr) {
		setTradingDate(dateStr);
		return this;
	}
	
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
	public String getTradingDate() {
		return tradingDate;
	}
	public void setTradingDate(String tradingDate) {
		this.tradingDate = tradingDate;
	}
	public String getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public String getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}
	public String getTotalTrading() {
		return totalTrading;
	}
	public void setTotalTrading(String totalTrading) {
		this.totalTrading = totalTrading;
	}
	public String getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	@Override
	public String toString() {
		return String.format("Quotation [code=%s, company=%s, tradingDate=%s, openPrice=%s, maxPrice=%s,"
				+ " minPrice=%s, averagePrice=%s, lastPrice=%s, totalTrading=%s, totalVolume=%s]", 
			this.code, this.company, this.tradingDate, this.openPrice, this.maxPrice, this.minPrice,
			this.averagePrice, this.lastPrice, this.totalTrading, this.totalVolume);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averagePrice == null) ? 0 : averagePrice.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((lastPrice == null) ? 0 : lastPrice.hashCode());
		result = prime * result + ((maxPrice == null) ? 0 : maxPrice.hashCode());
		result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result + ((openPrice == null) ? 0 : openPrice.hashCode());
		result = prime * result + ((totalTrading == null) ? 0 : totalTrading.hashCode());
		result = prime * result + ((totalVolume == null) ? 0 : totalVolume.hashCode());
		result = prime * result + ((tradingDate == null) ? 0 : tradingDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuotationResponse other = (QuotationResponse) obj;
		if (averagePrice == null) {
			if (other.averagePrice != null)
				return false;
		} else if (!averagePrice.equals(other.averagePrice))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (lastPrice == null) {
			if (other.lastPrice != null)
				return false;
		} else if (!lastPrice.equals(other.lastPrice))
			return false;
		if (maxPrice == null) {
			if (other.maxPrice != null)
				return false;
		} else if (!maxPrice.equals(other.maxPrice))
			return false;
		if (minPrice == null) {
			if (other.minPrice != null)
				return false;
		} else if (!minPrice.equals(other.minPrice))
			return false;
		if (openPrice == null) {
			if (other.openPrice != null)
				return false;
		} else if (!openPrice.equals(other.openPrice))
			return false;
		if (totalTrading == null) {
			if (other.totalTrading != null)
				return false;
		} else if (!totalTrading.equals(other.totalTrading))
			return false;
		if (totalVolume == null) {
			if (other.totalVolume != null)
				return false;
		} else if (!totalVolume.equals(other.totalVolume))
			return false;
		if (tradingDate == null) {
			if (other.tradingDate != null)
				return false;
		} else if (!tradingDate.equals(other.tradingDate))
			return false;
		return true;
	}
	
	public static List<QuotationResponse> transform(List<Quotation> quotations) {
		List<QuotationResponse> response = new ArrayList<>();
		for (Quotation quotation : quotations) {
			response.add(QuotationResponse.transform(quotation));
		}
		return response;
	}
	
	public static QuotationResponse transform(Quotation quotation) {
		return new QuotationResponse()
				.withCode(quotation.getCode())
				.withCompany(quotation.getCompany())
				.withAveragePrice(quotation.getAveragePrice())
				.withLastPrice(quotation.getLastPrice())
				.withMaxPrice(quotation.getMaxPrice())
				.withMinPrice(quotation.getMinPrice())
				.withOpenPrice(quotation.getOpenPrice())
				.withTotalTrading(quotation.getTotalTrading())
				.withTotalVolume(quotation.getTotalVolume())
				.withTradingDate(quotation.getTradingDate());
	}
}

