package Vanguard.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFirstAnagram {

public static List<String> words(){
		
		List<String> wordsList = new ArrayList<>();
		
		wordsList.add("ride");
		wordsList.add("rat");
		wordsList.add("chair");
		wordsList.add("tar");
		wordsList.add("arc");
		
		return wordsList;
			
	}
	
	public static String findAnagram(List<String> words) {

		String anagram = "";
		String potentialAnagramWord = "";

		for (int i = 0; i < words.size() - 1; i++) {

			// establish a target word to look for anagram of
			String targetWord = words.get(i);

			int targetLength = targetWord.length();

			char[] targetWordArr = new char[targetLength];
			char[] potentialAnagramArr = new char[targetLength];

			for (int k = i + 1; k < words.size(); k++) {

				// only sort and order the target word if a word of
				// matching length to the target is found

				if (words.get(k).length() == targetLength) {

					for (int j = 0; j < targetLength; j++) {

						// populate targetArray with target word
						// instantiate & populate potentialAnagramArray
						// with potentialAnagramWord

						targetWordArr[j] = targetWord.charAt(j);

						potentialAnagramWord = words.get(k);

						potentialAnagramArr[j] = potentialAnagramWord.charAt(j);

					}

					Arrays.sort(targetWordArr);
					Arrays.sort(potentialAnagramArr);

					if (String.valueOf(targetWordArr).equals(String.valueOf(potentialAnagramArr))) {
						System.out.println("The Target word is : " + targetWord);
						System.out.println("The Anagram word is : " + potentialAnagramWord);
						return anagram = potentialAnagramWord;
					}
				}
			}
		}

			System.out.println("There was no anagram word!");

		System.out.println(anagram);
		return anagram;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findAnagram(words());
		
	}
	
}
