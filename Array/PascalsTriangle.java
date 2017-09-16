package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		int test = 5;
		List<List<Integer>> result = generate(test);
		for (int i = 0; i < result.size(); i++) {
			List<Integer> temp = result.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + ", ");
			}
			System.out.println();
		}
	}
	
	
	
    public static List<List<Integer>> generate(int numRows) {
        
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }
            }
//            System.out.println(i + " is fine");
            list.add(temp);
        }
        
        return list;
        
    }

}
