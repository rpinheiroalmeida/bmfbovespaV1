package br.com.bmf.bovespa;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import br.com.bmf.bovespa.resources.QuotationsResource;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 */
public class RestDemoJaxRsApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public RestDemoJaxRsApplication() {
		
        packages("br.com.bmf.bovespa.resources");
        
        register(QuotationsResource.class);
        
//		register(ScriptResource.class);
//		register(MovieSettingResource.class);
//		register(CharacterResource.class);
		
		register(RequestContextFilter.class);
	}
}