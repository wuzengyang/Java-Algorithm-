package laiOfferTest;

public class SearchInBST {

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
		
		System.out.println(search(n1, 13) == null);
		System.out.println(search(n1, 13).key);
	}
	
	

	public static TreeNode search(TreeNode root, int key) {
		// Write your solution here.
		if (root == null) {
			return null;
		}

		TreeNode cur = root;
		while (cur != null) {
			if (cur.key > key) {
				cur = cur.left;
			} else if (cur.key < key) {
				cur = cur.right;
			} else {
				return cur;
			}
		}

		return cur;
	}
}
