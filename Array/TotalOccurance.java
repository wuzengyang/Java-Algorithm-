package array;

public class TotalOccurance {

	public static void main(String[] args) {
		int[] test = {1, 3, 5};
		int t = 2;
		System.out.println(totalOccurrence(test, t));
	}
	
	  public static int totalOccurrence(int[] array, int target) {
		    // Write your solution here
		    // find the largest smaller than and smallest larger than
		    if (array == null || array.length == 0) {
		      return 0;
		    }
		    
		    int left = 0, right = array.length - 1;
		    
		    // find largest element smaller than target
		    while (left < right - 1) {
		      int mid = left + (right - left) / 2;
		      if (array[mid] >= target) {
		        right = mid;
		      } else {
		        left = mid;
		      }
		    }
		    
		    int sIndex = 0;
		    if (array[right] < target) {
		      sIndex = right;
		    } else if (array[left] < target) {
		      sIndex = left;
		    } else {
		      sIndex = left - 1;
		    }
		    // then find smallest element larger than target
		    left = 0;
		    right = array.length - 1;
		    while (left < right - 1) {
		      int mid = left + (right - left) / 2;
		      if (array[mid] <= target) {
		        left = mid;
		      } else {
		        right = mid;
		      }
		    }
		    int rIndex = 0;
		    if (array[left] > target) {
		      rIndex = left;
		    } else if (array[right] > target) {
		      rIndex = right;
		    } else {
		      rIndex = right + 1;
		    }

		    return rIndex - sIndex - 1;
		  }
}
