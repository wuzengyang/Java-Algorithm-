package array;

import java.util.Arrays;

public class LeastInsertionsTFormAPalindrome {
	
	public static void main(String[] args) {
		String test = "abaad";
		System.out.println(leastInsertion(test));
	}
	
	
	  public static int leastInsertion(String input) {
		    // Write your solution here.
		    // find the longest palindrome subsequence and then minus string length
		    if (input == null || input.length() <= 1) {
		      return 0;
		    }
		    int[] result = new int[input.length() + 1];
		    String reverse = reverseString(input);
		    System.out.println("reversed string is: " + reverse);
		    for (int i = 1; i <= input.length(); i++) {
		    	int[] pre = Arrays.copyOf(result, result.length);
		      for (int j = 1; j <= input.length(); j++) {
		        if (input.charAt(i - 1) == reverse.charAt(j - 1)) {
		          result[j] = pre[j - 1] + 1;
		        } else {
		          result[j] = Math.max(pre[j], result[j - 1]);
		        }
		        System.out.print(result[j] + ", ");
		      }
		      System.out.println();
		    }
		    
		    return input.length() - result[input.length()];
		  }
		  
		  public static String reverseString(String input) {
		    char[] inputArray = input.toCharArray();
		    int left = 0;
		    int right = inputArray.length - 1;
		    while (left <= right) {
		      char temp = inputArray[left];
		      inputArray[left] = inputArray[right];
		      inputArray[right] = temp;
		      left++;
		      right--;
		    }
		    
		    return String.valueOf(inputArray);
		  }

}
