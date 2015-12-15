package br.com.bmf.bovespa.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SOUtil {

	public static String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(SOUtil.getHostName());
	}
}
