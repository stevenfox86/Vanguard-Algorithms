package Vanguard.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class ToolList {

	public static List<String> tools() {

		List<String> tools = new ArrayList<>();

		// LIST
		tools.add("ballendmill");
		tools.add("facemill");
		tools.add("keywaycutter");
		tools.add("slotdrill");
		tools.add("tool1");
		tools.add("tool2");
		tools.add("tool3");
		tools.add("tool4");
		tools.add("tool5");
		tools.add("ballendmill");
//		tools.add("tool6");

		return tools;
	}

//	public static int startIndex = 1;
	 public static int startIndex = 5;

	// Target 1
	public static String target = "ballendmill";

	// Target 2
//	 public static String target = "tool5";

	// Target 3
//	 public static String target = "tool5";
	
	/*
	 
	 012345678
	 
	 1, 2, 3, 4, 5...
	 
	 -1, -2, -3, -4, -5... 
	 
	 
	 {1, -1}, {2, -2}, {3, -3}
	 
	 
	 */
	

	// things to check for:
	// total number of loops for small and large inputs
	// efficiency of a search
	// efficiency of a sort
	// memory allocation/utilization considerations
	
	
	
	public static int toolChanger(List<String> tools, int startIndex, String target) {
		
//		validate inputs
//		validate number of tools in toolsArray
		
		int tl_size = tools.size();
		if(tl_size <= 1 || tl_size >= 100) {
			System.out.printf("%s is not a valid array length!",tl_size);
			return -1;
			//Throw an error to the calling function
		}
		
//		validate value of startIndex
		
		if(startIndex < 0 || startIndex >= tools.size()-1) {
			System.out.printf("%s is not a valid startIndex!",startIndex);
			return -1;
//			Throw an error to the calling function
		}
		
//		validate that target is on toolsArray
		
		if(!tools.contains(target)){
			System.out.printf("%s is not in the tool tray!", target);
			return -1;
//			Throw an error to the calling function
		}
		
		
//		**CODE BEGINS FOR FUNCTION toolChanger**
		
		int leastTurns = 0;
		int rightTurns = 0;
		int leftTurns = 0;
		
		boolean isFound = false;
		
		String[] toolsArray = new String[tools.size()];
		
		toolsArray = tools.toArray(toolsArray);
		
//		for(int i = 0; i < toolsArray.length; i++) {
//		System.out.println(toolsArray[i]);
//		}
		
		int j = startIndex;
		
		
		// using a while. For loop may be cleaner code, consider for improvement 
		while(!isFound) {
			
			if(toolsArray[j] == target) {
				isFound = true;
				System.out.println("found target: " + toolsArray[j]);
			}	
			else {
				System.out.println(toolsArray[j]);
				rightTurns++;
				j++;
				
				if(j == toolsArray.length) {
					j = 0;
					
				}
			}	
		}
		
		System.out.println("__________________");
//		Reset isFound boolean to false before turning tool changer in opposite direction
		isFound = false;
		int k = startIndex;
		
		while(!isFound) {
			
			if(toolsArray[k] == target) {
				isFound = true;
				System.out.println("found target: " + toolsArray[k]);
			}
			else {
				System.out.println(toolsArray[k]);
				leftTurns++;
				k--;
				
				if(k == 0) {
					if(toolsArray[k] == target) {
						isFound = true;
						System.out.println("found target: " + toolsArray[k]);
					}
					else {
						k = toolsArray.length-1;
					}
				}
			}
		}
		
		
		
		
		if(rightTurns <= leftTurns) {
			leastTurns = rightTurns;
		}
		else {
			leastTurns = leftTurns;
		}
		
		System.out.println("__________________");
		System.out.println("rightTurns: " + rightTurns);
		System.out.println("leftTurns: " + leftTurns);
		System.out.println("leastTurns: " + leastTurns);
		return leastTurns;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		toolChanger(tools(), startIndex, target);
		
	}
	
}
