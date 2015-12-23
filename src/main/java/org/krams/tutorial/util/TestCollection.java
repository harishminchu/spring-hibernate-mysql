package org.krams.tutorial.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TestCollection {

	public static void main(String[] args) {

		String words = "hello how are you boss";

		Scanner scanner = new Scanner(words);

		BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
		LinkedHashMap<Integer, String> list = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> list1 = new LinkedHashMap<>();
		for (int i = 0; i < words.length(); i++) {

			if (scanner.hasNext()) {
				list.put(i, scanner.next());

			}

		}
		System.out.println(list);

	}

}
