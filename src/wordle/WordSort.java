package wordle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sorts the 5letter.txt file and outputs an ArrayList with possible words.
 */
public class WordSort {
	static List<String> words;
	
	WordSort() throws IOException {
		loadWords();
	}
	
	
	private void loadWords() throws IOException {
		words = Files.readAllLines(Path.of("src/wordle/words/5letter.txt"));
	}
	
	///
	/// Public update method. calls refresh with same params
	public void update(List<String> current) {
		refresh();
	}
	
	///
	///
	static void refresh(){
		char[] feedback = new char[5];
		String guess = Gui.getWord();
		
		for(int i = 0 ; i < 5 ; i++) {
			if(Gui.greenChecks[i].isSelected()) {
				feedback[i] = 'G';
			} else if(Gui.yellowChecks[i].isSelected()) {
				feedback[i] = 'Y';
			} else {
				feedback[i] = 'X';
			}
		}
		
		List<String> possibleWords = new ArrayList<>();

		for (String word : words) {
		    if (matchesFeedback(word, guess, feedback, Gui.used.getText())) {
		        possibleWords.add(word);
		    }
		}
		
		Gui.wordArea.setText(String.join("\n", possibleWords));
		
		
	}
	
	public static boolean matchesFeedback(
			String candidate, String guess, char[] feedback, String usedLetters) {
		
		candidate = candidate.toLowerCase();
		guess = guess.toLowerCase();
		
		usedLetters = usedLetters.toLowerCase();

		for (int i = 0; i < usedLetters.length(); i++) {
		    if (candidate.indexOf(usedLetters.charAt(i)) >= 0) {
		        return false;
		    }
		}
		
		char[] result = new char[5];
		int[] remaining = new int[26];
		
		for(int i = 0 ; i < 5 ; i++) {
			result[i] = 'X';
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			if(candidate.charAt(i) == guess.charAt(i)) {
				result[i] = 'G';
			} else {
				remaining[candidate.charAt(i) - 'a']++;
			}
		}
		
	    for (int i = 0; i < 5; i++) {
	        if (result[i] != 'G') {
	            int index = guess.charAt(i) - 'a';

	            if (remaining[index] > 0) {
	                result[i] = 'Y';
	                remaining[index]--;
	            }
	        }
	    }
	    
	    for (int i = 0; i < 5; i++) {
	        if (result[i] != feedback[i]) {
	            return false;
	        }
	    }
		
		return true;
	}
}
