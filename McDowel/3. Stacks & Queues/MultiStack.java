import java.util.Arrays;
public class MultiStack {
	private class StackInfo {
		private int start, size, capacity;
		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}
		
		private boolean isWithinStackCapacity(int index) {
			if (index < 0 || index >= values.length) return false;

			int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return  start <= contiguousIndex && contiguousIndex < end;
		}

		private int lastCapacityIndex() { return adjustIndex(start + capacity - 1); } //adjustIndex(int index)
		private int lastElementIndex() { return adjustIndex(start + size -1); }
		private boolean isFull() { return size == capacity; }
		private boolean isEmpty() { return size == 0; }
	}

	private StackInfo info[];
	private int values[];
	
	public MultiStack(int noOfStacks, int defaultSize) {
		info = new StackInfo[noOfStacks];
		for (int i = 0; i < noOfStacks; i++) {
			info[i] = new StackInfo(i * defaultSize, defaultSize);
		}
		values = new int[noOfStacks * defaultSize];	
	}

	public void push(int stackNum, int value) throws FullStackException {
		StackInfo stack = info[stackNum];	

		if ( allStacksAreFull() ) throw new FullStackException();		//allStacksAreFull()
		if ( stack.isFull() ) expand(stackNum);					//expand(int stackNum)
	
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}

	public int pop(int stackNum) throws EmptyStackException {
		StackInfo stack = info[stackNum];

		if ( stack.isEmpty() ) throw new EmptyStackException();

		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}

	public int peek(int stackNum) throws EmptyStackException {
		StackInfo stack = info[stackNum];

		return values[stack.lastElementIndex()];
	}

	private int adjustIndex(int index) { return ((index % values.length) + values.length) % values.length; }

	private void expand(int stackNum) {
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;
	}

	private void shift(int stackNum) {
		System.out.println("///shifting(shrinking) stack " + stackNum);
		StackInfo stack = info[stackNum];

		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);					//recursing
			stack.capacity++;
		}

		int index = stack.lastCapacityIndex();
		while (stack.isWithinStackCapacity(index)) {
			values[index] = values[previousIndex(index)];		//previousIndex(int index)
			index = previousIndex(index);
		}

		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);				//nextIndex(int)
		stack.capacity--;
	}

	private int previousIndex(int index) { return adjustIndex(index - 1); }
	private int nextIndex(int index) { return adjustIndex(index + 1); }
	
	private boolean allStacksAreFull() { return numberOfElements() == values.length; } 	//numberOfElements()

	private int numberOfElements() {
		int size = 0;
		for (StackInfo sd : info) size += sd.size;
		return size;
	}
	
	public static void main(String argr[]) throws Exception {
		MultiStack ms = new MultiStack(3, 3);
		ms.push(0, 786);ms.push(1, 786);ms.push(2, 786);
		System.out.println(Arrays.toString(ms.values));
		
		ms.push(0, 1);ms.push(0, 2);ms.push(0, 3);
		System.out.println(Arrays.toString(ms.values));
		
		ms.push(0, 4);ms.push(0, 5);ms.push(0, 6);
		System.out.println(Arrays.toString(ms.values));

		ms.pop(0);
		System.out.println(Arrays.toString(ms.values));

		ms.pop(0);
		System.out.println(Arrays.toString(ms.values));


	}
}
