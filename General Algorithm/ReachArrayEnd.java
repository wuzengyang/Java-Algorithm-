package laiOfferTest;

public class ReachArrayEnd {
	
	public static void main(String[] args){
		int[] test = {4, 2, 1, 2, 0, 0};
		System.out.println(canJump(test));
	}
	
	
	  public static boolean canJump(int[] array) {

		  boolean[] result = new boolean[array.length];
		  
		  if (array.length == 1) {
		      return true;
		  }
		  
		  for (int i = 0; i < array.length; i++) {
			  result[i] = false;
		  }
		  
		  if (array[array.length - 1] > 0) {
		    result[array.length - 1] = true;
		  }
		  
		  for (int i = array.length - 2; i >= 0; i--) {
		    for (int j = 1; j <= array[i]; j++) {
		      if (i + j >= array.length || result[i + j]) {
		        result[i] = true;
		        break;
		      }
		    }  
		  }
		  return result[0];
		  
		  }

}
