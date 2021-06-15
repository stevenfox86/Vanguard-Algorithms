package Vanguard.Algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class MostCommonCharacter {

	static String testCase1 = "cbabbaacc";
	static String testCase2 = "helloworld";
	static String testCase3 = "h";
	static String testCase4 = "";
	
	public static char maximumOccuringCharacter(String text) {
		
		//Validate the inputs
		
		//verify string length
		
		int textLength = text.length();
		
		if(textLength < 10) {
			System.out.printf("The string of length %s is invalid - too small! \n", textLength);
//			Throw an error to the calling function
		}

		if (textLength > 1000) {
			System.out.printf("The string of length %s is invalid - too large! \n", textLength);
//			Throw an error to the calling function
		}
		
		//verify characters with the text String are valid
		
//		Use text.contains(regex) to determine that only the allowed char's are in the string.
//		a-z, A-Z, 0-9
//		If text contains invalid char's throw an error to the calling function.
		
		

//		**CODE BEGINS FOR FUNCTION mostCommon**
		
		char charArray [] = text.toCharArray();
		
		Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
		
		
		for(int i = 0; i <charArray.length; i++) {

			
			if(!frequencyMap.containsKey(charArray[i])) {
				
				frequencyMap.put(charArray[i], 1);
			}
			
			else {
				
				frequencyMap.replace(charArray[i], frequencyMap.get(charArray[i]) +1);
//				frequencyMap.put(charArray[i], frequencyMap.get(charArray[i]) +1);
			}
			
		}
		
//		for(Map.Entry<Character, Integer> key : frequencyMap.entrySet())
//			System.out.println("the character was: " + key + " and the frequency was" + key.getValue());
		
		
		Map.Entry<Character, Integer> mostCommonChar = null;
		
		for(Map.Entry<Character, Integer> currentEntry : frequencyMap.entrySet()) {
			
			if (mostCommonChar == null || currentEntry.getValue().compareTo(mostCommonChar.getValue()) > 0) {
				
				mostCommonChar = currentEntry;
				
			}
		}
		
		if (mostCommonChar == null) {
			
			System.out.println("There is no input string.");
			return '\0';
			
		} 
		
		System.out.println(text + " test: the most common character was " + mostCommonChar.getKey());
		
		return mostCommonChar.getKey();
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test case 1:");
		maximumOccuringCharacter(testCase1);
		
		System.out.println("\ntest case 2:");
		maximumOccuringCharacter(testCase2);
		
		System.out.println("\ntest case 3:");
		maximumOccuringCharacter(testCase3);
		
		System.out.println("\ntest case 4:");
		maximumOccuringCharacter(testCase4);
		
	}
	
}
