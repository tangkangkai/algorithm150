package algorithm150;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionForThree {

	// 3.1
	// Fixed Division
	class threeStackFixed {
		int stackSize = 100;
		int[] buffer = new int[stackSize * 3];
		int[] pointer = new int[] { -1, -1, -1 };

		public void push(int stackNum, int value) throws Exception {
			if (pointer[stackNum] + 1 >= stackSize) {
				throw new Exception("OverFlow");
			}
			pointer[stackNum]++;
			buffer[absTopOfStack(stackNum)] = value;
		}

		public int pop(int stackNum) throws Exception {
			if (pointer[stackNum] == -1) {
				throw new Exception("there is no element");
			}

			int result = buffer[absTopOfStack(stackNum)];
			buffer[absTopOfStack(stackNum)] = 0;
			pointer[stackNum]--;
			return result;
		}

		int absTopOfStack(int stackNum) {
			return stackSize * stackNum + pointer[stackNum];
		}
	}

	// 3.2
	class StackWithMin extends Stack<Integer> {
		Stack<Integer> minStack = new Stack<Integer>();
		int minimum = Integer.MAX_VALUE;

		public void push(int value) {
			if (value <= minimum) {
				minimum = value;
				minStack.push(minimum);
			}

			super.push(value);
		}

		public Integer pop() {
			if (peek() == minimum) {
				minStack.pop();
			}

			return super.pop();
		}

		public Integer minimum() {
			return minStack.peek();
		}
	}

	// 3.3
	class SetOfStacks<T> {
		int capacity;
		int index;
		ArrayList<SubStack<T>> stackList = new ArrayList<>();

		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}

		public void push(T item) {
			SubStack<T> currentStack = stackList.get(index);

			if (currentStack.capacity >= this.capacity) {
				SubStack<T> newStack = new SubStack<>(capacity);
				stackList.add(newStack);
				currentStack = stackList.get(++index);
			}

			currentStack.push(item);
			currentStack.capacity++;
		}

		public T pop() {
			return this.popAt(index);
		}

		public T popAt(int index) {
			SubStack<T> currentStack = stackList.get(index);

			if (currentStack.capacity <= 0) {
				currentStack = stackList.get(--index);
			}
			currentStack.capacity--;
			return currentStack.pop();
		}
	}

	class SubStack<T> extends Stack<T> {
		int capacity;

		public SubStack(int capacity) {
			this.capacity = capacity;
		}
	}

	@Test
	public void test1() {
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		System.out.println(stack.minimum());
		stack.push(6);
		System.out.println(stack.minimum());
		stack.push(3);
		System.out.println(stack.minimum());
		stack.push(7);
		System.out.println(stack.minimum());
		System.out.println("POP---" + stack.pop());
		System.out.println(stack.minimum());
		System.out.println("POP---" + stack.pop());
		System.out.println(stack.minimum());
	}

	@Test
	public void generalTest() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		System.out.println(al.get(0));
		System.out.println(al);
		al.remove(1);
		System.out.println(al);
		System.out.println(al.get(1));
		
	}

	class Node<T> {
		T data;
		Node<T> next;

		public Node(T d) {
			this.data = d;
		}
	}

	class Stack<T> {
		Node<T> top;

		public T pop() {
			if (top != null) {
				T item = top.data;
				top = top.next;
				return item;
			}
			return null;
		}

		public void push(T item) {
			Node<T> newNode = new Node<T>(item);
			newNode.next = top;
			top = newNode;
		}

		public T peek() {
			return top.data;
		}

	}

	class Queue<T> {
		Node<T> first, last;

		public void enqueue(T item) {
			Node<T> newNode = new Node<T>(item);
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
