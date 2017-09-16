package array;

public class FindtheCelebrity {

    public int findCelebrity(int n) {
        
        if (n <= 0) {
            return -1;
        }
        
        int index = 0;
        int check = 1;
        
        while (check < n) {
            if (!knows(index, check)) {
                check++;
                continue;
            }
            
            index = check;
            check += 1;
        }
        
        // then check if this one knows anybody
        for (int i = 0; i < n; i++) {
            if (i == index) {
                continue;
            }
            
            if (knows(index, i) || !knows(i, index)) {
                return -1;
            }
        }
        
        return index;
        
    }
    
    public boolean knows(int a, int b) {
    	return true;
    }
	
}
