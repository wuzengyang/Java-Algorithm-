package laiOfferTest;

public class Shuffle {
	
	  public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		shuffle(array);
		for (int i : array) {
			System.out.println(i);
		}
	  }
	  
	  public static void shuffle(int[] array) {
		    // Write your solution here.
		    if (array.length == 0) {
		      return;
		    }
		    
		    //int size = array.length - 1;
		    for (int i = array.length - 1; i > 0; i--) {
		      int index = (int) ((i + 1) * Math.random());
		      swap(array, index, i);
		    }
		  }
		  
		  public static void swap(int[] array, int a, int b) {
		    int temp = array[a];
		    array[a] = array[b];
		    array[b] = temp;
		  }

}
