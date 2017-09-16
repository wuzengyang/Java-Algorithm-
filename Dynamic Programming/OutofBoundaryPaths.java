package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OutofBoundaryPaths {
	
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int N = 3;
		int i = 0;
		int j = 1;
		System.out.println(findPaths(m, n, N, i, j));
		System.out.println(findPaths2(m, n, N, i, j));
		System.out.println(findPaths3(m, n, N, i, j));
	}
	
	
	
    public static int findPaths(int m, int n, int N, int i, int j) {
        
        if (m <= 0 || n <= 0 || N <= 0) {
            return 0;
        }
        
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        
        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(i, j, 1));
        long[][] result = new long[m][n]; 
        result[i][j] = 1;
        int moves = 1;
        while (moves < N) {   // here we dont need to consider the last step since once we go out it will never come back
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                Element temp = queue.poll();
                int row = temp.row;
                int col = temp.col;
                int value = temp.value;
                if (row - 1 >= 0) {
                    queue.offer(new Element(row - 1, col, value));
                    result[row - 1][col] += value;
                }
                if (row + 1 < m) {
                    queue.offer(new Element(row + 1, col, value));
                    result[row + 1][col] += value;
                }
                if (col - 1 >= 0) {
                    queue.offer(new Element(row, col - 1, value));
                    result[row][col - 1] += value;
                }
                if (col + 1 < n) {
                    queue.offer(new Element(row, col + 1, value));
                    result[row][col + 1] += value;
                }
                
            }
            moves++;
        }
        
        
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
            	System.out.print(result[k][l] + ", ");
            }           
            System.out.println();
        }
        System.out.println();
        // now we have one last move to go
        // just count all boundarys
        long count = 0L;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {          	
            	int weight = 0;
            	if (k - 1 < 0) {
            		weight++;
            	}
            	if (k + 1 >= m) {
            		weight++;
            	}
            	if (l - 1 < 0) {
            		weight++;
            	}
            	if (l + 1 >= n) {
            		weight++;
            	}
            	count += weight * result[k][l];
            }      
        }
        // count four corner once more
//        count = count + result[0][0] + result[0][n - 1] + result[m - 1][0] + result[m - 1][n - 1];
        System.out.println("Final count is " + count);
        return (int) count % (1000000007);
        
    }
    
    public static class Element {
        int row;
        int col;
        int value;
        
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    
    
    public static int findPaths2(int m, int n, int N, int i, int j) {
        
        if (m <= 0 || n <= 0 || N <= 0) {
            return 0;
        }
        
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        
        int[][] result = new int[m][n];
        result[i][j] = 1;
        for (int count = 1; count < N; count++) {
        	// scan the matrix
        	int[][] pre = new int[m][n];
 //       	pre[i][j] = 1;
 //       	pre[i][j] = count == 1 ? 1 : 0;
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {          	
                	if (k - 1 >= 0) {
                		pre[k - 1][l] += result[k][l];
                	}
                	if (k + 1 < m) {
                		pre[k + 1][l] += result[k][l];
                	}
                	if (l - 1 >= 0) {
                		pre[k][l - 1] += result[k][l];
                	}
                	if (l + 1 < n) {
                		pre[k][l + 1] += result[k][l];
                	}
                }      
            }
        	
        	
            result = pre;
            
    		for (int k = 0; k < m; k++) {
    			for (int l = 0; l < n; l++) {
    				System.out.print(result[k][l] + ", ");
    			}
    			System.out.println();
    		}
    		System.out.println();
        }
        
        
        

        
        long count = 0L;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {          	
            	int weight = 0;
            	if (k - 1 < 0) {
            		weight++;
            	}
            	if (k + 1 >= m) {
            		weight++;
            	}
            	if (l - 1 < 0) {
            		weight++;
            	}
            	if (l + 1 >= n) {
            		weight++;
            	}
            	count += weight * result[k][l];
            }      
        }
        

        return (int) count;
    }
    
    
    public static int findPaths3(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
            
    		for (int k = 0; k < m; k++) {
    			for (int l = 0; l < n; l++) {
    				System.out.print(count[k][l] + ", ");
    			}
    			System.out.println();
    		}
    		System.out.println();
        }
        
        return result;
    }

}
