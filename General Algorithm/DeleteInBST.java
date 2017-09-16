package laiOfferTest;

public class DeleteInBST {
	
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
		
		System.out.println(delete(n1, 5).key);
		System.out.println(n1.key);
	}

	
	  public static TreeNode delete(TreeNode root, int key) {
		    // Write your solution here.
		    
		    // terminate condition
		    if (root == null) {
		      return null;
		    } 
		    
		    if (root.key > key) {
		      root.left = delete(root.left, key);
		    } else if (root.key < key) {
		      root.right = delete(root.right, key);
		    } else {
		      // now root.key == key
		      //case 1: root is a leaf
		      if (root.left == null && root.right == null) {
		        return null;
		      } else if (root.left == null || root.right == null) { // case 2: has one child
		        return root.left == null? root.right : root.left;
		      } else {
		        // case 3: has two children
		        // find the smallest on right sub tree
		        // copy the key to root and then change call deleta recursion again
		        int newKey = findSmallest(root.right);
		        root.key = newKey;
		        System.out.println("The new Key is: " + newKey);
		        root.right = delete(root.right, newKey);
		      }
		    }
		    return root;
		  }
		  
		  public static int findSmallest(TreeNode root) {
		    // has ensured root is not null
		    int smallest = Integer.MAX_VALUE;
		    while(root != null) {
		      smallest = root.key;
		      root = root.left;
		    }
		    return smallest;
		  }
}
