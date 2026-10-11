package wordle;

import java.util.ArrayList;

public class WordInput {

	static ArrayList<Letter> wordIn = new ArrayList<>();
	
	
	public WordInput() {
		
	}
	
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static ArrayList<Letter> getWord(int number) {
		return wordIn;
	}
}
