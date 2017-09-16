package laiOfferTest;

public class BinaryTreeToDeque {
	
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
		
		TreeNode newHead = toDeque(n1);
		TreeNode cur = newHead;
		while (cur != null) {
			System.out.print(cur.key + ", ");
			cur = cur.right;
		}
		
	}
	
	
	public static TreeNode toDeque(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode newHead = null;
		int[] count = new int[1];
		count[0] = 0;
		treeToDeque(root, root.right, newHead, count);
		return newHead;
	}
	
	public static void treeToDeque(TreeNode root, TreeNode preNode, TreeNode newHead, int[] count) {
		if (root == null) {
			if (count[0] == 0) {
				// The first time we reach null 
				newHead = preNode;
				count[0] = 1;
			}
			return;
		}
		
		treeToDeque(root.left, root, newHead, count);
		
		root.right = preNode;
		preNode.left = root;
		if (root.right != null) {
			treeToDeque(root.right, root, newHead, count);
		} else {
			return;
		}
		
		return;
		
		
	}

}
