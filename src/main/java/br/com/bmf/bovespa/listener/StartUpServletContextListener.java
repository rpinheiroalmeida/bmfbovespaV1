package br.com.bmf.bovespa.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.bmf.bovespa.util.ZipUtil;
import br.com.bmf.processing.file.ExtractData;

public class StartUpServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContextListener started");	

		try {
			String fileZip = getClass().getResource("/COTAHIST_A2014.ZIP").getFile();
//			String fileZip = getClass().getResource("/COTAHIST_2014_TEST_LASTQUOTATION.zip").getFile();
			
			
			String sourceDest = event.getServletContext().getRealPath("/");
			String fileName = ZipUtil.unzip(fileZip, sourceDest);
			ExtractData.instance().loadData(sourceDest+"/"+fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
