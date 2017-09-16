package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		int[] test = {25, 10, 5, 1};
		List<List<Integer>> result = combinationSum(test, 99);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, 0, list, result);
        return result;
    }
    
    public static void helper(int[] array, int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (index >= array.length) {
            return;
        }
        
        for (int i = 0; i <= target / array[index]; i++) {
            
        	for (int j = 0; j < i; j++) {
        		list.add(array[index]);
        	}
        	
            helper(array, target - i * array[index], index + 1, list, result);  
            
            for (int j = 0; j < i; j++) {
            	list.remove(list.size() - 1);
            }
        }
        
    }
}
