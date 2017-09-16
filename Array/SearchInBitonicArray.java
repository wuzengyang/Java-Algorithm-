package array;

public class SearchInBitonicArray {
	
	public static void main(String[] args) {
		int[] test = {1, 4, 7, 11, 6, 2, -3, -8};
		int target = 2;
		System.out.println(search(test, target));
	}
	
	
	  public static int search(int[] array, int target) {
		    // Write your solution here.
		    if (array == null || array.length == 0) {
		      return -1;
		    }
		    int peakIndex = findPeak(array);
		    if (array[peakIndex] == target) {
		      return peakIndex;
		    }
		    
		    if (array[peakIndex] < target) {
		      return -1;
		    }
		    
		    int left = findLeft(array, 0, peakIndex, target);
		    int right = findRight(array, peakIndex, array.length - 1, target);
		    
		    return left == -1? right : left;

		  }  
		  
		  public static int findPeak(int[] array) {
		    int left = 0;
		    int right = array.length - 1;
		    
		    
		    while (left < right - 1) {
		      int mid = left + (right - left) / 2;
		      if (array[mid] > array[mid - 1]) {
		        // ascending
		        left = mid;
		      } else {
		        right = mid;
		      }
		    }
		    int index = array[left] > array[right]? left: right;
		    System.out.println("Peak is at i = " + index);
		    return array[left] > array[right]? left: right;
		  }
		  
		  public static int findLeft(int[] array, int left, int right, int target) {
		    
		    while (left <= right) {
		      int mid =left + (right - left) / 2;
		      if (array[mid] == target) {
		        return mid;
		      }
		      
		      if (array[mid] < target) {
		        left = mid + 1;
		      } else {
		        right = mid - 1;
		      }
		    }
		    
		    return -1;
		  }
		  
		    public static int findRight(int[] array, int left, int right, int target) {
		    
		    while (left <= right) {
		      int mid =left + (right - left) / 2;
		      if (array[mid] == target) {
		        return mid;
		      }
		      
		      if (array[mid] > target) {
		        left = mid + 1;
		      } else {
		        right = mid - 1;
		      }
		    }
		    
		    return -1;
		  }

}
