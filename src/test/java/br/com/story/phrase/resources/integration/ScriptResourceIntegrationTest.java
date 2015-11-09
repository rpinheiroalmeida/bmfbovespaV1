package br.com.story.phrase.resources.integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.story.phrase.resources.ScriptResource;
import br.com.story.phrase.resources.response.DefaultResponse;
import br.com.story.phrase.util.FileUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class ScriptResourceIntegrationTest extends JerseyTest {

	private static final String PATH_FILE_SCRIPT = "scripts/screenplay.txt";
	
	@Override
	protected Application configure() {
		return new ResourceConfig(ScriptResource.class);
	}



	/**
	 * Test to see that the message "Got it!" is sent in the response.
	 * @throws IOException 
	 */
	@Test
	public void testSaveScriptSucess() throws IOException {
		FileUtil.removeFile(PATH_FILE_SCRIPT);
		
		Entity<String> entity = Entity.text(FileUtil.getContentFile( getClass().getResource("/screenplay.txt") ));

		final DefaultResponse responseMsg = target().path("script").request().accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)
				.put(entity, DefaultResponse.class);
		Response response = Response.ok().entity(new DefaultResponse("Movie script successfully received")).build();

		assertEquals(response.getStatus(), Status.OK.getStatusCode());
		assertEquals(response.getEntity().toString(), responseMsg.toString());
		
		FileUtil.removeFile(PATH_FILE_SCRIPT);
	}

	@Test
	@ExpectedException(ForbiddenException.class)
	public void testSaveScriptFail() throws IOException {
		FileUtil.removeFile(PATH_FILE_SCRIPT);
		
		Entity<String> entity = Entity.text(FileUtil.getContentFile( getClass().getResource("/screenplay.txt") ));

		
		target().path("script").request().accept(MediaType.APPLICATION_XML, 
				MediaType.APPLICATION_JSON).put(entity, DefaultResponse.class);

		FileUtil.removeFile(PATH_FILE_SCRIPT);
		
		target().path("script").request().accept(MediaType.APPLICATION_XML, 
				MediaType.APPLICATION_JSON).put(entity, DefaultResponse.class);
		
	}
}
