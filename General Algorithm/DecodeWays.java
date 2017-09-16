package laiOfferTest;

public class DecodeWays {
	
	public static void main(String[] args) {
		String test = "110";
//		System.out.println(numDecodeWay(test));
		System.out.println(numDecodings(test));
	}

/*	public static int numDecodeWay(String s) {
		// Input your code here
		// for M[i], if s.charAt(i - 1) * 10 + s.charAt(i) < 26, then two string
		// can
		// decode to a letter together (10 - 26)
		// Thus for M[i], we only need to consider M[i - 1] and M[i - 2];
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}
		int[] result = new int[s.length() + 1];
		result[0] = 1;
		result[1] = 1;
		char[] input = s.toCharArray();
		for (int i = 2; i <= s.length(); i++) {
			if (!checkValid(input[i - 2], input[i - 1])) {
				return 0;
			}

			if (input[i - 1] == 0) {
				result[i] = result[i - 2];
			} else if (passCheck(input[i - 2], input[i - 1])) {
				System.out.println(input[i - 2] + ", " + input[i - 1]);
				result[i] = result[i - 2] + result[i - 1];
			} else {
				result[i] = result[i - 1];
			}
		}
		
		for (int temp : result) {
			System.out.print(temp + ", ");
		}
		System.out.println();
		return result[s.length()];
	}
	
	
	public static boolean passCheck(char a, char b) {
		int i1 = 10 * (a - '0');
		int i2 = b - '0';
		
		if (i1 + i2 > 26 || i1 + i2 <= 10) {
			return false;
		}
		System.out.println("i1 = " + i1 + "  i2 = " + i2);
		System.out.println(a + " and " + b + " passed the check");
		return true;
	}

	public static boolean checkValid(char a, char b) {
		if (b == '0' && (a > '2' || a == '0')) {
			return false;
		}
		return true;
	}*/

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
          
        if (s.length() == 1) {
            return 1;
        }
        
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = 1;
/*        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (!passZeroCheck(s, i - 1)) {
                    return 0;
                } else {
                    result[i] = result[i - 2];
                }
            } else {
                result[i] = passCheck(s, i -1) == true? result[i - 1] + result[i - 2] : result[i - 1];
            }
        }*/

		for (int i = 2; i <= s.length(); i++) {
			
			boolean check = passCheck(s, i - 1);
			if (check) {
				result[i] = s.charAt(i - 1) == '0'? result[i - 2] : result[i - 1] + result[i - 2];
			} else {
				result[i] = s.charAt(i - 1) == '0'? 0 : result[i - 1];
			}
			
			
//			if (s.charAt(i - 1) == '0' && ! check) {
//				continue;
//			} else {
//				result[i] = check? result[i - 1]
//						+ result[i - 2] : result[i - 1];
//			}
		}
        
        return result[s.length()];
    }
    
    public static boolean passZeroCheck(String s, int i) {
        // Have to ensure s.charAt(i) == '0'
        if (i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
            return true;
        }
        return false;
    }
    
    public static boolean passCheck(String s, int i) {
        if (i <= 0) {
            return false;
        }
        int value = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
        if (value >= 10 && value <= 26) {
            return true;
        }
        return false;
    }
}
