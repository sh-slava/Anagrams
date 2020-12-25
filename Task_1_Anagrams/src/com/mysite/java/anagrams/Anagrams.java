package com.mysite.java.anagrams;


public class Anagrams {
	public static void main(String[] args) {
		String phrase = "7drt4 efg!h";
		
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
			
			if (Character.isLetter(headChar) && Character.isLetter(tailChar)) {
				char temp = result.charAt(headIndex);
				result.setCharAt(headIndex, result.charAt(tailIndex));
				result.setCharAt(tailIndex, temp);
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
		return result;
	}
}


