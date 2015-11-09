package br.com.story.phrase.resources.integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.story.phrase.resources.MovieSettingResource;
import br.com.story.phrase.resources.ScriptResource;
import br.com.story.phrase.resources.response.CharacterResponse;
import br.com.story.phrase.resources.response.DefaultResponse;
import br.com.story.phrase.resources.response.MovieSettingResponse;
import br.com.story.phrase.util.FileUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class MovieSettingsResourceIntegrationTest extends JerseyTest {

	private static final String PATH_FILE_SCRIPT = "scripts/screenplay.txt";
	
	@Override
	protected Application configure() {
		return new ResourceConfig(ScriptResource.class, MovieSettingResource.class);
	}

	@Test
	public void testGetSettingsSucess() throws IOException {
		FileUtil.removeFile(PATH_FILE_SCRIPT);
		
		Entity<String> entity = Entity.text(FileUtil.getContentFile( getClass().getResource("/screenplayV1.txt") ));

		target().path("script").request().accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)
				.put(entity, DefaultResponse.class);
		
		MovieSettingResponse responseActual = target().path("/settings/1").request().
				accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).
				get(MovieSettingResponse.class);
		
		MovieSettingResponse msResponseExpected = new MovieSettingResponse();
		msResponseExpected.setId(1L);
		msResponseExpected.setName("REBEL BLOCKADE RUNNER");
		CharacterResponse characterResponseThreepio = new CharacterResponse();
		characterResponseThreepio.setId(1L);
		characterResponseThreepio.setName("THREEPIO");
		List<CharacterResponse> charactersResponse = Arrays.asList(characterResponseThreepio);
		
		assertEquals(msResponseExpected, responseActual);
		assertEquals(charactersResponse, responseActual.getCharacters());
		
		FileUtil.removeFile(PATH_FILE_SCRIPT);
	}
	
	@Test
	public void testGetSettingsFail() throws IOException {
		FileUtil.removeFile(PATH_FILE_SCRIPT);
		
		Entity<String> entity = Entity.text(FileUtil.getContentFile( getClass().getResource("/screenplayV1.txt") ));

		target().path("script").request().accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)
				.put(entity, DefaultResponse.class);
		
		DefaultResponse responseActual = target().path("/settings/10000").request().
				accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).
				get(DefaultResponse.class);
		
				
		assertEquals(new DefaultResponse("Unexpected error"), responseActual);
		
		FileUtil.removeFile(PATH_FILE_SCRIPT);
	}
}
