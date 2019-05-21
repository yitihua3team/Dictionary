package dictionary.dao;

import java.util.List;

import dictionary.models.Word;

/**
 * Interface defining the Word DAO behavior.
 * 
 * @author Lucian Ilie
 *
 */
public interface WordDao {
	
	/**
	 * Method that gets the Word object for a searched String word.
	 * @param word word to be searched for in the dictionary
	 * @return Word object (id, word, explanation)
	 */
	Word findExplanation(String word);
	
	/**
	 * Method returns a list of Word object suggestions for the searched String word.
	 * @param word word for which suggestions to be found
	 * @return list of Word objects that begin with parameter word
	 */
	List<Word> findSuggestions(String word);
	
}
