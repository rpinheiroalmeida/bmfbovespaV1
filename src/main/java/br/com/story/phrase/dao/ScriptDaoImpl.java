package br.com.story.phrase.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.story.phrase.model.Script;

@Repository
public class ScriptDaoImpl extends HibernateDaoSupport  {

	public void save(Script script) {
		getHibernateTemplate().save( script );
	}
	
	@SuppressWarnings("unchecked")
	public List<Script> find(Script script) {
		return (List<Script>) getHibernateTemplate().findByExample(script);
	}

	@SuppressWarnings("unchecked")
	public List<Script> findAll() {
		return getHibernateTemplate().find( "from br.com.story.phrase.model.Script" );
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
