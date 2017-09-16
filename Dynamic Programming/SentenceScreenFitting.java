package DP;


public class SentenceScreenFitting {

	public static void main(String[] args) {
		String[] test = {"a", "bcd", "aaaaa", "aaa"};
		int rows = 4;
		int cols = 5;
		System.out.println(wordsTyping(test, rows, cols));
	}
	
	
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        //Assume sentence is not null and all elements in it are not null and not empty
        // First we nned to get a pattern
        int cur = 0;
        int N = sentence.length;
        int[] count = new int[N];
        int[] nextIndex = new int[N];
        for(int i = 0; i<N ; i++) {
            int curLen = 0;
            int time = 0;
            cur = i;
            while (curLen + sentence[cur].length() <= cols) {
                curLen = curLen + sentence[cur].length() + 1;
                cur++;
                if (cur == N) {
                    time++;
                    cur = 0;
                }
            }
            // now we find the next start index
            nextIndex[i] = cur;
            count[i] = time;
        }
        
        // 
        int result = 0;
        cur = 0;
        for (int i = 0; i < rows; i++) {
            result += count[cur];
            cur = nextIndex[cur];
        }
        return result;
        
    }
}
