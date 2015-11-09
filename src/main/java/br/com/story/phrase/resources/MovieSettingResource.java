package br.com.story.phrase.resources;


import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.story.phrase.model.MovieSetting;
import br.com.story.phrase.resources.response.DefaultResponse;
import br.com.story.phrase.resources.response.MovieSettingResponse;
import br.com.story.phrase.service.CharacterService;
import br.com.story.phrase.service.MovieSettingService;

@Path("/settings")
public class MovieSettingResource {

	Logger logger = Logger.getLogger("MovieSettingResource");
	
	@Autowired
	private MovieSettingService movieSettingService;
	
	@Autowired
	private CharacterService characterService;
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMovieSettingsResource() {
		try {
			List<MovieSetting> settings = movieSettingService.list();
			for (MovieSetting movieSetting : settings) {
				characterService.loadWords(movieSetting.getCharacters());
			}
			
			return Response.ok().entity(MovieSettingResponse.transform(settings)).build();
		} catch (Exception e) {
			return Response.ok().entity(new DefaultResponse("Unexpected error")).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMovieSettingResource(@PathParam("id") Long id) {
		try {
			logger.info(String.format("Parameter received [%d]", id));
			System.out.println(String.format("Parameter received [%d]", id));
			MovieSetting movieSetting = movieSettingService.findById(id);
			characterService.loadWords(movieSetting.getCharacters());
			
			return Response.ok().entity(MovieSettingResponse.transform(movieSetting)).build();
		} catch (Exception e) {
			return Response.ok().entity(new DefaultResponse("Unexpected error")).build();
		}
	}
}
