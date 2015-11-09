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

import br.com.story.phrase.model.Character;
import br.com.story.phrase.resources.response.CharacterResponse;
import br.com.story.phrase.resources.response.DefaultResponse;
import br.com.story.phrase.service.CharacterService;

@Path("/characters")
public class CharacterResource {

	Logger logger = Logger.getLogger("CharacterResource");
	
	@Autowired
	private CharacterService characterService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response list() {
		try {
			List<Character> characters = characterService.list();
			List<CharacterResponse> charactersResponse = CharacterResponse.transform(characters);
			
			return Response.ok().entity(charactersResponse).build();
		} catch (Exception e) {
			System.out.println(e);
			return Response.ok().entity(new DefaultResponse("Unexpected error")).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getCharacter(@PathParam("id") Long id) {
		try {
			Character character = characterService.findById(id);
			return Response.ok().entity(CharacterResponse.transform(character)).build();
		} catch (Exception e) {
			return Response.ok().entity(new DefaultResponse("Unexpected error")).build();
		}
	}
}
