package com.cleancode.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramsTest {

	Anagrams anagram;

	@BeforeEach
	void init() {
		anagram = new Anagrams();
	}

	@Test
	public void testBuildAnagram_SeveralWords_ShouldReverseSeparatelly() {
		String actual = "a1bcd efg!h";
		String expected = "d1cba hgf!e";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_EmptyString_ShouldReturnEmptyString() {
		String actual = "";
		String expected = "";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_Space_ShouldReturnEmptyString() {
		String actual = " ";
		String expected = "";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_OnlyCharacters_ShouldReverse() {
		String actual = "abcd";
		String expected = "dcba";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_OnlyNonCharacters_ShoulNotReverse() {
		String actual = "&%$!5-*@";
		String expected = "&%$!5-*@";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_SingleLetter_ShouldNotDoAnithing() {
		String actual = "a";
		String expected = "a";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_SingleNonLetter_ShouldNotDoAnithing() {
		String actual = "!";
		String expected = "!";
		assertEquals(expected, anagram.buildAnagram(actual));
	}

	@Test
	public void testBuildAnagram_NullInput_ShouldThrow() {
		assertThrows(NullPointerException.class, () -> anagram.buildAnagram(null));
	}

}
