package Vanguard.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickingTickets {

	public static List<Integer> createList(){
		
		List<Integer> tickets = new ArrayList<>();
		tickets.add(8);
		tickets.add(5);
		tickets.add(4);
		tickets.add(8);
		tickets.add(4);
		
//		List<Integer> tickets = new ArrayList<>();
//		tickets.add(4);
//		tickets.add(13);
//		tickets.add(2);
//		tickets.add(3);
		
//		List<Integer> tickets = new ArrayList<>();
//		tickets.add(4);
//		tickets.add(4);
//		tickets.add(5);
//		tickets.add(7);
//		tickets.add(9);
//		tickets.add(10);
//		tickets.add(11);
//		tickets.add(12);
		
//		List<Integer> tickets = new ArrayList<>();
//		tickets.add(4);
//		tickets.add(5);
//		tickets.add(7);
//		tickets.add(8);
//		tickets.add(9);
//		tickets.add(10);
//		tickets.add(12);
		
//		List<Integer> tickets = new ArrayList<>();
//		tickets.add(4);
	
//		List<Integer> tickets = new ArrayList<>();
				
		return tickets;
		
	}	

	// things to check for:
	// total number of loops for small and large inputs
	// efficiency of a search
	// efficiency of a sort
	// memory allocation/utilization considerations
	
	
	public static int maxTickets(List<Integer> tickets) {
		
//		validate inputs
		
//		validate size of ticketsList
		
		int tik_length = tickets.size();
		
		if(tik_length < 1) {
//			Throw an error to the calling function
			System.out.printf("The tickets array of length %s is invalid - too short", tik_length);
		}
		
		if(tik_length > 100000) {
//			Throw an error to the calling function
			System.out.printf("The tickets array of length %s is invalid - too long", tik_length);
		}
		
//		validate elements of the ticketsList
		
		
		for(int e = 0; e < tickets.size(); e++) {
		
			int tik_value = tickets.get(e);
			
			if(tik_value < 1 || tik_value > 1000000000) {
				
//				Throw an error to the calling function
				System.out.printf("The ticket element %s of value %s is invalid",e , tik_value);
			}
		}
		
		
//		**CODE BEGINS FOR FUNCTION MaxTickets**
		
		Integer[] array = new Integer[] {tickets.size()};
		
		array = tickets.toArray(array);	
		
		Arrays.sort(array);
		// if size(tickets)>10000: use merge sort
		
		for(int x=0; x<array.length; x++) {
			System.out.println(array[x]);
		}
		
		
		
		System.out.println("__________________________");
		List<Integer> tempList = new ArrayList<>();
		
		int maxSize = 0;
		int tempCounter = 0;
		
		for(int i=0; i<array.length; i++) {
			
			if (i == 0 || (array[i] == array[i-1]) || ((array[i]) == array[i-1]+1)) {

				tempList.add(array[i]);
				
				if(tempList.get(tempCounter) == null) {
					maxSize = 0;
				}
				
				
				else if(tempList.size() > maxSize) {	
					maxSize = tempList.size();
				}
				
			}
			
			else {
				
				tempList = new ArrayList<>();
				tempList.add(array[i]);
				tempCounter = 0;			
			}
		}
		
		for(int j=0; j<tempList.size(); j++) {
			System.out.println(tempList.get(j));
		}
		
		
		System.out.println("__________________________");
		System.out.println("the largest subsequence is: " + maxSize);
		return maxSize;
	}
	
	public static void main(String[] args) {

		maxTickets(createList());
		
	}	
}
