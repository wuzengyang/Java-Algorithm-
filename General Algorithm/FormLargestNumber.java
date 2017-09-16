package laiOfferTest;
import java.util.*;

public class FormLargestNumber {
	
	public static void main(String[] args) {
		String[] test = {"400","4","40","13","400001","52","41","44000"};
		System.out.println(largestNumber(test));
	}
	
	
	
	  public static String largestNumber(String[] input) {
		    // Write your solution here.
		    if (input.length == 0) {
		      return "";
		    }
		    
		    PriorityQueue<String> result = new PriorityQueue<>(
		    		16, new Comparator<String>() {
		    			@Override
		    			public int compare(String a, String b) {
		    				/*
		    			    if (a.equals(b)) {
		    			    	return 0;
		    				}
		    				    
		    				int minLength = Math.min(a.length(), b.length());
		    				int index = 0;
		    				while (index < minLength) {
		    					if (a.charAt(index) > b.charAt(index)) {
		    				        return -1;
		    				    } else if (a.charAt(index) < b.charAt(index)) {
		    				        return 1;
		    				    }
		    				      index++;
		    				}
		    				    
		    				    
		    				if (a.length() > b.length()) {
		    					while(index < a.length()) {
		    						if (a.charAt(index) > b.charAt(0)) {
		    							return -1;
		    						} else if (a.charAt(index) < b.charAt(0)) {
		    							return 1;
		    						}
		    						index++;
		    					}
		    				} else {
		    					while(index < b.length()) {
		    						if (b.charAt(index) > a.charAt(0)) {
		    							return 1;
		    						} else if (b.charAt(index) < a.charAt(0)) {
		    							return -1;
		    						}
		    						index++;
		    					}
		    				}
		    				return -1; */
		    				
		    				String str1 = a + b;
		    				String str2 = b + a;
		    				return str2.compareTo(str1);
		    			}
		    			
		    		});
		    
		    for (String temp : input) {
		    	result.offer(temp);
		    }
		    
		    StringBuilder sb = new StringBuilder();
		    while (!result.isEmpty()) {
		    	sb.append(result.poll());
		    }

		    return sb.toString();
		  }
		  	  
}
