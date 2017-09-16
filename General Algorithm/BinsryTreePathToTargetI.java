package laiOfferTest;

import java.util.HashSet;
import java.util.Set;

public class BinsryTreePathToTargetI {
	
	public static void main(String[] args) {
/*		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(13);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(-100);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n9;
		n3.left = n6;
		n3.right = n7;
		n6.right = n8;*/
		
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(-8);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(10);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(-5);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(-2);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n8;
		n3.left = n6;
		n3.right = n7;
		n4.right = n9;
		//n7.right = n9;
		
		System.out.println(exist(n1, 7));
	}

	public static boolean exist(TreeNode root, int target) {
		// Write your solution here.
		if (root == null) {
			return false;
		}

		Set<Integer> set = new HashSet<>();	
		System.out.println(set.size());
		return checkExist(root, target, 0, set);
	}

	public static boolean checkExist(TreeNode root, int target, int preSum,
			Set<Integer> set) {
		// termination conditions
		// case1 : did not find any possible combinations
		if (root == null) {
			return false;
		}

		// case 2: find the target
		if (root.key == target || preSum + root.key == target) {
			return true;
		}

		// actions in this layer
		

		// what to return?
		if (set.contains(preSum + root.key - target)) {
			return true;
		} 
		boolean needRemove = set.add(preSum + root.key);
		if (root.right != null && checkExist(root.right, target, preSum + root.key, set)) {
			return true;
		}
		
		if (root.left != null && checkExist(root.left, target, preSum + root.key, set)) {
			return true;
		}
		
		if (needRemove) {
			set.remove(preSum + root.key);
		}
		
		return false;
	}

}
