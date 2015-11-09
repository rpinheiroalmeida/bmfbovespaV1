package br.com.story.phrase.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.story.phrase.dao.ScriptDaoImpl;
import br.com.story.phrase.errorhandling.AppException;
import br.com.story.phrase.model.MovieSetting;
import br.com.story.phrase.model.Script;
import br.com.story.phrase.processing.ProcessingScript;
import br.com.story.phrase.util.FileUtil;

@Service
public class ScriptService {

	private static final String PATH_FILE_SCRIPT = "scripts/screenplay.txt";

	public ScriptService() {}

	@Autowired
	private ScriptDaoImpl scriptDao;
	
	public List<Script> findAll() {
		return getScriptDao().findAll();
	}

	public void save(Script script) {
		getScriptDao().save(script);
	}
	
	public void saveIfNotExists(Script script) throws AppException, IOException {
		List<Script> scripts = findAll();
		if (scripts.isEmpty()) {
			save(script);
		} else {
			throw new AppException("Movie script already received");
		}
	}
	
	private String saveFile(Script script) throws IOException {
		FileUtil.saveFile(script.getContent(), PATH_FILE_SCRIPT);
		return PATH_FILE_SCRIPT;
	}
	
	public Script saveFileIfNotExists(Script script) throws AppException, IOException {
		if (!FileUtil.fileExists(PATH_FILE_SCRIPT)) {
			script.setPathFile(saveFile(script));
		} else {
			throw new AppException("Movie script already received");
		}
		return script;
	}
	
	public Set<MovieSetting> processScript(Script script) throws FileNotFoundException {
		return ProcessingScript.process(script.getPathFile());
	}

	public ScriptDaoImpl getScriptDao() {
		return scriptDao;
	}

	public void setScriptDao(ScriptDaoImpl scriptDao) {
		this.scriptDao = scriptDao;
	}

	public void shutdown() {
		scriptDao.shutdown();
	}

}
