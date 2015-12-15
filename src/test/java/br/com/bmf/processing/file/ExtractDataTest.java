package br.com.bmf.processing.file;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bmf.bovespa.processing.file.model.Company;
import br.com.bmf.bovespa.processing.file.model.Quotation;

public class ExtractDataTest {

	private static ContextData context;

	@BeforeClass
	public static void setUp() throws Exception {
		context = ExtractData.instance().loadData( 
				ExtractData.class.getResource("/COTAHIST_2014_TEST.txt").getFile() );
	}

	@Test
	public void testSucessGetCompanies() {
		Set<Company> expected = new HashSet<>(); 
		expected.add(new Company("AAPL34", "APPLE DRN"));
		expected.add(new Company("ABCB4", "ABC BRASIL PN  EJS"));
//		expected.add(new Company("ABCB4F", "ABC BRASIL PN  EJS"));
//		expected.add(new Company("ABCB4T", "ABC BRASIL PN  EJS"));
//		expected.add(new Company("ABEV3", "AMBEV S/A ON"));
//		expected.add(new Company("ALPA4", "ALPARGATAS PN"));
		
		assertEquals(expected, context.getCompanies());
	}
	
	@Test
	public void testSucessGetQuotations() {
		List<Quotation> expected = new ArrayList<>();
		expected.add(new Quotation()
							.withCode("AAPL34")
							.withCompany("APPLE DRN")
							.withTradingDate("20140102")
							.withOpenPrice("0000000013212")
							.withMaxPrice("0000000013212")
							.withMinPrice("0000000013212")
							.withAveragePrice("0000000013212")
							.withLastPrice("0000000013212")
							.withTotalTrading("00001")
							.withTotalVolume("000000000011890800"));
		expected.add(new Quotation()
				.withCode("ABCB4")
				.withCompany("ABC BRASIL PN  EJS")
				.withTradingDate("20140102")
				.withOpenPrice("0000000001231")
				.withMaxPrice("0000000001236")
				.withMinPrice("0000000001170")
				.withAveragePrice("0000000001192")
				.withLastPrice("0000000001190")
				.withTotalTrading("01544")
				.withTotalVolume("000000000430789400"));
		
	
		assertEquals(expected, context.getQuotations());
	}

}
