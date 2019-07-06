class Three_a {
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
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printLinkedList(head);
		Node n = head.next.next;
		boolean flag = deleteMiddleNode(n);
		printLinkedList(head);

	}

	static boolean deleteMiddleNode(Node n) {
		if (n == null || n.next == null)
			return false;
		n.data = n.next.data;
		n.next = n.next.next;
			return true;	
	} 
}