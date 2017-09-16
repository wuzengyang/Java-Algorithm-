package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceinArrays {
	
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 5));
		list.add(Arrays.asList(3, 4));

		
		System.out.println(maxDistance(list));
	}
	
	 public static int maxDistance(List<List<Integer>> arrays) {
	        
	        if (arrays == null || arrays.size() < 2) {
	            return 0;
	        }
	        
	        int large = Integer.MIN_VALUE;
	        int largeIndex = 0;
	        int secLarge = Integer.MIN_VALUE;
	        int secLargeIndex = 0; 
	        int small = Integer.MAX_VALUE;
	        int smallIndex = 0;
	        int secSmall = Integer.MAX_VALUE;
	        int secSmallIndex = 0;
	        
	        for (int i = 0; i < arrays.size(); i++) {
	            List<Integer> temp = arrays.get(i);
	            int size = temp.size();
	            
	            if (size == 0) {
	                continue;
	            }
	            
	            if (large < temp.get(size - 1)) {
	                secLarge = large;
	                secLargeIndex = largeIndex;
	                large = temp.get(size - 1);
	                largeIndex = i;
	            } else {
	            	secLarge = Math.max(secLarge, temp.get(size - 1));
	            }
	            
	            if (small > temp.get(0)) {
	                secSmall = small;
	                secSmallIndex = smallIndex;
	                small = temp.get(0);
	                smallIndex = i;
	            } else {
	            	secSmall = Math.min(secSmall, temp.get(0));
	            }
	        }
	        
	        System.out.println("Lar index: " + largeIndex);
	        System.out.println("secLar index: " + secLargeIndex);
	        System.out.println("Small index: " + smallIndex);
	        System.out.println("SecSmall index: " + secSmallIndex);
	        
	        if (largeIndex != smallIndex) {
	            return large - small;
	        }
	        
	        return Math.max(Math.abs(large - secSmall), Math.abs(secLarge - small));
	        
	    }

}
