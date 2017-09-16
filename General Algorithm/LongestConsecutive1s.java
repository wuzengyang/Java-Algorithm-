package laiOfferTest;

public class LongestConsecutive1s {
	
		public static void main(String[] args) {
			int[] test = {1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1};
			System.out.println(longest(test));
			
		}
	
	
	
	  public static int longest(int[] array) {
		    // Write your solution here.
		    if (array.length == 0) {
		      return 0;
		    }
		    int globalMax = 0;
		    int curMax = 0;
		    int start = 0;
		    int end = 0;
		    for (int i = 0; i < array.length; i++) {
		      if (array[i] == 0) {
		        curMax = 0;
		        //start = i;
		      } else {
		        curMax += 1;
		      }
		      if (curMax > globalMax) {
		        globalMax = curMax;
		        end = i;
		        start = end - globalMax + 1;
		      }
		    }
		    System.out.println("the start is: " + start);
		    System.out.println("the end is: " + end);
		    return globalMax;
		  }

}
