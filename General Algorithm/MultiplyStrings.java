package laiOfferTest;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		String a = "1234567";
		String b = "1234567";
		System.out.println(multiply(a, b));
				
		
	}
	
	
	
	  public static String multiply(String num1, String num2) {
		    
		    // assume both num1 and num2 contains only numers
		    if (num1.length() == 0 || num2.length() == 0){
		      return "";
		    }
		    
		    long number1 = 0;
		    long number2 = 0;
		    long result = 0;
		    
		    // Step 1: convert num1 and num2 to int numbers
		    for (int i = 0; i < num1.length(); i++) {
		      number1 = number1 * 10 + num1.charAt(i) - '0';
		    }
		    
		    for (int i = 0; i < num2.length(); i++) {
		      number2 = number2 * 10 + num2.charAt(i) - '0';
		    }
		    
		    result = number1 * number2;
		    
		    // Step3: convert final number to a string
		    StringBuilder sb = new StringBuilder();
		    if (result == 0) {
		      return new String("0");
		    }
		    
		    while (result > 0) {
		      char temp = (char) (result % 10 + '0');
		      sb.append(temp);
		      result = result / 10;
		    }
		    
		    return sb.reverse().toString();
		  }

}
