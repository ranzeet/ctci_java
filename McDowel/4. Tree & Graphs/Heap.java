/*I am implementing min-heap*/
import java.util.*;
class Heap {
	int heap[], size, count;

	public Heap() {
		heap = new int[] {2,12,54,13,89,78,15,14,36,8,6,1,0};
		size = heap.length - 1;
		System.out.println("actual size = " + size);
	}

	public Heap(int size) {
		heap = new int[size + 1];
		System.out.println("\n\t\t----------/|\\----------\n");
	}

	private int leftChild(int index) { return 2 * index + 1; }

	private int rightChild(int index) { return 2 * index + 2; }

	private int parent(int index) { return index == 0 ? 0 : (index - 1) / 2; }

	private boolean isLeaf(int index) { return ((index > (size / 2) - 1) && (index < size)); }

	void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	void buildHeap() {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			//System.out.println("i is "+i);
			heapify(i);
		}
	}

	void heapify(int index) {
		if (!isLeaf(index) && index < size) {
			//System.out.println("\t\tcount " + ++count + " index " + index);
			int lc = leftChild(index);
			int rc = rightChild(index);

			if (rc >= size) {
				if (heap[index] > heap[lc])
					swap(index, lc);
				return;
			}

			if (heap[index] > heap[lc] || heap[index] > heap[rc]) {
				if (heap[lc] < heap[rc]) {
					swap(index, lc);
					heapify(lc);
				} else {
					swap(index, rc);
					heapify(rc);
				}
			}
		}
	}

	void insert(int item) {
		heap[size++] = item;
		int i = size - 1;
		while (heap[parent(i)] > heap[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	int min() { return heap[0]; };

	void deleteMin() {
		System.out.println("Deleteing the minimum element: " + heap[0]);
		swap(0, (--size));
		heapify(0);
	}

	public static void main(String argr[]) {		
		Heap hp = new Heap();
		System.out.println("Actual array: " + Arrays.toString(hp.heap));
	
		hp.buildHeap();
		System.out.println("Heap:         " + Arrays.toString(hp.heap));

		System.out.println("Min is " + hp.min());

		hp.deleteMin();
		System.out.println(Arrays.toString(hp.heap));

		Heap hip = new Heap(10);
		hip.insert(10);hip.insert(80);hip.insert(70);hip.insert(40);hip.insert(20);
		hip.insert(30);hip.insert(50);hip.insert(60);hip.insert(100);hip.insert(90);
		System.out.println("Another Heap " + Arrays.toString(hip.heap));

		hip.buildHeap();
		System.out.println("After BuildHeap: " + Arrays.toString(hip.heap));

		System.out.println("Min is " + hip.min());

		hip.deleteMin();
		System.out.println(Arrays.toString(hip.heap));

		System.out.println("\n\t\t--------sorting--------\n");

		while (hip.size != 0) {
			hip.deleteMin();
			//System.out.println(Arrays.toString(hip.heap));
		}

		System.out.println(Arrays.toString(hip.heap));
	}
}
















/*------------------------------------------------------Using PriorityQueue--------------------------------------------------------------*/
/*
import java.util.*;
class Heap {
	public static void main(String argr[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.add(100);	pq.add(5); 	pq.add(201);	pq.add(10);	pq.add(34);
		pq.add(50); 	pq.add(4);	pq.add(45);

		System.out.println("peeking: " + pq.peek());
		System.out.println(Arrays.toString(pq.toArray()));
		System.out.println("polling: " + pq.poll());
		System.out.println(Arrays.asList(pq));
	}
}
*/
/*----------------------------------------------------------------------Initial Approacj---------------------------------------------------*/
/*import java.util.*;
class Heap {
	int[] min_heap;

	public Heap(int size) {
		min_heap = new int[size];
	}

	void swap(int i, int j) {
		int temp = min_heap[i];
		min_heap[i] = min_heap[j];
		min_heap[j] = temp;
	}
	void heapify(int i) {
		System.out.println("start" + Arrays.toString(min_heap));
		if (i > 2) return;
		if (min_heap[i] <= min_heap[2 * i] && min_heap[i] <= min_heap[2 * i + 1]) return;

		if (min_heap[i] > min_heap[2*i]) {
			swap(i, 2 * i);System.out.println("heapify("+(2*i)+")");
			heapify(2 * i);
			if (min_heap[i] > min_heap[2 * i] || min_heap[i] > min_heap[2 * i + 1]) heapify(i);
		} else {
			swap(i, (2 * i + 1));System.out.println("heapify("+(2*i+1)+")");
			heapify((2 * i) + 1);
			if (min_heap[i] > min_heap[2 * i] || min_heap[i] > min_heap[2 * i + 1]) heapify(i);
		}
		System.out.println("end" + Arrays.toString(min_heap));	
	}

	void delete(int i) {
		swap(i, min_heap.length - 1);
		heapify(i);
	}

	public static void main(String argr[]) {
		Heap hp = new Heap(7);
		hp.min_heap = new int[] {0, 5, 2, 3, 6, 1};
		System.out.println(Arrays.toString(hp.min_heap));
		hp.heapify(1);
		System.out.println(Arrays.toString(hp.min_heap));
		hp.delete(1);
		System.out.println(Arrays.toString(hp.min_heap));
	}
}*/
