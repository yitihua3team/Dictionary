package dictionary.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import dictionary.dao.WordDao;
import dictionary.models.Word;

/**
 * Class implementing the service layer of Dictionary application.<br>
 * Session transactions are found in this class.<br>
 * Contains methods "findExplanation(String <i>word</i>)" and "findSuggestions(String <i>word</i>)".
 * @author Lucian Ilie
 *
 */
public class Dictionary {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private WordDao wordDao;

	/**
	 * Finds explanation of <i>word</i> inside the <i>Dictionary</i> object.<br>
	 * Implements service layer of application.<br>
	 * Uses Hibernate session to begin a transaction, then forwards findExplanation method call to Word DAO.<br>
	 * <br>
	 * @param word Word to be searched in the Dictionary
	 * @return returns a <i>Word</i> object; if <i>word</i> was not found, returns a dummy Word.NULL singleton
	 */
	public Word findExplanation(String word) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Word result = null;
		try {
			tx = session.beginTransaction();
			result = wordDao.findExplanation(word);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
		}
		
		return result==null ? Word.NULL : result;
	}

	/**
	 * Method to get the word suggestions through the DAO implementation & Hibernate query.
	 * Method is part of the service layer and contains the transaction implementation.
	 * @param word String word for which to look for suggestions
	 * @return List<String> of Word.word suggestions
	 */
	public List<String> findSuggestions(String word) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Word> result = null;
		try {
			tx = session.beginTransaction();
			result = wordDao.findSuggestions(word);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
		}
		
		return getSuggestions(result);
	}
	
	/**
	 * Method to convert the list of Words to a list of String, for word suggestions.
	 * @param result receives a List<? extends Word> parameter from the DAO
	 * @return List<String> of words
	 */
	public List<String> getSuggestions(List<? extends Word> result) {
		List<String> suggestions = new ArrayList<String>();
		
		if (result.size() > 0) {
			for (Word w : result) {
				suggestions.add(w.getWord());
			}
		}
		
		return suggestions;
	}

}
