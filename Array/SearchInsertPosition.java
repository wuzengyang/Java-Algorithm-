package array;

public class SearchInsertPosition {
	
	public static void main(String[] args) {
		int[] test = {2,2,2,4,7,14};
		int t = 2;
		System.out.println(searchInsert(test, t));
	}
	
	
	
	  public static int searchInsert(int[] input, int target) {
		    if (input == null || input.length == 0) {
		      return 0;
		    }
		    
		    int left = 0;
		    int right = input.length - 1;
		    while (left < right - 1) {
		      int mid = left + (right - left) / 2;
		      if (input[mid] >= target) {
		        right = mid;
		      } else {
		        left = mid;
		      }
		    }
		    
		    System.out.println(left + ", " + right);
		    if (input[right] < target) {
		      return right + 1;
		    } else if (input[left] < target) {
		      return right;
		    } else {
		      return left;
		    }
		  }

}
