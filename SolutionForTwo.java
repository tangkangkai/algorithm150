package algorithm150;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

import org.junit.Test;

public class SolutionForTwo {

	// 2.1
	public void withBuffer(LinkedListNode n) {
		ArrayList<Integer> al = new ArrayList<>();

		LinkedListNode pointer = n;
		while (pointer != null) {
			if (al.contains(pointer.data)) {
				n.deleteLinkedListNode(pointer);
			} else {
				al.add(pointer.data);
			}

			pointer = pointer.next;

		}
	}

	public void usingHashTable(LinkedListNode n) {
		LinkedListNode previous = n;
		Hashtable table = new Hashtable<>();

		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}

	}

	public void withoutBuffer(LinkedListNode n) {
		LinkedListNode head = n;

		while (head != null) {
			LinkedListNode current = head.next;
			while (current != null) {
				if (head.data == current.data) {
					n.deleteLinkedListNode(current);
				}
				current = current.next;
			}
			head = head.next;
		}
	}

	// 2.2
	public LinkedListNode kthToLastNode(int k, LinkedListNode n) {
		int index = n.length() - k;

		while (index > 0 && n != null) {
			index -= 1;
			n = n.next;
		}

		return n;
	}

	class Wrapper {
		public int value = 0;
	}

	public LinkedListNode kthToLastNode2(int k, Wrapper i, LinkedListNode n) {
		if (n == null) {
			return null;
		}

		LinkedListNode testNode = kthToLastNode2(k, i, n.next);
		i.value += 1;
		
		if(i.value == k) {
			return n;
		}

		return testNode;
	}
	
	//2.3 
	//copy the data of next node to the current node, and delete the next node
	public void deleteMiddle(LinkedListNode n) {
		n.data = n.next.data;
		n.deleteLinkedListNode(n.next);
	}
	
	//2.4
	
	@Test
	public void test1() {
		LinkedListNode n0 = new LinkedListNode(0);
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(2);
		LinkedListNode n5 = new LinkedListNode(3);
		LinkedListNode n6 = new LinkedListNode(6);
		LinkedListNode n7 = new LinkedListNode(0);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		// System.out.println(n0);
		// usingHashTable(n0);
		// System.out.println(n0);

		System.out.println(n0);
		deleteMiddle(n3);
		System.out.println(n0);
		n0.appendToTail(5);
		System.out.println(n0);


	}

	@Test
	public void generalTest() {
	}
}

class LinkedListNode {

	public int data;
	public LinkedListNode next;

	public LinkedListNode(int d) {
		data = d;
	}

	public void append(int d) {
		if (this.next == null) {
			this.next = new LinkedListNode(d);
		} else {
			LinkedListNode n = new LinkedListNode(d);
			n.next = this.next;
			this.next = n;
		}
	}

	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	public void deleteLinkedListNode(LinkedListNode n) {

		LinkedListNode deleteLinkedListNode = this;

		while (deleteLinkedListNode.next != null) {
			if (deleteLinkedListNode.next.equals(n)) {
				deleteLinkedListNode.next = deleteLinkedListNode.next.next;
				return;
			}

			deleteLinkedListNode = deleteLinkedListNode.next;
		}

	}

	public int length() {
		LinkedListNode n = this;
		int k = 0;
		while (n != null) {
			k += 1;
			n = n.next;
		}

		return k;
	}

	public String toString() {
		LinkedListNode n = this;
		if (n.next == null) {
			return String.valueOf(n.data);
		} else {
			return n.data + "-->" + n.next.toString();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this.data == ((LinkedListNode) obj).data) {
			if (this.next == null && ((LinkedListNode) obj).next == null) {
				return true;
			} else if (this.next == ((LinkedListNode) obj).next) {
				return true;
			}
		}
		return false;
	}
}