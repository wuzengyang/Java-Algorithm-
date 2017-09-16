package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeAddition {
	
	public static void main(String[] args) {
		int[][] test = {{1, 3, 2},
						{2, 4, 3},
						{0, 2, -2}};
		int l = 5;
		int[] result = getModifiedArray(l, test);
		for (int i : result) {
			System.out.print(i + ", ");
		}
	}
	
    public static int[] getModifiedArray(int length, int[][] updates) {
        
        
        if (length <= 0 || updates == null || updates.length == 0 || updates[0].length == 0) {
            return new int[length]; 
        }
        
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int left = updates[i][0];
            int right = updates[i][1];
            int inc = updates[i][2];
            result[left] += inc;
            
            if (right + 1 < length) {
            	result[right + 1] = result[right + 1] - inc;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++) {
        	sum += result[i];
            result[i] = sum;
        }
        
        return result;
        
    }

}
