package algorithm150.datastructure.treegraph;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BreadthFirstSearch {
	public void breadthFirstSearch(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Queue<Integer> height = new LinkedList<Integer>();
		queue.offer(root);
		height.offer(0);
		while (!queue.isEmpty()) {
			BinaryTreeNode head = queue.poll();
			Integer h = height.poll();
			if (head == null)
				continue;
			System.out.println(h + "  " + head.data);
			queue.offer(head.left);
			height.offer(h + 1);
			queue.offer(head.right);
			height.offer(h + 1);
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
		right.left = new BinaryTreeNode(6);
		right.right = new BinaryTreeNode(7);

		

		breadthFirstSearch(root);
		
	}
}
