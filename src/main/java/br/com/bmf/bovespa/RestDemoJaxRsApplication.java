package br.com.story.phrase;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import br.com.story.phrase.resources.CharacterResource;
import br.com.story.phrase.resources.MovieSettingResource;
import br.com.story.phrase.resources.ScriptResource;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 */
public class RestDemoJaxRsApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public RestDemoJaxRsApplication() {
		
        packages("br.com.story.phrase.rest.impl");
        
		register(ScriptResource.class);
		register(MovieSettingResource.class);
		register(CharacterResource.class);
		
		register(RequestContextFilter.class);
	}
}