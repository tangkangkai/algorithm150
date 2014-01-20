package algorithm150;

import java.util.ArrayList;
import java.util.Hashtable;

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

		if (i.value == k) {
			return n;
		}

		return testNode;
	}

	// 2.3
	// copy the data of next node to the current node, and delete the next node
	public void deleteMiddle(LinkedListNode n) {
		n.data = n.next.data;
		n.deleteLinkedListNode(n.next);
	}

	// 2.4
	public LinkedListNode partition(LinkedListNode n, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		LinkedListNode traversalNode = n;
		while (traversalNode != null) {
			if (traversalNode.data < x) {
				if (beforeStart == null) {
					beforeStart = traversalNode;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = traversalNode;
					beforeEnd = traversalNode;
				}
			} else {
				if (afterStart == null) {
					afterStart = traversalNode;
					afterEnd = afterStart;
				} else {
					afterEnd.next = traversalNode;
					afterEnd = traversalNode;
				}
			}
			traversalNode = traversalNode.next;
		}

		if (beforeStart == null) {
			return afterStart;
		} else {
			beforeEnd.next = afterStart;
			return beforeStart;
		}

	}

	public LinkedListNode partition2(LinkedListNode n, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterSttart = null;

		while (n != null) {
			LinkedListNode next = n.next;

			if (n.data < x) {
				n.next = beforeStart;
				beforeStart = n;
			} else {
				n.next = afterSttart;
				afterSttart = n;
			}
			n = next;
		}

		if (beforeStart == null) {
			return afterSttart;
		}

		LinkedListNode link = beforeStart;

		while (link.next != null) {
			link = link.next;
		}
		link.next = afterSttart;
		return beforeStart;
	}

	// 2.5
	public LinkedListNode addListReverse(LinkedListNode n1, LinkedListNode n2) {
		LinkedListNode sumList = new LinkedListNode(0);
		LinkedListNode travelList = sumList;
		int flag = 0; // 标志有无进位

		if (n1 == null && n2 == null) {
			return null;
		}

		while (n1 != null && n2 != null) {
			int sum = n1.data + n2.data + flag;
			travelList.data = sum % 10;
			flag = sum / 10;
			travelList.next = new LinkedListNode(0);
			travelList = travelList.next;
			n1 = n1.next;
			n2 = n2.next;
		}

		if (n1 == null) {
			while (n2 != null) {
				int sum = n2.data + flag;
				flag = sum / 10;
				travelList.data = sum % 10;
				travelList.next = new LinkedListNode(0);
				travelList = travelList.next;
				n2 = n2.next;
			}
			if (flag == 1) {
				travelList.data = 1;
			} else {
				sumList.deleteLinkedListNode(travelList);
			}
		} else {
			while (n1 != null) {
				int sum = n1.data + flag;
				flag = sum / 10;
				travelList.data = sum % 10;
				travelList.next = new LinkedListNode(0);
				n1 = n1.next;
			}
			if (flag == 1) {
				travelList.data = 1;
			} else {
				sumList.deleteLinkedListNode(travelList);
			}
		}

		return sumList;
	}

	public LinkedListNode addListReverse2(LinkedListNode n1, LinkedListNode n2,
			int flag) {
		// using recursion
		if (n1 == null && n2 == null && flag == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode(flag);

		int value = flag;
		if (n1 != null) {
			value += n1.data;
		}

		if (n2 != null) {
			value += n2.data;
		}

		result.data = value % 10;

		if (n1 != null || n2 != null) {
			LinkedListNode more = addListReverse2(n1 == null ? null : n1.next,
					n2 == null ? null : n2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	public LinkedListNode addListForward(LinkedListNode n1, LinkedListNode n2) {

		int value1 = listValue(n1);
		int value2 = listValue(n2);
		String totalValue = new Integer(value1 + value2).toString();

		int length = totalValue.toString().length();
		int index = 0;
		LinkedListNode addedNode = new LinkedListNode(-1);
		LinkedListNode currentNode = addedNode;

		while (length > 0) {
			int data = new Integer(
					new Character(totalValue.charAt(index)).toString());
			if (currentNode.data == -1) {
				currentNode.data = data;
			} else {
				currentNode.next = new LinkedListNode(data);
				currentNode = currentNode.next;
			}

			length--;
			index++;
		}

		return addedNode;
	}

	public int listValue(LinkedListNode n) {
		int len = n.length();
		int value = 0;
		while (len > 0) {
			value += n.data * Math.pow(10, len - 1);
			n = n.next;
			len -= 1;
		}

		return (int) value;
	}

	// 2.5 solution from the book
	class PartResult {
		LinkedListNode sumList = null;
		int flag = 0;
	}

	public LinkedListNode addListForward2(LinkedListNode n1, LinkedListNode n2) {
		int len1 = n1.length();
		int len2 = n2.length();

		if (len1 < len2) {
			n1 = paddingLeft(n1, len2 - len1);
		} else if (len1 > len2) {
			n2 = paddingLeft(n2, len1 - len2);
		}

		PartResult pr = addListHelper(n1, n2);

		if (pr.flag == 0) {
			return pr.sumList;
		} else {
			return insertBefore(pr.sumList, pr.flag);
		}

	}

	private LinkedListNode insertBefore(LinkedListNode sumList, int num) {
		LinkedListNode head = new LinkedListNode(num);
		sumList.prev = head;
		head.next = sumList;
		return head;
	}

	private PartResult addListHelper(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null && n2 == null) {
			return new PartResult();
		}

		PartResult pr = addListHelper(n1.next, n2.next);

		int value = pr.flag + n1.data + n2.data;
		if (pr.sumList == null) { //take care of the NullPointer
			pr.sumList = new LinkedListNode(value % 10);
		} else {
			pr.sumList = insertBefore(pr.sumList, value % 10);
		}
		if (value >= 10) {
			pr.flag = 1;
		} else { 
			pr.flag = 0;
		}

		return pr;
	}

	private LinkedListNode paddingLeft(LinkedListNode n, int i) {
		// TODO Auto-generated method stub
		while (i > 0) {
			LinkedListNode paddingNode = new LinkedListNode(0);
			n.prev = paddingNode;
			paddingNode.next = n;
			n = paddingNode;
			i -= 1;
		}
		return n;
	}

	@Test
	public void test1() {
		LinkedListNode n0 = new LinkedListNode(6);
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(7);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(9);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(2);

		n0.next = n1;
		n1.next = n2;

		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(addListForward2(n0, n3));

	}

	@Test
	public void generalTest() {
		LinkedListNode n1 = new LinkedListNode(3);
		LinkedListNode n2 = n1;
		n1.data = 4;
		System.out.println(n2.data);
	}
}

class LinkedListNode {

	public int data;
	public LinkedListNode next;
	public LinkedListNode prev;

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