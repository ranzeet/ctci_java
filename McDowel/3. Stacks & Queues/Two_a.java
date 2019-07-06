class Two_a extends StackImplementation<NodeWithMin> {
	public void push(int data) {
		int min = Math.min(data, min());
		super.push(new NodeWithMin(data, min));
	}

	public int min() {
		if (this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return peek().min;
	}

	//main method
	public static void main(String argr[]) {
		Two_a obj = new Two_a();
		obj.push(10);
		obj.push(15);
		obj.push(2);
		obj.push(1111);

		System.out.println(obj.min());
	}
}
