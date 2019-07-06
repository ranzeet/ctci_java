import java.util.Arrays;
class StackArrayImplementation {
	int stack[];
	int size;
	int capacity;

	public StackArrayImplementation() {
		stack = new int[5];
		capacity = 5;
	}

	public StackArrayImplementation(int capacity) {
		stack = new int[capacity];
		this.capacity = capacity;
	}
	
	public void push(int value) throws Exception {
		if (size == capacity) throw new FullStackException();

		stack[size] = value;
		size += 1;
	}

	public int pop() throws Exception {
		if (size == 0) throw new EmptyStackException();

		int val = stack[size - 1];
		stack[size - 1] = 0;
		size -= 1;
		return val;
	}

	public int peek() throws Exception {
		if (size == 0) throw new EmptyStackException();
		return stack[size - 1];
	}

	public boolean isFull() {
		return size == capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String argr[]) throws Exception {
		StackArrayImplementation st = new StackArrayImplementation();
		System.out.println(Arrays.toString(st.stack));
		System.out.println(st.isEmpty());
		st.push(1);
		st.push(3);
		System.out.println(Arrays.toString(st.stack));
		st.push(4);
		st.push(5);
		st.push(6);
		System.out.println(Arrays.toString(st.stack));
		System.out.println(st.isFull());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());		
		System.out.println(Arrays.toString(st.stack));
	}
}
