package com.mysite.java.anagrams;


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
		StringBuilder reversedWord = new StringBuilder(word);
		int headIndex = 0;
		int tailIndex = reversedWord.length() - 1;
		
		while (headIndex < tailIndex) {
			char headChar = reversedWord.charAt(headIndex);
			char tailChar = reversedWord.charAt(tailIndex);
			
			if (Character.isLetter(headChar) && Character.isLetter(tailChar)) {
				exghangeLetters(reversedWord, headIndex, tailIndex);
				headIndex++;
				tailIndex--;	
			} 
			else if (!Character.isLetter(headChar) && Character.isLetter(tailChar)) {
				headIndex++;
			} 
			else if (Character.isLetter(headChar) && !Character.isLetter(tailChar)) {
				tailIndex--;
			}
			else {
				headIndex++;
				tailIndex--;
			}
		}
		return reversedWord;
	}

	private static void exghangeLetters(StringBuilder result, int headIndex, int tailIndex) {
		char temp = result.charAt(headIndex);
		result.setCharAt(headIndex, result.charAt(tailIndex));
		result.setCharAt(tailIndex, temp);
	}
}


