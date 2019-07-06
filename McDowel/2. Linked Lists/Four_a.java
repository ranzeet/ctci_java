class Four_a {
	static Node head;
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static void printLinkedList(Node head) {
		Node temp = head;
		System.out.println("-----------------------------------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n-----------------------------------------------------");
	}

	public static void main (String argr[]) {
		head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(8);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(3);

		printLinkedList(head);
		partition(head, 4);
		printLinkedList(head);

	}

	static void partition(Node node, int x) {
	/*i will split it into two Linked List first and second*/
		Node firstStart = null, firstEnd = null, secondStart = null, secondEnd = null;

		while (node != null) {
		/*I am destructing original LinkedList*/
			Node next = node.next;
			node.next = null;

			if (node.data < x) {
				if (firstStart == null) {
					firstStart = node;
					firstEnd = firstStart;
				} else {
					firstEnd.next = node;
					firstEnd = node;
				}
			} else {
				if (secondStart == null) {
					secondStart = node;
					secondEnd = secondStart;
				} else {
					secondEnd.next = node;
					secondEnd = node;
				}
			}
			node = next;
		}
		if (firstStart == null) {
			head = secondStart;
		} else {
		firstEnd.next = secondStart;
		}
	}

}