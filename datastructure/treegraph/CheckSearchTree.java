package algorithm150.datastructure.treegraph;

import org.junit.Test;

public class CheckSearchTree {
	public boolean ifBinarySearch(BinaryTreeNode root) {
		return ifBinarySearch(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean ifBinarySearch(BinaryTreeNode root, int minValue,
			int maxValue) {
		//take care of the base case
		if (root == null) {
			return true;
		}
		if (root.data > maxValue || root.data <= minValue) {
			return false;
		} else {
			return ifBinarySearch(root.left, minValue, root.data)
					&& ifBinarySearch(root.right, root.data, maxValue);
		}
	}

	public static int last_printed = Integer.MIN_VALUE;

	public boolean ifBinarySearch2(BinaryTreeNode root) {

		if (root == null) {
			return true;
		}

		if (!ifBinarySearch2(root.left))
			return false;

		if (root.data < last_printed)
			return false;
		last_printed = root.data;

		if (!ifBinarySearch2(root.right))
			return false;

		return true;
	}

	@Test
	public void test() {
		BinaryTreeNode root = new BinaryTreeNode(4);
		BinaryTreeNode left = new BinaryTreeNode(2);
		BinaryTreeNode right = new BinaryTreeNode(6);
		root.left = left;
		root.right = right;

		left.left = new BinaryTreeNode(1);
		left.right = new BinaryTreeNode(3);
		right.left = new BinaryTreeNode(5);
		right.right = new BinaryTreeNode(0);

		System.out.println(ifBinarySearch(root));
	}
}
