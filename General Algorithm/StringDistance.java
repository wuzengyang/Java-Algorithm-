package laiOfferTest;

public class StringDistance {
	
	public static void main(String[] args) {
		String[] test = {"this", "is", "a", "is", "fox", "happy"};
		String s = "fox";
		String t = "thissss";
		System.out.println(distance(test, s,t));
	}
	
	
	
	  public static int distance(String[] array, String s, String t) {
		    // Write your solution here.
		    if (s.length() == 0 || t.length() == 0) {
		      return 0;
		    }
		    
		    int globalMin = Integer.MAX_VALUE;
		    for (int i = 0; i < array.length; i++) {
		      if (array[i].equals(s)) {
		        for (int j = 0; j < array.length; j++) {
		          if (array[j].equals(t)) {
		            globalMin = Math.min(globalMin, Math.abs(i - j));
		          }
		        }
		      }
		    }
		    return globalMin == Integer.MAX_VALUE? -1 : globalMin;
		    
		  }

}
