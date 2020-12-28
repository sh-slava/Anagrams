package com.mysite.java.anagrams;

import static java.lang.Character.isLetter;

public class Anagrams {
	public static void main(String[] args) {
		String phrase = "a1bcd efg!h";
		
		System.out.println(doAnagram(phrase));
	}
	
	
	private static String doAnagram(String phrase) {
		String[] words = phrase.split(" ");
		StringBuilder anagram = new StringBuilder();
		
		for (String word : words) {
			anagram.append(doReverse(word).append(" "));
		}
		return anagram.toString();
	}
	
	private static StringBuilder doReverse(String word) {
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

//			if (isLetter(headChar) && isLetter(tailChar)) {
//				exchangeLetters(reversedWord, headIndex, tailIndex);
//				headIndex++;
//				tailIndex--;	
//			} 
//			else if (!isLetter(headChar) && isLetter(tailChar)) {
//				headIndex++;
//			} 
//			else if (isLetter(headChar) && !isLetter(tailChar)) {
//				tailIndex--;
//			}
//			else {
//				headIndex++;
//				tailIndex--;
//			}
		}
		return result;
	}

	private static void exchangeLetters(StringBuilder word, int headIndex, int tailIndex) {
		char temp = word.charAt(headIndex);
		word.setCharAt(headIndex, word.charAt(tailIndex));
		word.setCharAt(tailIndex, temp);
	}
}


