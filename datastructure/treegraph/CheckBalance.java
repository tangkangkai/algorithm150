package algorithm150.datastructure.treegraph;

import org.junit.Test;

/*
 * 4.1 check if a binary tree is balanced(AVL tree).
 */
public class CheckBalance {

	public boolean ifBalanced(BinaryTreeNode root) {
		if (getHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public int getHeight(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			if (leftHeight == -1 || rightHeight == -1
					|| Math.abs(leftHeight - rightHeight) > 1) {
				return -1;
			}
			return 1 + Math.max(leftHeight, rightHeight);
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
