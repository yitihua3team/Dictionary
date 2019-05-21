package dictionary.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import dictionary.dao.WordDao;
import dictionary.models.Word;

public class WordDaoImpl implements WordDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Word findExplanation(String word) {

		// be very careful when using createQuery
		// string inside should refer the table as declared simple "name" in
		// hbm.xml file, with upper-case initial
		// column name should be referred in lower-case

		Criteria query = sessionFactory.getCurrentSession().createCriteria(
				Word.class);
		query.add(Restrictions.like("word", word, MatchMode.EXACT));
		List<?> results = query.list();

		return results == null || results.size() == 0 ? Word.NULL
				: (Word) results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Word> findSuggestions(String word) {
		List<Word> results = sessionFactory.getCurrentSession()
				.createCriteria(Word.class)
				.add(Restrictions.like("word", word, MatchMode.START)).list();

		return results;
	}

}
