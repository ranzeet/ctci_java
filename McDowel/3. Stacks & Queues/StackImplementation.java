class StackImplementation<T> {
	static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;
	
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;		
	}

	public T pop() {
		if (top == null) return null;

		T item = top.data;
		top = top.next;
		return item;
	}

	public T peek() {
		if (top == null) return null;

		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void print() {
		System.out.println("Printing............");
		StackNode topCopy = top;
		while (topCopy != null) {
			System.out.println(topCopy.data);
			topCopy = topCopy.next;
		}
	}
	public static void main(String argr[]) {
		StackImplementation<Integer> si = new StackImplementation<Integer>();
		
		si.print();
		si.push(10);
		si.push(20);
		si.push(30);
		si.push(40);
		si.print();
		si.pop();
		si.print();
	}
}
