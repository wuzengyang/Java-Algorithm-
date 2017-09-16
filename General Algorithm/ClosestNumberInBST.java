package laiOfferTest;


public class ClosestNumberInBST {
	
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
		
		System.out.println(closest(n1, -80));
	}
	
	
	  public static int closest(TreeNode root, int target) {
		    // Write your solution here.
		    // we have assumed that root is not null
		    int minDiff = Integer.MAX_VALUE;
		    int key = root.key;
		    while (root != null) {
		      //case 1: root.key = null
		      if (root.key == target) {
		        minDiff = 0;
		        key = root.key;
		        break;
		      } else if (root.key > target) {  // case two
		        if (minDiff > root.key - target) {
		          minDiff = root.key - target;
		          key = root.key;
		        }
		        root = root.left;
		      } else { // case 3: key < target
		        if (minDiff > target- root.key) {
		          minDiff = target - root.key;
		          key = root.key;
		        }
		        root = root.right;
		      }
		    }
		    
		    return key;
		  }
}
