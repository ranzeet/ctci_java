class Four_b {
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
		head = partition(head, 4);
		printLinkedList(head);

	}
	/*We dont care about the order of elements*/
	static Node partition(Node node, int x) {
		Node head = node, tail = node;
		
		while (node != null) {
			Node next = node.next;			
			if (node.data < x) {
				node.next = head;
				head = node;	
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;	
	}
}