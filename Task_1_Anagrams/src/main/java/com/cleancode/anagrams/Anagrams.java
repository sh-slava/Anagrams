package com.cleancode.anagrams;

import static java.lang.Character.isLetter;

import java.util.StringJoiner;

public class Anagrams {

	public String buildAnagram(String phrase) {
		if (phrase == null) {
			return null;
		}
		String[] words = phrase.split(" ");
		StringJoiner anagram = new StringJoiner(" ");
		
		for (String word : words) {
			anagram.add(reverse(word));
		}
		return anagram.toString();
	}
	
	private String reverse(String word) {
		StringBuilder result = new StringBuilder(word);
		int headIndex = 0;
		int tailIndex = result.length() - 1;
		
		while (headIndex < tailIndex) {
			char headChar = result.charAt(headIndex);
			char tailChar = result.charAt(tailIndex);
			
			if (!isLetter(headChar)) {
				headIndex++;
			}
			if (!isLetter(tailChar)) {
				tailIndex--;
			}
			if (isLetter(headChar) && isLetter(tailChar)) {
				exchangeLetters(result, headIndex, tailIndex);
				headIndex++;
				tailIndex--;
			}
		}
		return result.toString();
	}

	private void exchangeLetters(StringBuilder word, int headIndex, int tailIndex) {
		char temp = word.charAt(headIndex);
		word.setCharAt(headIndex, word.charAt(tailIndex));
		word.setCharAt(tailIndex, temp);
	}
}


