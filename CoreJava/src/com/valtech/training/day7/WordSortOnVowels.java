package com.valtech.training.day7;

import java.util.Map;

public class WordSortOnVowels {
	
	public static void main(String[] args) {
		WordSortOnVowels ws = new WordSortOnVowels();
		System.out.println(ws.sortingString("Hello, How are you"));
		System.out.println(ws.sortingString("Stand in the queue"));
		System.out.println(ws.sortingString("eau de parfum"));
		System.out.println(ws.sortingString("look by the lynx"));
	}

	private char[] sortingString(String inputString) {
//		break string into words
		String[] words = splitWords(inputString);
//		Count vowels
		Map<String, Integer> percent = percentageOfVowelsToConsonants(Map<words, >);
//		sort the words based on vowel %age
		String[] sorted = sortedString(inputString);
		return null;
	}

	private float percentageOfVowelsToConsonants(String[] words) {
		
		return 0;
	}

	private String[] splitWords(String inputString) {
		String[] words = inputString.split(" ");
		return words;
	}

}
