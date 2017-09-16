package laiOfferTest;

public class BiToHex {
	
		public static void main(String[] args) {
			int a = 35434399;
			System.out.println(hex(a));
		}
		
	  public static String hex(int number) {
		    // Write your solution here.
		    if (number == 0) {
		      return "0x0";
		    }
		    
		    final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7',
		      '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		    int temp = number;
		    StringBuilder hex = new StringBuilder();
		    
		    while ( temp != 0) {
		      hex.append(table[temp%16]);
		      temp = temp/ 16;
		    }
		    hex.append("x0");
		    return hex.reverse().toString();

		  }   

}
