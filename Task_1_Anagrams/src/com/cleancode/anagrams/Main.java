package com.cleancode.anagrams;

public class Main {

	public static void main(String[] args) {
		Anagrams anagram = new Anagrams();
		String phrase = "a1bcd efg!h";

		System.out.println(anagram.doAnagram(phrase));
	}

}
