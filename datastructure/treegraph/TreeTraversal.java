package algorithm150.datastructure.treegraph;

import java.util.Stack;

import org.junit.Test;

public class TreeTraversal {

	Stack<BinaryTreeNode> btStack = new Stack<>();
	BinaryTreeNode current = null;

	// Pre-Order recursion
	public void preOrderRecursion(BinaryTreeNode bt) {
		if (bt != null) {
			System.out.print(bt.data + "  ");
			preOrderRecursion(bt.left);
			preOrderRecursion(bt.right);
		}
	}

	// Pre-Order interation
	public void preOrderIteration(BinaryTreeNode bt) {
		BinaryTreeNode current = bt;
		while (current != null || !btStack.isEmpty()) {
			if (current != null) {
				System.out.print(current.data + "  ");// print the data when
														// pushed into the stack
				btStack.push(current);
				current = current.left;
			} else {
				current = btStack.pop();
				current = current.right;
			}
		}
	}

	// In-Order recursion
	public void inOrderRecursion(BinaryTreeNode bt) {
		if (bt != null) {
			inOrderRecursion(bt.left);
			System.out.print(bt.data + "  ");
			inOrderRecursion(bt.right);
		}
	}

	// In-Order Iteration
	public void inOrderIteration(BinaryTreeNode bt) {
		current = bt;
		while (current != null || !btStack.isEmpty()) {
			if (current != null) {
				btStack.push(current);
				current = current.left;
			} else {
				current = btStack.pop();
				System.out.print(current.data + "  ");// print the data when
														// popped out of stack
				current = current.right;
			}
		}

	}

	// Post-Order Recursion
	public void postOrderRecursion(BinaryTreeNode bt) {
		if (bt != null) {
			postOrderRecursion(bt.left);
			postOrderRecursion(bt.right);
			System.out.print(bt.data + "  ");
		}

	}

	// Post-Order Iteration
	public void postOrderIteration(BinaryTreeNode bt) {
		current = bt;
		while (current != null || !btStack.isEmpty()) {
			if (current != null) {
				btStack.push(current);
				current = current.left;
			} else {
				current = btStack.pop();
				if (current.isFinished) { // we use isFinished as a flag to see
											// if both of the children have been
											// visited.
					System.out.print(current.data + "  ");
					current = null;
				} else {
					current.isFinished = true;
					btStack.push(current);
					current = current.right;
				}
			}
		}

	}

	@Test
	public void generalTest() {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode left = new BinaryTreeNode(2);
		BinaryTreeNode right = new BinaryTreeNode(3);
		root.left = left;
		root.right = right;

		left.left = new BinaryTreeNode(4);
		left.right = new BinaryTreeNode(5);
		right.left = new BinaryTreeNode(6);
		right.right = new BinaryTreeNode(7);
		System.out.println("========Pre Order Test=========");
		preOrderRecursion(root);
		System.out.println();
		preOrderIteration(root);
		System.out.println();

		System.out.println("========In Order Test=========");
		inOrderRecursion(root);
		System.out.println();
		inOrderIteration(root);
		System.out.println();

		System.out.println("========Post Order Test=========");
		postOrderRecursion(root);
		System.out.println();
		postOrderIteration(root);
	}
}

class BinaryTreeNode {
	int data;
	boolean isFinished;
	BinaryTreeNode left = null;
	BinaryTreeNode right = null;

	public BinaryTreeNode(int data) {
		this.data = data;
	}
}
