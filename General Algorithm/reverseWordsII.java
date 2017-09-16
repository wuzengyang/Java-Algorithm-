package laiOfferTest;

public class reverseWordsII {
	
		public static void main(String[] args) {
			String test = "an apple   ";
			System.out.println(reverseWords(test));
		}
	
	
		  public static String reverseWords(String input) {
			    // Write your solution here.
			    if (input == null || input.length() == 0) {
			      return input;
			    }
			    
			    // step one, removeheading and trailing space
			    
			    int headSpaceCount = 0;
			    for (int i = 0; i < input.length(); i ++) {
			      if (input.charAt(i) == ' ') {
			        headSpaceCount++;
			      } else {
			        break;
			      }
			    }
			    
			    int trailSpaceCount = 0;
			    for (int i = input.length() - 1; i >= 0; i--) {
			      if (input.charAt(i) == ' ') {
			        trailSpaceCount++;
			      } else {
			        break;
			      }
			    }
			    
			    // creat a new char[] without heading and trailling spaces
			    char[] noSpaceString = input.substring(headSpaceCount, input.length() - trailSpaceCount).toCharArray();
			    reverse(noSpaceString, 0, noSpaceString.length - 1);
			    reverseEachWord(noSpaceString);
			    return new String(noSpaceString);
			    
			  }
			  
			  public static void reverse(char[] input, int left, int right) {
			    char temp;
			    while(left < right) {
			      swap(input, left++, right--);
			    }
			  }
			  
					  public static void reverseEachWord(char[] input) {
					    int left = 0;
					    int right = 0;
					    for ( ; right < input.length; right++) {
					        while (right < input.length && input[right] != ' ') {
					          right++;
					        }
					        reverse(input, left, right - 1);
					        left = right + 1;
					      }
					  }
					  
			  
			  public static void swap(char[] input, int a, int b) {
			    char temp;
			    temp = input[a];
			    input[a] = input[b];
			    input[b] = temp;
			  }
	
	
//	  public static String reverseWords(String input) {
//		    // Write your solution here.
//		    if (input == null || input.length() == 0) {
//		      return input;
//		    }
//		    
//		    // step one, removeheading and trailing space
//		    
//		    int headSpaceCount = 0;
//		    for (int i = 0; i < input.length(); i ++) {
//		      if (input.charAt(i) == ' ') {
//		        headSpaceCount++;
//		      } else {
//		        break;
//		      }
//		    }
//		    
//		    int trailSpaceCount = 0;
//		    for (int i = input.length() - 1; i >= 0; i--) {
//		      if (input.charAt(i) == ' ') {
//		        trailSpaceCount++;
//		      } else {
//		        break;
//		      }
//		    }
//		    
//		    // creat a new char[] without heading and trailling spaces
//		    char[] noSpaceString = input.substring(headSpaceCount, input.length() - trailSpaceCount).toCharArray();
//		    reverse(noSpaceString, 0, noSpaceString.length - 1);
//		    reverseEachWord(noSpaceString);
//		    return new String(noSpaceString);
//		    
//		  }
//		  
//		  public static void reverse(char[] input, int left, int right) {
//		    char temp;
//		    while(left < right) {
//		      swap(input, left++, right--);
//		    }
//		  }
//		  
//		  public static void reverseEachWord(char[] input) {
//		    int left = 0;
//		    int right = 0;
//		    for ( ; right < input.length; right++) {
//		        while (right < input.length && input[right] != ' ') {
//		          right++;
//		        }
//		        reverse(input, left, right - 1);
//		        left = right + 1;
//		      }
//		  }
//		  
//		  public static void swap(char[] input, int a, int b) {
//		    char temp;
//		    temp = input[a];
//		    input[a] = input[b];
//		    input[b] = temp;
//		  }

}
