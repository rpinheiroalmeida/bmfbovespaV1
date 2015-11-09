package br.com.story.phrase.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.story.phrase.model.MovieSetting;

@Repository
@Transactional
public class MovieSettingDaoImpl extends HibernateDaoSupport  {

	public void save(MovieSetting movieSetting) {
		getHibernateTemplate().save( movieSetting );
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieSetting> find(MovieSetting movieSetting) {
		return (List<MovieSetting>) getHibernateTemplate().findByExample(movieSetting);
	}

	@SuppressWarnings("unchecked")
	public List<MovieSetting> list() {
		String hql = "select m from MovieSetting m";
		Query query = getSession().createQuery(hql);
		
		List<MovieSetting> moviesSetting = query.list(); 
				
		for (MovieSetting movieSetting : moviesSetting) {
			Hibernate.initialize(movieSetting.getCharacters());
		}
		
		return moviesSetting;
	}
	
	public MovieSetting findById(Long id) {
		String hql = "select m from MovieSetting m where m.idMovieSetting = :id";
		Query query = getSession().createQuery(hql);
		query.setLong("id", id);
		
		MovieSetting movieSetting = (MovieSetting) query.uniqueResult();
		Hibernate.initialize(movieSetting.getCharacters());
		
		return movieSetting;
	}
	
	public void shutdown()
    {
        getHibernateTemplate().getSessionFactory().openSession().createSQLQuery( "SHUTDOWN" ).executeUpdate();
    }

    @Autowired
    public void init( SessionFactory sessionFactory )
    {
        setSessionFactory( sessionFactory );
    }

	
}
