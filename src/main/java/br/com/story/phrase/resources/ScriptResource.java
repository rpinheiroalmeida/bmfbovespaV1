package br.com.story.phrase.resources;


import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.story.phrase.errorhandling.AppException;
import br.com.story.phrase.model.MovieSetting;
import br.com.story.phrase.model.Script;
import br.com.story.phrase.resources.response.DefaultResponse;
import br.com.story.phrase.service.MovieSettingService;
import br.com.story.phrase.service.ScriptService;

@Path("script")
public class ScriptResource {

	Logger logger = Logger.getLogger("ScriptResource");
	
	@Autowired
	private ScriptService scriptService;
	
	@Autowired
	private MovieSettingService movieSettingService;
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response script(String script) {
		try {
			logger.info(String.format("Parameter received [%s]", script));
			Script scriptMovie = new Script(script);
			scriptMovie = scriptService.saveFileIfNotExists(scriptMovie);
			scriptService.saveIfNotExists(scriptMovie);
			Set<MovieSetting> moviesSettings = scriptService.processScript(scriptMovie);
			movieSettingService.save(moviesSettings);
			
			return Response.ok().entity(new DefaultResponse("Movie script successfully received")).build();
		} catch (AppException e) {
			return Response.status(Status.FORBIDDEN).entity(new DefaultResponse(e.getMessage())).build();
		} catch (Exception e) {
			return Response.ok().entity(new DefaultResponse(e.getMessage())).build();
		}
	}
	
	public ScriptService getScriptService() {
		return scriptService;
	}

	public void setScriptService(ScriptService scriptService) {
		this.scriptService = scriptService;
	}
}
