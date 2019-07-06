import java.util.ArrayList;
import java.util.Arrays;
class Three_b {
	ArrayList<Stack> stacks;
	public int capacity;
	
	public Three_b(int capacity) {
		stacks = new ArrayList<Stack>();
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if (stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}

	public void push(int data) throws Exception {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(data);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(data);
			stacks.add(stack);
		}

	}

	public int pop() throws Exception {
		Stack last = getLastStack();
		if (last == null) throw new EmptyStackException();

		int v = last.pop();
		if (last.size == 0) stacks.remove(stacks.size() - 1);
		return v;
	}

	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}

	public int popAt(int index) throws Exception {
		return leftShift(index, true);	
	}

	public int leftShift(int index, boolean removeTop) throws Exception {
		Stack stack = stacks.get(index);
		int removedItem;

		if (removeTop) removedItem = stack.pop();
		else removedItem = stack.removeBottom();

		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}

		return removedItem;
	}

	public static void main(String []argr) throws Exception {
		Three_b tb = new Three_b(5);
		tb.push(10);tb.push(20);tb.push(30);tb.push(40);tb.push(50);tb.push(60);tb.push(70);tb.push(80);tb.push(90);tb.push(100);tb.push(110);tb.push(120);
		for (Stack e : tb.stacks) {
			System.out.println("top: " + e.top.value + " Bottom: " + e.bottom.value);
		}
		System.out.println("popping out " + tb.pop());
		for (Stack e : tb.stacks) {
			System.out.println("top: " + e.top.value + " Bottom: " + e.bottom.value);
		}
		System.out.println("popping out " + tb.popAt(1));
		for (Stack e : tb.stacks) {
			System.out.println("top: " + e.top.value + " Bottom: " + e.bottom.value);
		}
	}

}

class Stack {
	static class Node {
		Node above;
		Node below;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node top, bottom;
	public int size;
	public int capacity;

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() { return size == capacity; }

	public boolean isEmpty() { return size == 0; }

	private void join (Node above, Node below) {
		if (below != null) below.above = above;
		if (above != null) above.below = below; 
	}

	public void push(int v) throws Exception {
		if (size >= capacity) throw new FullStackException();
		size += 1;
		Node n = new Node(v);
		if (size == 1) bottom = n;
		join(n, top);
		top = n;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size -= 1;
		return t.value;
	}

	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null) bottom.below = null;
		size--;
		return b.value;
	}
	
	
}
