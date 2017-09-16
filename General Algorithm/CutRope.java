package laiOfferTest;

public class CutRope {
	
	public static void main(String[] args) {
		int l = 12;
		System.out.println(maxProduct(l));
	}
	  public static int maxProduct(int length) {

		    // Zengyang's attempt
		    int[] result = new int[length+1];
		    result[0] = 0;
		    result[1] = 1;
		    result[2] = 1;
		    for (int i = 2; i <=length; i++) {
		      //int curMax = 0;
		      for (int j = 1; j < i; j++) {
		        result[i] = Math.max(result[i], Math.max(j,result[j])*(i - j));
		      }
		    }
		    return result[length];
		  }

}
