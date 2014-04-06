package algorithm150.datastructure.treegraph;

import org.junit.Test;

/*
 * 4.1 check if a binary tree is balanced(AVL tree).
 */
public class CheckBalance {

	public boolean ifBalanced(BinaryTreeNode root) {
		if (getHeight(root) == 0) {
			return true;
		} else if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		} else {
			return ifBalanced(root.left) && ifBalanced(root.right);
		}
	}
	
	

	public int getHeight(BinaryTreeNode root) {
		if (root.left == null && root.right == null) {
			return 0;
		} else if (root.left == null) {
			return 1 + getHeight(root.right);
		} else if (root.right == null) {
			return 1 + getHeight(root.left);
		} else {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
		}
	}

	@Test
	public void test() {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode left = new BinaryTreeNode(2);
		BinaryTreeNode right = new BinaryTreeNode(3);
		root.left = left;
		root.right = right;

		left.left = new BinaryTreeNode(4);
		left.right = new BinaryTreeNode(5);
		left.left.left = new BinaryTreeNode(10);
		System.out.println(ifBalanced(root));
	}
}
