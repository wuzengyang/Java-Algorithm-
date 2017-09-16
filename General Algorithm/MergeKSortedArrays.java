package laiOfferTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	
	public static void main(String[] args) {
		int[][] test = {{},{1,5,7},{4},{2,3,5,11},{2,4,4,6,8}};
		System.out.println("test.length is: " + test.length);
		System.out.println("test[0].length is: " + test[0].length);
		System.out.println("test[0].length is: " + test[1].length);
		
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("The final array is: ");
		
		int[] result = merge(test);
		for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + ", ");
		}

	}

	  public static int[] merge(int[][] arrayOfArrays) {
		    // Write your solution here.
		    // arrayofArray isn ot null
		    int row = arrayOfArrays.length;

		    int length = 0;
		    for (int i = 0; i < row; i ++) {
		      length += arrayOfArrays[i].length;
		    }
		    System.out.println("result length is: " + length);
		    int[] result = new int[length];
		    
		    PriorityQueue<element> minHeap = new PriorityQueue<element>(
		    		16, new Comparator<element>() {
		    			@Override
		    			public int compare(element e1, element e2) {
		    				if (e1.value == e2.value) {
		    					return 0;
		    				} 
		    				
		    				return e1.value < e2.value? -1 : 1;
		    			}
		    		}
		    		
		    		/*16, new MyComparator()*/);
		    
		    // first initialize this minHeap
		    for (int i = 0; i < row; i++) {
		    	if (arrayOfArrays[i].length == 0) {
		    		continue;
		    	}
		      minHeap.offer(new element(arrayOfArrays[i][0], i, 0));
		    }
		    // begin to merge
		    int count = 0;
		    while(!minHeap.isEmpty()) {
		      element temp = minHeap.poll();
		      result[count++] = temp.value;
		      if (temp.index_col < arrayOfArrays[temp.index_row].length - 1) {
		        minHeap.offer(new element(arrayOfArrays[temp.index_row][temp.index_col + 1],
		                        temp.index_row, temp.index_col + 1));
		      }
		    }
		    
		    return result;
		    
		  }
		  
		 public static class element /*implements Comparable<element> */{
		    int value;
		    int index_row;
		    int index_col;
		    public element(int value, int row, int col) {
		      this.value = value;
		      index_row = row;
		      index_col = col;
		    }
		    
		    
/*		    public int compareTo(element another) {
		      if (this.value == another.value) {
		        return 0;
		      }
		      return this.value < another.value? -1 : 1;
		    }*/
		  }
		 


}
