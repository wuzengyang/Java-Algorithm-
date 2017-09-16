package laiOfferTest;

public class DecompressII {
	
	public static void main(String[] args) {
		String test = "a5b3c0d0f3f1";
		System.out.println(decompress(test));
	}
	
//	  public static String decompress(String input) {
//		    // Write your solution here.
//		    if (input.length() == 0) {
//		      return input;
//		    }
//		    
//		    // find if we need to resize
//		    char[] inputString = input.toCharArray();
//		    int count = 0;
//		    for(char temp : inputString) {
//		      if ((int)temp >= 50 && (int) temp <= 57) {
//		        count += (int) temp - 50; // if 0, two less space, if 1, one less space
//		      } 
//		    }
//		    
//		    return helper(inputString, count);
//		  }
//		  
//		  
//		  public static String helper(char[] input, int count) {
//
//		    char[] result = new char[input.length + count];
//		    int index = 0;
//		    int fast = 0;
//		    while(fast < input.length) {
//		      if ((int)input[fast] >= 97) {
//		        result[index++] = input[fast++];
//		      } else if ((int) input[fast] == 48) {
//		    	  fast++;
//		        index--;
//		      } else if ((int) input[fast] == 49) {
//		        fast++;
//		      } else {
//		        for (int i = 0; i <= (int) input[fast] - 50; i++) {
//		          result[index] = result[index - 1];
//		          index++;
//		        }
//		        fast++;
//		      }
//		    }
//		    return new String(result, 0, index);
//		  }
	
	  public static String decompress(String input) {
		    // Write your solution here.
		    if (input.length() == 0) {
		      return input;
		    }
		    
		    // find if we need to resize
		    char[] inputString = input.toCharArray();
		    int count = 0;
		    for(char temp : inputString) {
		      if (temp >= '2' && temp <= '9') {
		        count += (int) temp - 50; // if 0, two less space, if 1, one less space
		      } 
		    }
		    
		    return helper(inputString, count);
		  }
		  
		  
		  public static String helper(char[] input, int count) {

		    char[] result = new char[input.length + count];
		    int index = 0;
		    int fast = 0;
		    while(fast < input.length) {
		      if (input[fast] >= 'a') {
		        result[index++] = input[fast++];
		      } else if (input[fast] == '0') {
		        index--;
		        fast++;
		      } else if (input[fast] == '1') {
		        fast++;
		      } else {
		        for (int i = 0; i <= (int) input[fast] - 50; i++) {
		          result[index] = result[index - 1];
		          index++;
		          
		        }
		        fast++;
		      }
		    }
		    return new String(result, 0, index);
		  }
		  

}
