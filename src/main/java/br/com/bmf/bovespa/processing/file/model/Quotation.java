package br.com.bmf.bovespa.processing.file.model;

import java.util.Date;

import br.com.bmf.bovespa.util.DateUtil;

public class Quotation {

	private String code;
	private String company;
	private Date tradingDate;
	private String openPrice;
	private String maxPrice;
	private String minPrice;
	private String averagePrice;
	private String lastPrice;
	private String totalTrading;
	private String totalVolume;
	
	public Quotation withCode(String code) {
		setCode(code);
		return this;
	}
	
	public Quotation withCompany(String company) {
		setCompany(company);
		return this;
	}
	
	public Quotation withTradingDate(Date date) {
		setTradingDate(date);
		return this;
	}
	
	public Quotation withTradingDate(String dateStr) {
		setTradingDate(DateUtil.transform2Date(dateStr));
		return this;
	}
	
	public Quotation withOpenPrice(String openPrice) {
		setOpenPrice(openPrice);
		return this;
	}
	
	public Quotation withMaxPrice(String maxPrice) {
		setMaxPrice(maxPrice);
		return this;
	}
	
	public Quotation withMinPrice(String minPrice) {
		setMinPrice(minPrice);
		return this;
	}
	
	public Quotation withAveragePrice(String averagePrice) {
		setAveragePrice(averagePrice);
		return this;
	}
	
	public Quotation withLastPrice(String lastPrice) {
		setLastPrice(lastPrice);
		return this;
	}
	
	public Quotation withTotalTrading(String totalTrading) {
		setTotalTrading(totalTrading);
		return this;
	}
	
	public Quotation withTotalVolume(String totalVolume) {
		setTotalVolume(totalVolume);
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
	public Date getTradingDate() {
		return tradingDate;
	}
	public void setTradingDate(Date tradingDate) {
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
		Quotation other = (Quotation) obj;
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

	public boolean isCode(String code) {
		return this.code.equals(code);
	}
}
