package br.com.story.phrase.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.story.phrase.model.Character;
import br.com.story.phrase.model.Word;

@Repository
public class CharacterDaoImpl extends HibernateDaoSupport  {

	public void save(Character character) {
		getHibernateTemplate().save( character );
	}
	
	@SuppressWarnings("unchecked")
	public List<Character> find(Character Character) {
		return (List<Character>) getHibernateTemplate().findByExample(Character);
	}

	@SuppressWarnings("unchecked")
	public List<Character> list() {
		return getHibernateTemplate().find( "from br.com.story.phrase.model.Character" );
	}
	
	public Character findById(Long id) {
		String hql = "select c from Character c where c.idCharacter = :id";
		Query query = getSession().createQuery(hql);
		query.setLong("id", id);
		
		Character character = (Character) query.uniqueResult();
		
		return character;
	}
	
	@SuppressWarnings("unchecked")
	public List<Word> findWordsCharacter(Long id) {
		String hql = "select w.word, count(*) as quantidade from Word w where w.character.idCharacter = :id group by w.word order by 2 desc";
		Query query = getSession().createQuery(hql);
		query.setLong("id", id);
		
		query.setResultTransformer(new ResultTransformer() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Object transformTuple(Object[] result, String[] aliases) {
				Word word = new Word((String)result[0]);
				word.setCount((Long)result[1]);
				return word;
			}

			@SuppressWarnings("rawtypes")
			@Override
			public List transformList(List list) {
				return list;
			}
		});
		query.setMaxResults(10);
		List<Word> words = (List<Word>)query.list(); 
		getSession().close();
		return words;
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
