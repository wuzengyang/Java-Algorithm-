package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	
	public static void main(String[] args) {
		int test = 0;
		System.out.println(getRow(test));
	}
	
    public static List<Integer> getRow(int rowIndex) {
        
        if (rowIndex < 0) {
            return new ArrayList<Integer>();
        }
        
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        int[] result = new int[rowIndex + 1];
 //       int[] pre = new int[rowIndex + 1];
        result[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            int[] pre = Arrays.copyOf(result, i);
            System.out.println("At row " + i);
            for (int j = 0; j < i + 1; j++) {
                result[j] = j == 0 || j == i? 1 : pre[j - 1] + pre[j];
                System.out.print(result[j] + ", ");
            }
            System.out.println();
        }
        
        List<Integer> row = new ArrayList<>();
        for (int temp : result) {
        	row.add(temp);
        }
        
        return row;
    }

}
