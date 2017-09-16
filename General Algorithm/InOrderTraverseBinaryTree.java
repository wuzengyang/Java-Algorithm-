package laiOfferTest;

public class InOrderTraverseBinaryTree {
	
	public InOrderTraverseBinaryTree (TreeNode root) {
		inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.key + ", ");
		inOrder(root.right);
		return;
	}

}
