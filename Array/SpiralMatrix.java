package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static void main(String[] args) {
//		int[][] test = {{1, 1, 1, 2}, 
//						{4, 5, 5, 2},
//						{4, 6, 6, 2},
//						{4, 3, 3, 3}};
		int[][] test = {{1, 2, 3}, 
						{8, 9, 4},
						{7, 6, 5},
						};
		List<Integer> list = spiralOrder(test);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
	}
	
	
	
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        
        int offSet = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while(offSet <= M / 2) {
            int newN = N - 2 * offSet;
            int newM = M - 2 * offSet;
            
            if (newN == 0 || newM == 0) {
                return list;
            }
            
            if (newN == 1) {
                for (int i = 0; i < newM; i++) {
                    list.add(matrix[offSet][i + offSet]);
                }
                return list;
            }
            
            if (newM == 1) {
                for (int i = 0; i < newN; i++) {
                    list.add(matrix[offSet + i][offSet]);
                }
                return list;
            }
            
            // begin to rotate
            for (int i = 0; i < newM - 1; i++) {
                list.add(matrix[offSet][i + offSet]);
            }
            for (int i = 0; i < newN - 1; i++) {
                list.add(matrix[i + offSet][M - 1 - offSet]);
            }
            for (int i = newM - 1; i >= 1; i--) {
                list.add(matrix[N - 1 - offSet][offSet + i]);
            }
            for (int i = newN - 1; i >= 1; i--) {
                list.add(matrix[offSet + i][offSet]);
            }
            
            offSet++;
            
        }
        
        return list;
        
    }

}
