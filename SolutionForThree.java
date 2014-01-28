package algorithm150;

import org.junit.Test;

public class SolutionForThree {

	// 3.1
	// Fixed Division
	class threeStack {
		int stackSize = 100;
		int[] buffer = new int[stackSize * 3];
		int[] pointer = new int[] { -1, -1, -1 };
		
		public void push(int stackNum, int value) throws Exception {
			if(pointer[stackNum] +1 >= stackSize) {
				throw new  Exception("OverFlow");
			}
			pointer[stackNum]++;
			buffer[absTopOfStack(stackNum)] = value;
		}
		
		public int pop(int stackNum) throws Exception{
			if(pointer[stackNum] == -1){
				throw new Exception("there is no element");
			}
			
			int result = buffer[absTopOfStack(stackNum)];
			buffer[absTopOfStack(stackNum)] = 0;
			pointer[stackNum] --;
			return result;
		}
		
		int absTopOfStack(int stackNum) {
			return stackSize * stackNum + pointer[stackNum];
		}
	}

	@Test
	public void test1() {
	}

	@Test
	public void generalTest() {
	}

	class Node {
		Object data;
		Node next;

		public Node(Object d) {
			this.data = d;
		}
	}

	class Stack {
		Node top;

		public Object pop() {
			if (top != null) {
				Object item = top.data;
				top = top.next;
				return item;
			}
			return null;
		}

		public void push(Object item) {
			Node newNode = new Node(item);
			newNode.next = top;
			top = newNode;
		}

		public Object peek() {
			return top.data;
		}

	}

	class Queue {
		Node first, last;

		public void enqueue(Object item) {
			Node newNode = new Node(item);
			if (first == null) {
				last = newNode;
				first = last;
			} else {
				last.next = newNode;
				last = last.next;
			}

		}

		public Object dequeue() {
			if (first != null) {
				Object item = first.data;
				first = first.next;
				return item;
			} else {
				return null;
			}
		}
	}
}
