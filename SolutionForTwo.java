package algorithm150;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionForTwo {

	// 2.1
	public void withBuffer(Node n) {
		ArrayList<Integer> al = new ArrayList<>();

		Node pointer = n;
		while (pointer != null) {
			if (al.contains(pointer.data)) {
				n.deleteNode(pointer);
			} else {
				al.add(pointer.data);
			}

			pointer = pointer.next;

		}

	}

	@Test
	public void test1() {
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(2);
		Node n5 = new Node(3);
		Node n6 = new Node(6);
		Node n7 = new Node(0);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		withBuffer(n0);
		System.out.println(n0);

	}

	@Test
	public void generalTest() {
	}
}

class Node {

	public int data;
	public Node next;

	public Node(int d) {
		data = d;
	}

	public void append(int d) {
		if (this.next == null) {
			this.next = new Node(d);
		} else {
			Node n = new Node(d);
			n.next = this.next;
			this.next = n;
		}
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	public void deleteNode(Node n) {

		Node deleteNode = this;

		while (deleteNode.next != null) {
			if (deleteNode.next.equals(n)) {
				deleteNode.next = deleteNode.next.next;
				return; 
			}

			deleteNode = deleteNode.next;
		}

	}

	public String toString() {
		Node n = this;
		if (n.next == null) {
			return String.valueOf(n.data);
		} else {
			return n.data + "-->" + n.next.toString();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this.data == ((Node) obj).data) {
			if (this.next == null && ((Node) obj).next == null) {
				return true;
			} else if (this.next == ((Node) obj).next) {
				return true;
			}
		}
		return false;
	}
}