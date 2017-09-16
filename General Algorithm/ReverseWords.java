package laiOfferTest;

public class ReverseWords {
	
	public static void main(String[] args){
		String test = "i love yahoo";
		System.out.println(reverseWords(test));
	}
	
	
	  public static String reverseWords(String input) {
	    // Write your solution here.
	    if (input == null || input.length() <= 1) {
	      return input;
	    }
	    char[] sentence = input.toCharArray();
	    reverse(sentence, 0, sentence.length - 1);
	    reverseEachWord(sentence);
	    return new String(sentence, 0, sentence.length);
	  }
	  
	  public static void reverse(char[] sentence, int left, int right) {
	    if (left >= right) {
	      return;
	    }
	    
	    swap(sentence, left, right);
	    reverse(sentence, left + 1, right - 1);
	  }
	  
	  public static void reverseEachWord(char[] sentence) {
	    int head = 0;
	    int end = 0;
	    while(end < sentence.length) {
	      while(end < sentence.length && sentence[end] != ' ') {
	        end++;
	      }
	      reverse(sentence, head, end -1);
	      end++;
	      head = end;
	    }
	  }
	  
	  public static void swap(char[] sentence, int left, int right) {
	    char temp;
	    temp = sentence[left];
	    sentence[left] = sentence[right];
	    sentence[right] = temp;
	  }
	}