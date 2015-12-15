package br.com.bmf.processing.file;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.processing.file.model.Quotation;

public class ExtractData {

	private static final ExtractData instance = new ExtractData();
	private ContextData context;
	
	private ExtractData() {	
		context = new ContextData();
	}
	
	public static ExtractData instance() {
		return instance;
	}
	
	public ContextData loadData(String filePath) throws IOException {
		LineIterator lt = IOUtils.lineIterator(new FileReader(filePath));
		return process(lt);
	}
	
	public ContextData getContextData() {
		return this.context;
	}

	private ContextData process(LineIterator lineIterator) {
		String line = null;
		Company company = null;
		for (LineIterator iterator = lineIterator; iterator.hasNext();) {
			line = iterator.nextLine();
			if (isLineQuotation(line)) {
				company = getCompany(line);
				context.addCompany(company);
				context.addQuotation(getQuotation(company, line));
			}
		}
		return context;
	}
	
	private Quotation getQuotation(Company company, String line) {
		
		return new Quotation()
						.withCode(company.getCode())
						.withCompany(company.getName())
						.withTradingDate(line.substring(2, 10))
						.withOpenPrice(line.substring(56, 69))
						.withMaxPrice(line.substring(69, 82))
						.withMinPrice(line.substring(82, 95))
						.withAveragePrice(line.substring(95, 108))
						.withLastPrice(line.substring(108, 121))
						.withTotalTrading(line.substring(147, 152))
						.withTotalVolume(line.substring(170, 188));
	}
	
	private Company getCompany(String line) {
		return new Company(line.substring(12, 23).trim(), 
				String.format("%s %s", line.substring(27, 38).trim(), line.substring(39, 47).trim()));
	}

	private boolean isLineQuotation(String line) {
		return line.startsWith("01");
	}
	
}
