package laiOfferTest;

public class NumberOfWords {
	
	public static void main(String[] args) {
		String test = "A 	B \n \t CD E EWEWEW			 	MM";

		System.out.println(test);
		System.out.println(numOfWords(test));
	}
	
	
	
	  public static int numOfWords(String input) {
		    // Write your solution here.
		    // Assume this string is not null
		    if (input.length() == 0) {
		      return 0;
		    }
		    int count = 0;
		    int i = 0;
		    char[] inputString = input.toCharArray();
		    while (i < inputString.length) {
		      if (inputString[i] == ' ') {
		        i += 1;
		      } else if (inputString[i] == '\n' || inputString[i] == '\t') {
		        i += 1;
		      } else {
		        count++;
		        while(i < inputString.length && (inputString[i] != ' ' && inputString[i] != '\n' && inputString[i] != '\t')) {
		          i++;
		        }
		      }
		    }
		    return count;
		  }

}
