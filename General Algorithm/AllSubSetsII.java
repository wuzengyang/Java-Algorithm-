package laiOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AllSubSetsII {
	
	
	public static void main(String[] args) {
		String set = "abab";
		List<String> result = subSets(set);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ", ");
		}
		//System.out.print(result.size());
		
	}

	public static List<String> subSets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}

		if (set.length() == 0) {
			result.add("");
			return result;
		}
		char[] charSet = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		Arrays.sort(charSet);
		allSubSets(charSet, 0, sb, result);
		return result;
	}

	public static void allSubSets(char[] set, int index, StringBuilder sb,
			List<String> result) {

		// termination condition
		if (index == set.length) {
				result.add(sb.toString());
			return;
		}

		// actions in this layer
		sb.append(set[index]);
		allSubSets(set, index + 1, sb, result);
		sb.deleteCharAt(sb.length() - 1);

		while (index + 1 < set.length
				&& set[index + 1] == set[index]) {
			index++;
		}

		allSubSets(set, index + 1, sb, result);
		return;
	}

}
