public class StackWithMin extends StackImplementation<NodeWithMin> {
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}

	public static void main(String argr[]) {
		StackWithMin st = new StackWithMin();
		st.push(10);
		st.push(20);
		st.push(30);
		System.out.println(st.min());
		System.out.println(st.peek().value);
	}
}
