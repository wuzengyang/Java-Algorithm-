package array;

public class SetMatrixZeroes {
	
	public static void main(String[] args) {
//		int[][] test = {
//				{1, 1, 0, 1, 1, 1, 1, 1, 1},
//				{1, 1, 1, 1, 1, 1, 1, 1, 1},
//				{1, 1, 1, 1, 1, 1, 1, 1, 1},
//				{1, 1, 1, 1, 0, 1, 1, 1, 1},
//				{0, 1, 1, 1, 1, 1, 1, 1, 1},
//				{1, 1, 1, 1, 1, 1, 1, 0, 1}
//		};
		
		int[][] test = {
				{1, 1, 1},
				{0, 1, 2},
		};
		
		System.out.println("The original matrix is: ");
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		
		setZeroes(test);
		
		System.out.println("The modified matrix is: ");
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
    public static void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        // 2: this row/col set as 0 
        // 3: (0, 0) point, both row and col zero
        boolean check = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = j > 0 ? 0 : matrix[0][j];
                    
                    if (j == 0) {
                        check = true;
                    }
                }
            }
        }
        
		System.out.println("The checked matrix is: ___________________________");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
        

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[0][j] == 0 || matrix[i][0] == 0? 0 : matrix[i][j] ;
			}

		}
        
//        
//        for (int j = 1; j < matrix[0].length; j++) {
//            if (matrix[0][j] == 0) {
//                for (int i = 0; i < matrix.length; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        
        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (check) {
        	for (int i = 0; i < matrix.length; i++) {
        		matrix[i][0] = 0;
        	}
        }
        
        return;
        
        
    }

}
