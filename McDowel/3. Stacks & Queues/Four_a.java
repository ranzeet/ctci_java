import java.util.Stack;
class Four_a<T> {
	Stack<T> stackOldest, stackNewest;

	public Four_a() {
		stackOldest = new Stack<T>();
		stackNewest = new Stack<T>();
	}

	public int size() {
		return stackOldest.size() + stackNewest.size();
	}

	public void add(T item) {
		stackNewest.push(item);
	}

	public void shiftElements() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}	

	public T remove() {
		shiftElements();
		return stackOldest.pop();
	}

	public T peek() {
		shiftElements();
		return stackOldest.peek();
	}

	public static void main(String argr[]) {
		Four_a<Integer> fa = new Four_a<Integer>();
		fa.add(10);
		fa.add(20);
		fa.add(30);
		fa.add(40);
		fa.add(50);
		System.out.println(fa.remove());
	}
}
