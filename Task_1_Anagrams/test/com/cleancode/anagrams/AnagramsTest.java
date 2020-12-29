package com.cleancode.anagrams;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramsTest {

	Anagrams anagram = new Anagrams();

	@ParameterizedTest(name = "{index}: argument injected ({0})")
	@MethodSource("argumentsProvider")
	public void buildAnagram_shouldReverseWords_whenStreamOfArguments(String input, String expected) {
		assertEquals(expected, anagram.buildAnagram(input));
	}

	public static Stream<Arguments> argumentsProvider() {
		return Stream.of(Arguments.arguments("a1bcd efg!h", "d1cba hgf!e"), Arguments.arguments("abcd", "dcba"),
				Arguments.arguments("&%$!5-*@", "&%$!5-*@"), Arguments.arguments("a", "a"),
				Arguments.arguments("!", "!"), Arguments.arguments("", ""), Arguments.arguments(" ", ""));
	}

	@Test
	public void buildAnagram_ShouldReturnNull_whenNull() {
		assertNull(anagram.buildAnagram(null));
	}
}

