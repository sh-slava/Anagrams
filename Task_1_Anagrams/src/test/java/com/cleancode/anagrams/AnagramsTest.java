package com.cleancode.anagrams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class AnagramsTest {

	Anagrams anagram = new Anagrams();

	@ParameterizedTest(name = "{index}: argument injected ({0})")
	@MethodSource("argumentsProvider")
	void buildAnagram_shouldReverseWords(String input, String expected) {
		assertEquals(expected, anagram.buildAnagram(input));
	}

	public static Stream<Arguments> argumentsProvider() {
		return Stream.of(
				Arguments.arguments("a1bcd efg!h", "d1cba hgf!e"),
				Arguments.arguments("abc2f x34 !!@ 1fgr7", "fcb2a x34 !!@ 1rgf7"), 
				Arguments.arguments("abcd", "dcba"),
				Arguments.arguments("&%$!5-*@", "&%$!5-*@"), 
				Arguments.arguments("a", "a"),
				Arguments.arguments("aaaaa", "aaaaa"), 
				Arguments.arguments("aaaaAAaaAaA", "AaAaaAAaaaa"),
				Arguments.arguments("ABC", "CBA"), 
				Arguments.arguments("abc", "cba"), 
				Arguments.arguments("!", "!"),
				Arguments.arguments("", ""), 
				Arguments.arguments(" ", ""),
				Arguments.arguments("  ", "")
				);
	}

	@Test
	void buildAnagram_ShouldReturnNull_whenNull() {
		assertNull(anagram.buildAnagram(null));
	}
}

