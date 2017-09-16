package array;

public class SpiralMatrixII {
	
	public static void main(String[] args) {
		int[][] result = generateMatrix(0);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
    public static int[][] generateMatrix(int n) {
        
        if (n <= 0) {
            return new int[][] {};
        }
        
        int[][] result = new int[n][n];
        int count = 1;
        for (int offSet = 0; offSet <= n / 2; offSet++) {
            
            int newN = n - 2 * offSet;
            
            if (newN == 0) {
                break;
            }
            
            if (newN == 1) {
                result[offSet][offSet] = count;
                break;
            }
            // four Directions;
            for (int i = 0; i < newN - 1; i++) {
                result[offSet][i + offSet] = count++;
            }
            
            for (int i = 0; i < newN - 1; i++) {
                result[offSet + i][n - 1 - offSet] = count++;
            }
            
            for (int i = 0; i < newN - 1; i++) {
                result[n - 1 - offSet][n - 1 - offSet - i] = count++;
            }
            
            for (int i = 0; i < newN - 1; i++) {
                result[n - 1 - offSet - i][offSet] = count++;
            }
            
        }
        
        return result;
    }

}
