package laiOfferTest;

public class ReorderArray {
	
		public static void main(String[] args) {
			int[] test =  new int[9];
			for (int i = 0; i < 9; i++) {
				test[i] = i;
			}
			test = reorder(test);
			for (int i = 0; i < test.length; i ++) {
					System.out.println(test[i]);
			}
		}

		  public static int[] reorder(int[] array) {
		    // Write your solution here.
		    if (array.length == 0) {
		      return array;
		    }
		    if (array.length % 2 == 0) {
		      helper(array, 0, array.length - 1);
		    } else {
		      helper(array, 0, array.length - 2);
		    }
		    return array;
		  }
		  
		  public static void helper (int[] array, int left, int right) {
		    // base case
		    if (right - left <= 1) {
		      return; 
		    }
		    
		    int size = right - left + 1;
		    int mid = left + size / 2;
		    int leftMid = left + size / 4;
		    int rightMid = left + size * 3/4;
		    
		    reverse(array, leftMid, mid - 1);
		    reverse(array, mid, rightMid - 1);
		    reverse(array, leftMid, rightMid - 1);
		    helper(array, left, left + 2 * (leftMid - left) - 1);
		    helper(array, left + 2 * (leftMid - left), right);
		  } 
		  
		  public static void reverse (int[] array, int left, int right) {
		    while (left <= right) {
		      swap(array, left, right);
		      left++;
		      right--;
		    }
		  }
		  
		  public static void swap(int[] array, int a, int b) {
		    int temp;
		    temp = array[a];
		    array[a] = array[b];
		    array[b] = temp;
		  }
		  
		

}
