package dictionary.models;

/**
 * Class encapsulating a dictionary entry information. Contains fields int id, String word and String explanation.
 * @author Lucian Ilie
 *
 */
public class Word {

	private int id;
	private String word;
	private String explanation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	/**
	 * NULL constant word, to be used instead of null references & avoid NullPointerExceptions.<br>
	 * Implements Null Object pattern.
	 */
	public static final Word NULL = new Word() {
		{
			super.setId(0);
			super.setWord("none");
			super.setExplanation("none");
		}
	};

}
