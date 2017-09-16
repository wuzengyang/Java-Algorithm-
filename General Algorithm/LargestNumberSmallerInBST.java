package laiOfferTest;


public class LargestNumberSmallerInBST {

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
		
		System.out.println(largestSmaller(n1, 10));
	}

	public static int largestSmaller(TreeNode root, int target) {
		// Write your solution here.
		// root is not null, and this is a bst

		int largest = Integer.MIN_VALUE;
		while (root != null) {
			// case one: root.key >= target, do not update largest;
			if (root.key >= target) {
				root = root.left;
			} else { // case two, do the update
				largest = Math.max(root.key, largest);
				root = root.right;
			}
		}
		return largest;
	}

}
