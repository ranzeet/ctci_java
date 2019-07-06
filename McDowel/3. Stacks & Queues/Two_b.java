class Two_b extends StackImplementation<Integer> {
	StackImplementation<Integer> s2;
	public Two_b() {
		s2 = new StackImplementation<Integer>();
	}

	public void push(int value) {
		if (value < min())
			s2.push(value);
		super.push(value);
	}

	public Integer pop() {
		if (s2.peek() == min())
			s2.pop();
		return super.pop();
	}

	public int min() {
		if (s2.isEmpty())
			return Integer.MAX_VALUE;
		return s2.peek();
	}

	public static void main(String argr[]) {
		Two_b tb = new Two_b();

		tb.push(12);
		tb.push(21);
		tb.push(78);
		tb.push(9);
		tb.push(43);

		System.out.println("Peek " + tb.peek() + " Min " + tb.min());
	}
}
