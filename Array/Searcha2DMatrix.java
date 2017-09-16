package array;

public class Searcha2DMatrix {
	
	public static void main(String[] args) {
//		int[][] test = { {1,3,5,7},
//				{10,11,16,20},
//				{23,30,34,50}
//		};
		
		int[][] test = { {1},
				{3},
		};
		int t = 3;
		System.out.println(searchMatrix(test, t));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int N = matrix.length;
        int M = matrix[0].length;
        
        //find row
        int top = 0;
        int btm = N - 1;
        while(top < btm - 1) {
            int mid = top + (btm - top) / 2;
            
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                btm = mid;
            } else {
                top = mid;
            }
        }
        
  
        top = matrix[btm][0] <= target? btm : top;
        System.out.println("first check fine. row is " + top);
        
        int left = 0;
        int right = M - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (matrix[top][mid] == target) {
                return true;
            }
            
            if (matrix[top][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return false;
        
    }

}
