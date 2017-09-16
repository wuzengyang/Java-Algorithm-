package laiOfferTest;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayDeduplicationIV {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3, 3, 2, 4, 1};
		for (int i : dedup(test)){
			System.out.print(i + ", ");
		}
	}
	
	  public static int[] dedup(int[] array) {
		    // Write your solution here.
		    if (array.length <= 1) {
		      return array;
		    }
		    
		    // this time we need to use stack
		    Deque<Integer> stack = new LinkedList<>();
		    
		    int fast = 0;
		    //stack.offerFirst(array[0]);
		    while (fast < array.length) {
		      if (stack.isEmpty() || array[fast] != stack.peekFirst()) {
		        stack.offerFirst(array[fast++]);
		      } else {
		        while(fast < array.length && array[fast] == stack.peekFirst()) {
		          fast++;
		        }
		        stack.pollFirst();
		      }
		    }
		    return stackToInt(stack);
		  }
		  
	  public static int[] stackToInt(Deque<Integer> stack) {
		    int size  = stack.size();
		    int[] result = new int[size];
		    for (int i = 0; i < size; i++) {
		      result[i] = stack.pollLast();
		    }
		    return result;
		  }
		  
		  

}
