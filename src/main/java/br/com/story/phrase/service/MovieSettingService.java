package br.com.story.phrase.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.story.phrase.dao.MovieSettingDaoImpl;
import br.com.story.phrase.model.MovieSetting;

@Service
public class MovieSettingService {

	@Autowired
	private MovieSettingDaoImpl movieSettingDao;
	
	public MovieSettingService() {}
	
	
	public List<MovieSetting> list() {
		return getMovieSettingDao().list();
	}

	public void save(MovieSetting movieSetting) {
		getMovieSettingDao().save(movieSetting);
	}
	
	public void save(Set<MovieSetting> moviesSettings) {
		for (MovieSetting movieSetting : moviesSettings) {
			save(movieSetting);
		}
	}
	
	public MovieSetting findById(Long id) {
		MovieSetting movieSetting = getMovieSettingDao().findById(id);
		return movieSetting;
	}

	public void shutdown() {
		movieSettingDao.shutdown();
	}

	public MovieSettingDaoImpl getMovieSettingDao() {
		return movieSettingDao;
	}

	public void setMovieSettingDao(MovieSettingDaoImpl movieSettingDao) {
		this.movieSettingDao = movieSettingDao;
	}

}
