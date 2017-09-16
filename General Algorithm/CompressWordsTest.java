package laiOfferTest;

import java.util.*;

public class CompressWordsTest {
	
	public static void main(String[] args) {
		String test = "aaabcccdd";
		System.out.println(compress(test));
	}
	
	
  public static String compress(String input) {
    // write your solution here
    // the original string will be shorter after compression
    if (input == null || input.length() == 0) {
      return input;
    }
    int slow = 0;
    int fast = 0;
    char[] inputString = input.toCharArray();
    Queue<Letter> occurrences = new LinkedList<>();
    
    while (fast < inputString.length) {
      int count = 0;
      while (fast < inputString.length && (fast == slow || inputString[fast] == inputString[slow])) {
        fast++;
        count++;
      }
      occurrences.offer(new Letter(inputString[slow], count));
      slow = fast;
    }
    slow = 0;
    while (!occurrences.isEmpty()) {
      Letter temp = occurrences.poll();
      inputString[slow++] = temp.key;
      if (temp.count > 1) {
        inputString[slow++] = temp.count;
        System.out.println(temp.count);
      }
    }
    
    return new String(inputString, 0, slow);
  }
  

}



