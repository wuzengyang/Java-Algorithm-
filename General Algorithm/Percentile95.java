package laiOfferTest;

import java.util.ArrayList;
import java.util.List;

public class Percentile95 {
	
	public static void main(String[] args) {
		List<Integer> test = new ArrayList<>();
		final int k = 5;
		
		for (int i = 0; i < 1000; i++) {
			test.add(i + 1);
		}
		System.out.println(test.size());
		System.out.println(test.get(30));
		System.out.println(percentile95(test));
		System.out.println((double) test.size() * 0.95);
	}
	
	  public static int percentile95(List<Integer> lengths) {
		    // Write your solution here.
		    // assume this list is not null and is not empty
		    if (lengths.size() == 0) {
		      return 0;
		    }
		    
		    int[] lengthSet = new int[4097];
		    for (Integer temp : lengths) {
		      lengthSet[temp] ++;
		    // System.out.println(lengthSet[temp]);
		    }
		   
		    int count = 0;
		    int index = 0;
		    while (count <  lengths.size() * 0.95 ) {
		      count += lengthSet[index];
		      index++;
		   //   System.out.println(index);
		    }
		    return index - 1;
		  }

}
