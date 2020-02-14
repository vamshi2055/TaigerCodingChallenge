package com.taiger.romannamescompare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RomanNamesComparision {

	private static Map<Character, Integer> romanCharactersToInteger = new HashMap<>();

	private static int convertRomanToInteger(String roman) {

		assignBasicRomanToInt();

		char[] arr = roman.toCharArray();

		int total = 0;
		int maxNumericVal = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = romanCharactersToInteger.get(arr[i]);
			if (val >= maxNumericVal) {
				maxNumericVal = val;
				total += val;
			} else {
				total -= val;
			}
		}
		return total;
	}

	private static void assignBasicRomanToInt() {

		romanCharactersToInteger.put('I', 1);
		romanCharactersToInteger.put('V', 5);
		romanCharactersToInteger.put('X', 10);
		romanCharactersToInteger.put('L', 50);
		romanCharactersToInteger.put('C', 100);

	}

	public static Set<String> getSortedList(List<String> names) {

		Set<String> sortedNames = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String romanName1, String romanName2) {
				String[] romanName1Split = romanName1.split(" ");
				String[] romanName2Split = romanName2.split(" ");

				if (romanName1Split[0].compareTo(romanName2Split[0]) == 0) {
					int roman1 = convertRomanToInteger(romanName1Split[1]);
					int roman2 = convertRomanToInteger(romanName2Split[1]);

					return (roman1 == roman2 ? 0 : (roman1 > roman2 ? 1 : -1));

				} else {
					return romanName1Split[0].compareTo(romanName2Split[0]);
				}
			}
		});

		sortedNames.addAll(names);
		return sortedNames;

	}

	public static void main(String[] args) {

		List<String> inputNames = Arrays.asList("Louis IX", "Louis VIII", "David II");

		Set<String> sortedNames = getSortedList(inputNames);

		for(String sortedName:sortedNames) {
			
			System.out.println(sortedName);
		}

	}
}