class One_b {
// ----------------------------------------Start of StackInfo class-------------------------------------------------
	private class StackInfo {
		public int start, size, capacity;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}

		public boolean isWithinStackCapacity(int index) {
			if (index < 0 || index >= values.length)
				return false;

		int contiguousIndex = index < start ? index + values.length : index;
		int end = start + capacity;

		return start <= contiguousIndex && contiguousIndex < end;
		}

		public int lastCapacityIndex() {
			return adjustIndex(start + capacity - 1);
		}
		
		public int lastElementIndex() {
			return adjustIndex(start + size - 1);
		}

		public boolean isFull() { return size == capacity; }
		public boolean isEmpty() { return size == 0; }
	}
// ----------------------------------------END of StackInfo class-------------------------------------------------
	private StackInfo[] info;
	private int[] values;

	public One_b(int numberOfStacks, int defaultSize) {
		info = new StackInfo[numberOfStacks];
		for (int i = 0; i < numberOfStacks; i++) {
			info[i] = new StackInfo(defaultSize * i, defaultSize);
		}
		values = new int[numberOfStacks * defaultSize];	System.out.println("info " + info.length + " values " + values.length);
	}

// ========================================Start of stack API==================================================
	public void push(int stackNum, int value) throws FullStackException {
		if (allStacksAreFull()) {
			throw new FullStackException();
		}

		StackInfo stack = info[stackNum];
		if (stack.isFull()) {
			expand(stackNum);
		}

		stack.size++;
		values[stack.lastElementIndex()] = value;
	}

	public int pop(int stackNum) throws Exception {
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()) {
			throw new EmptyStackException();
		}

		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}

	public int peek(int stackNum) {
		StackInfo stack = info[stackNum];
		return values[stack.lastElementIndex()];
	}

// ========================================End of stack API==================================================
	private void shift(int stackNum) {
		System.out.println("/// Shifting " + stackNum);
		StackInfo stack = info[stackNum];

		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			stack.capacity++;
		}

		int index = stack.lastCapacityIndex();
		while (stack.isWithinStackCapacity(index)) {
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
		}

		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);
		stack.capacity--;
	}

	private void expand(int stackNum) {
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;
	}

	public int numberOfElements() {
		int size = 0;
		for (StackInfo sd : info) {
			size += sd.size;
		}
		return size;
	}

	public boolean allStacksAreFull() {
		return numberOfElements() == values.length;
	}

	private int adjustIndex(int index) {
		int max = values.length;
		return ((index % max) + max) % max;
	}

	private int nextIndex(int index) {
		return adjustIndex(index + 1);
	}

	private int previousIndex(int index) {
		return adjustIndex(index - 1);
	}

	public static void main(String argr[]) throws Exception {
		One_b obj = new One_b(3, 3);

		obj.push(0, 11);obj.push(0, 12);obj.push(0, 13);
		obj.push(1, 21);obj.push(1, 22);
		obj.push(2, 31);obj.push(2, 32);obj.push(2, 33);

		System.out.println(java.util.Arrays.toString(obj.values));
		obj.shift(1);
		System.out.println("Bhag");
	}
}
	
