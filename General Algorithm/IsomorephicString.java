package laiOfferTest;
import java.util.*;

public class IsomorephicString {
	
	public static void main(String[] args) {
		String a = "asd";
		String b = "das";
		System.out.println(isomorphic(a, b));
	}
	
	
	
	  public static boolean isomorphic(String s, String t) {
		    // Write your solution here.
		    // use two hashset
		    // Assume s and t are not null
		    // as long as s and t have same length and same kinds of characters
		    // s and t will be isomorphic
		    
		    
		    if (s.length() != t.length()) {
		      return false;
		    }
		    
		    // check char types in s and t
		    char[] s1 = s.toCharArray();
		    char[] t1 = t.toCharArray();
		    Set<Character> setS = new HashSet<>();
		    Set<Character> setT = new HashSet<>();
		    
		    for (int i = 0; i < s1.length; i++) {
		      if (!setS.contains(s1[i])) {
		        setS.add(s1[i]);
		      }
		      
		      if (!setT.contains(t1[i])) {
		        setT.add(t1[i]);
		      }
		    }
		    
		    return setS.size() == setT.size();
		  }

}
