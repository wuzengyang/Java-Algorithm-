package array;

public class RotateImage {
	
	public static void main(String[] args) {
		int[][] test = {
				{5,1,9,11},
				{2,4,8,10},
				{13,3,6,7},
				{15,14,12,16}
		};
		rotate(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test.length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	
	
    public static void rotate(int[][] matrix) {
        //
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int N = matrix.length;
        
        // first left and right switch
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                swap(matrix, i, j, i, N - 1 - j);
            }
        }
        System.out.println("After the first step");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
        // left-top and right bottom swap
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N -i; j++) {
                swap(matrix, N - 1 - i - j, i, N - 1 - i, i + j);
            }
        }
        
        return;
        
    }
    
    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

}
