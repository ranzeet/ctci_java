class One_a {
	private int stackCapacity;
	private int numberOfStacks = 3;
	private int sizes[];
	private int values[];

	public One_a(int stackSize) {
		stackCapacity = stackSize;
		sizes = new int[stackSize];
		values = new int[stackSize * numberOfStacks];
	}

	public int indexOfTop(int stackNum) {
		int size = sizes[stackNum];
		int offset = stackNum * stackCapacity;
		return offset + size - 1;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public void push(int stackNum, int value) throws FullStackException {
		if (isFull(stackNum)) throw new FullStackException();

		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws EmptyStackException {
		if (isEmpty(stackNum)) throw new EmptyStackException();
	
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
	
		return value;
	}

	public int peek(int stackNum) throws EmptyStackException {
		if (isEmpty(stackNum)) throw new EmptyStackException();	

		return values[indexOfTop(stackNum)];
	}

	public void print() {
		System.out.println("Printing all stacks i.e., complete array");
		System.out.println(java.util.Arrays.toString(values));
		System.out.println("---------- x ----------");
	}
	public static void main(String argr[]) throws Exception {
		One_a obj = new One_a(3);
		obj.print();

		obj.push(0, 12);
		obj.push(0, 13);
		obj.push(0, 14);
		System.out.println("Popping out " + obj.pop(0));
		obj.print();

		obj.push(1, 22);
		obj.push(1, 23);
		obj.push(1, 24);
		System.out.println("Popping out " + obj.pop(1));
		obj.print();

		obj.push(2, 32);
		obj.push(2, 33);
		obj.push(2, 34);
		System.out.println("Popping out " + obj.pop(2));
		obj.print();
		System.out.println("Popping out " + obj.pop(2));
		obj.print();

		
	}
}
