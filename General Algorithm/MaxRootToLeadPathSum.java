package laiOfferTest;

public class MaxRootToLeadPathSum {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
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
		n6.right = n8;
		//n7.right = n9;
		
		System.out.println(maxPathSum(n1));
	}

	

	public static int maxPathSum(TreeNode root) {
		// Write your solution here.
		if (root == null) {
			return 0;
		}
		//return getMaxPath(root);
		int[] globalMax = new int[1];
		globalMax[0] = Integer.MIN_VALUE;
		getMaxPath2(root, 0, globalMax);
		return globalMax[0];
	}

	public static int getMaxPath(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// expections from sublaygers
		int left = getMaxPath(root.left);
		int right = getMaxPath(root.right);

		return Math.max(left, right) + root.key;
	}
	
	public static void getMaxPath2(TreeNode root, int preSum, int[] globalMax) {
		// termination condition
		if (root == null) {
			return;
		}
		
		// actions in this layer?
		if (root.left == null && root.right == null) {
			// now we reached a leaf
			globalMax[0] = Math.max(globalMax[0], preSum + root.key);
			return;
		}
		
		//continue recursion
		getMaxPath2(root.left, preSum + root.key, globalMax);
		getMaxPath2(root.right, preSum + root.key, globalMax);
		
		
		
	}

}
