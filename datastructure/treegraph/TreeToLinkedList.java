package algorithm150.datastructure.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TreeToLinkedList {
	public ArrayList<LinkedList<BinaryTreeNode>> transfer(BinaryTreeNode root) {
		ArrayList<LinkedList<BinaryTreeNode>> al = new ArrayList<>();

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.offer(root);
		level.offer(0);
		while (!queue.isEmpty()) {
			BinaryTreeNode head = queue.poll();
			Integer h = level.poll();
			if (head == null)
				continue;

			// if al doesn't have the linkedlist of the level (height + 1),
			// create it
			if (al.size() < h + 1) {
				al.add(new LinkedList<BinaryTreeNode>());
			}

			al.get(h).add(head);
			queue.offer(head.left);
			level.offer(h + 1);
			queue.offer(head.right);
			level.offer(h + 1);
		}

		return al;
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

		ArrayList<LinkedList<BinaryTreeNode>> al = transfer(root);
		System.out.println(al.size());

		for (int i = 0; i < al.size(); i++) {
			LinkedList<BinaryTreeNode> ll = al.get(i);
			for (int j = 0; j < ll.size(); j++) {
				System.out.print(ll.get(j).data + "==>");
			}
			System.out.println();
		}

	}

}
