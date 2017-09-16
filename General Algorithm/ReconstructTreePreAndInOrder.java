package laiOfferTest;

import java.util.HashMap;
import java.util.Map;

public class ReconstructTreePreAndInOrder {

	public static void main(String[] args) {
//		 int[] in = { 2, 5, 7, 10, 12, 15, 20 };
//		 int[] pre = {10, 5, 2, 7, 15, 12, 20 };
		
//		 int[] pre = {5, 3, 1, 4, 8, 11};
//		 int[] in = {1, 3, 4, 5, 8, 11};

//		int[] pre = { 1, 2, 4, 5, 6, 7, 8, 9, 3, 10, 11, 12, 14, 13 };
//		int[] in = { 4, 2, 6, 8, 7, 9, 5, 1, 10, 3, 12, 14, 11, 13 };
		 
		int[] in = { 1,6,5,7,4,10,9};
		int[] pre = {4,1,5,6,7,10,9};


		TreeNode root = reconstruct(in, pre);
		new InOrderTraverseBinaryTree(root);

	}

	public static TreeNode reconstruct(int[] in, int[] pre) {
		// Write your solution here.
		if (in.length == 0 || pre.length == 0) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		//TreeNode root = new TreeNode(pre[0]);
		//constructTree(root, 0, pre.length - 1, 0, in.length - 1, map, in, pre);
		//return root;
		return constructTree2(in, 0, in.length -1 , pre, 0, pre.length, map);
	}

	public static void constructTree(TreeNode root, int preLeft, int preRight,
			int inLeft, int inRight, Map<Integer, Integer> map, int[] in,
			int[] pre) {
		if (inLeft > inRight) {
			return;
		}

		int curIndex = map.get(root.key);
		if (curIndex != inLeft) {
			root.left = new TreeNode(pre[preLeft + 1]);
		}

		if (curIndex != inRight) {
			root.right = new TreeNode(pre[preLeft + curIndex - inLeft + 1]);
		}

		constructTree(root.left, preLeft + 1, preLeft + curIndex - inLeft,
				inLeft, curIndex - 1, map, in, pre);
		constructTree(root.right, preLeft + curIndex - inLeft + 1, preRight,
				curIndex + 1, inRight, map, in, pre);
		return;
	}

	public static TreeNode constructTree2(int[] in, int inLeft, int inRight,
			int[] pre, int preLeft, int preRight, Map<Integer, Integer> map) {
		if (inLeft > inRight) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preLeft]);
		int leftSize = map.get(root.key) - inLeft;

		root.left = constructTree2(in, inLeft, inLeft + leftSize - 1, pre,
				preLeft + 1, preLeft + leftSize, map);
		root.right = constructTree2(in, inLeft + leftSize + 1, inRight, pre,
				preLeft + leftSize + 1, preRight, map);

		return root;

	}

}
