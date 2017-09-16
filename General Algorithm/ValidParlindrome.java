package laiOfferTest;

public class ValidParlindrome {
	
	public static void main(String[] args) {
		String test = "an apple:) elp pana#";
		System.out.print(valid(test));
	}
	
	
	  public static boolean valid(String input) {
		    // Write your solution here.
		    if (input == null) {
		      return false;
		    }
		    
		    if (input.length() == 0) {
		      return true;
		    }
		    
		    char[] inputString = input.toCharArray();
		    int head = 0;
		    int end = inputString.length - 1;
		    //int count =0;
		    
		    while(head < end) {
		      if (((inputString[head] >= 48 && inputString[head] <= 57) ||
		          (inputString[head] >= 65 && inputString[head] <= 90) ||   
		          (inputString[head] >= 97 && inputString[head] <= 122)) &&
		          ((inputString[end] >= 48 && inputString[end] <= 57) ||
		          (inputString[end] >= 65 && inputString[end] <= 90) ||   
		          (inputString[end] >= 97 && inputString[end] <= 122))) {
		          
		          if (inputString[head] != inputString[end]) {
		            return false;
		          }
		          head++;
		          end--;
		      } else if ((inputString[head] >= 48 && inputString[head] <= 57) ||
		                 (inputString[head] >= 65 && inputString[head] <= 90) ||   
		                 (inputString[head] >= 97 && inputString[head] <= 122)) {
		                   end--;
		      } else if ((inputString[end] >= 48 && inputString[end] <= 57) ||
		                 (inputString[end] >= 65 && inputString[end] <= 90) ||   
		                 (inputString[end] >= 97 && inputString[end] <= 122)){
		                  head++;
		      } else {
		        head++;
		        end--;
		      }
		    }
		    
		    return true;
		  }

}
