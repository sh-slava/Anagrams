package com.cleancode.anagrams;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnagramsTest {

	Anagrams anagram = new Anagrams();

	@Test
	public void buildAnagram_shouldReverseSeparatelly_whenSeveralWords() {
		String actual = "a1bcd efg!h";
		String expected = "d1cba hgf!e";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shouldReturnEmptyString_whenEmptyString() {
		String actual = "";
		String expected = "";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shouldReturnEmptyString_whenSpace() {
		String actual = " ";
		String expected = "";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shouldReverse_whenOnlyCharacters() {
		String actual = "abcd";
		String expected = "dcba";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shoulNotReverse_whenOnlyNonCharacters() {
		String actual = "&%$!5-*@";
		String expected = "&%$!5-*@";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shouldNotDoAnithing_whenSingleLetter_() {
		String actual = "a";
		String expected = "a";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_shouldNotDoAnithing_whenSingleNonLetter() {
		String actual = "!";
		String expected = "!";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void buildAnagram_ShouldReturnNull_whenNull() {
		assertNull(anagram.buildAnagram(null));
	}
}

