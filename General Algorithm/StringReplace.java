package laiOfferTest;

import java.util.LinkedList;
import java.util.Queue;

public class StringReplace {
	
	
	  public static void main(String[] args) {
		  String input = "student student student student student student";
		  String s = "den";
		  String t1 = "X";
		  String t2 = "XXXX";
		  System.out.println(replace(input, s, t1));
		  System.out.println(replace(input, s, t2));
	  }
	
	  public static String replace(String input, String s, String t) {
	    // Write your solution here.
	    if (input == null) {
	      return input;
	    }
	    
	    // find the index of the begining of the replacement
	    char[] inputString = input.toCharArray();
	    char[] target = s.toCharArray();
	    char[] replace = t.toCharArray();
	    
	    Queue<Integer> index = new LinkedList<>();
	    int fast = 0;
	    //int check = 0;
	    while (fast < inputString.length) {
	      int check = 0;
	      while (fast + check < inputString.length && check < target.length) {
	        if (inputString[fast + check] == target[check]) {
	          check++;
	        } else {
	          break;
	        }
	      }
	      if (check == target.length) {
	        index.offer(fast);
	        fast +=  target.length; // avoid duplicate check
	      } else {
	        fast++; 
	      }
	    }
	    
	    System.out.println(index.size());
	    if (target.length >= replace.length) {
	      return shorterReplacement(inputString, index, target, replace);
	    } else {
	      return longerReplacement(inputString, index, target, replace);
	    }
	  }
	  
	  public static String shorterReplacement(char[] input, Queue<Integer> index, char[] s, char[] t) {
	    // when s longer than t, no extra space is needed. do in place operation
	    int slow = 0; 
	    int fast = 0;
	    while(fast < input.length) {
	      if (index.isEmpty() || fast != index.peek()) {
	        input[slow++] = input[fast++];
	      } else {
	    	  index.poll();
	        for (int i = 0; i < t.length; i++) { 	
	          input[slow++] = t[i];
	        }
	        fast += s.length; 
	      }
	    }
	    return new String(input, 0, slow);
	  }
	  
	  public static String longerReplacement(char[] input, Queue<Integer> index, char[] s, char[] t) {
	    // when t is longer than s, extra space is needed
	    // a new char array will be created with extended space.
	    char[] result = new char[input.length + index.size() * (t.length - s.length)];
	    int slow = 0;
	    int fast = 0;
	    while (fast < input.length) {
	      if (index.isEmpty() || fast != index.peek()) {
	        result[slow++] = input[fast++];
	      } else {
	    	 index.poll();
	        for (int i = 0; i < t.length; i++) {
	        	
	          result[slow++] = t[i];
	        }
	        fast += s.length;
	      }
	    }
	    return new String(result);
	  }
	}