package com.mysite.java.anagrams;


public class Anagrams {
	public static void main(String[] args) {
		String phrase = "7ew!f8e efg!h";
		
		System.out.println(doAnagram(phrase));
	}
	
	
	private static String doAnagram(String phrase) {
		String[] words = phrase.split(" ");
		String anagram = "";
		
		for (String word : words) {
			anagram += (doReverse(word) + " ");
		}
		return anagram;
	}
	
	private static String doReverse(String word) {
		StringBuilder result = new StringBuilder(word);
		int headIndex = 0;
		int tailIndex = result.length() - 1;

		while (headIndex < tailIndex) {
			if (Character.isLetter(result.charAt(headIndex)) && Character.isLetter(result.charAt(tailIndex))) {
				char temp = result.charAt(headIndex);
				result.setCharAt(headIndex, result.charAt(tailIndex));
				result.setCharAt(tailIndex, temp);

				headIndex++;
				tailIndex--;
				
			} else if (!Character.isLetter(result.charAt(headIndex)) && Character.isLetter(result.charAt(tailIndex))) {
				headIndex++;
			} else if (Character.isLetter(result.charAt(headIndex)) && !Character.isLetter(result.charAt(tailIndex))) {
				tailIndex--;
			}
		}
		return result.toString();
	}

}


