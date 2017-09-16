package laiOfferTest;
import java.util.*;

public class DecompressString {
	  
	public static void main(String[] args) {
		String test = "ab2c3d4";
		System.out.println(decompress(test));
	}
	
	public static String decompress(String input) {
		    // Write your solution here.
		    if (input == null || input.length() == 0) {
		      return input;
		    }
		    char[] inputString = input.toCharArray();
		    // check how many extra spaces we need
		    int spaceCount = 0;
		    for (char temp : inputString) {
		      if ((int) temp > 50 && (int) temp <= 57) {
		        spaceCount += (int) temp - 50;
		      }
		    }
		    
		    // begin decompress
		    char[] result1 = new char[inputString.length + spaceCount];
		    int index = 0;
		    for (char temp1 : inputString) {
		      if ((int) temp1 >= 97) {
		        result1[index++] = temp1;
		      } else if ((int) temp1 >= 50 && (int) temp1 <= 57) {
		        for (int i = 0; i <= (int) temp1 - 50; i++) {
		          result1[index] = result1[index - 1]; 
		          index++;
		        } 
		      }
		    }
		    
		    
		    //String finalResult =  String.valueOf(result1);
		    return new String(result1);
	  }
}
