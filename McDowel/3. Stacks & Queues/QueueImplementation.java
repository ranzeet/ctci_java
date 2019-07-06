class QueueImplementation<T> {
	static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if (last != null) last.next = t;
		last = t;
		if (first == null) first = last;		
	}

	public T remove() {
		if (first == null) return null;

		T data = first.data;
		first = first.next;

		if (first == null) first = last;

		return data;
	}

	public T peek() {
		if (first == null) return null;

		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void print() {
		System.out.println("Printing.................");
		QueueNode firstCopy = first;
		while (firstCopy != last) {
			System.out.println(firstCopy.data);
			firstCopy = firstCopy.next;
		}
	}
	public static void main(String argr[]) {
		QueueImplementation<Integer> si = new QueueImplementation<Integer>();
		
		si.print();
		si.add(10);
		si.add(20);
		si.add(30);
		si.add(40);
		si.print();
		si.remove();
		si.print();
	}
}
