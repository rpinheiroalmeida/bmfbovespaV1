package br.com.bmf.bovespa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static final Date transform2Date(String dateStr) {
		GregorianCalendar gc = new GregorianCalendar(
				Integer.parseInt(dateStr.substring(0,4)), 
				Integer.parseInt(dateStr.substring(4,6)), 
				Integer.parseInt(dateStr.substring(6, 8)) );
		
		return gc.getTime();
	}
	
	public static final String transform2String(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static final Date convert2Date(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}

	public static Date today() {
		return new Date();
	}

	public static long computeDiff(Date today, Date oDate) {
		return today.getTime() - oDate.getTime();
	}
}
