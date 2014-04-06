package algorithm150.datastructure.treegraph;

/*
 * 4.3 Given a sorted(increasing order)array with unique integer elements
 * create a binary search tree with minimal height
 */
public class CreateBinaryTree {
	public BinaryTreeNode buildTree(BinaryTreeNode[] array) {
		int length = array.length;
		if (length == 1) {
			return array[0];
		} else if (length == 2) {
			array[1].left = array[0];
			return array[1];
		} else if (length == 3) {
			array[1].left = array[0];
			array[1].right = array[2];
			return array[1];
		} else {

			int mid = length / 2;

			BinaryTreeNode[] leftTree = new BinaryTreeNode[mid];
			BinaryTreeNode[] rightTree = new BinaryTreeNode[length - mid - 1];

			array[mid].left = buildTree(leftTree);
			array[mid].right = buildTree(rightTree);

			return array[mid];
		}
	}
}
