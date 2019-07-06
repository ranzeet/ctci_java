class Five_a {
	static Node head1;
	static Node head2;
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}

		public Node() {}
	}

	static void printLinkedList(Node head, String s) {
		Node temp = head;
		System.out.println("------------" + s + "------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n---------------------------");
	}

	public static void main (String argr[]) {
		head1 = new Node(7);
		head1.next = new Node(1);
		head1.next.next = new Node(6);

		head2 = new Node(5);
		head2.next = new Node(9);
		head2.next.next = new Node(2);

		printLinkedList(head1, "I/P");
		printLinkedList(head2, "I/P");
		Node obj = sumList(head1, head2);
		printLinkedList(obj, "O/P");
	}

	static Node sumList(Node head1, Node head2) {
		return sumList(head1, head2, 0);
	}

	static Node sumList(Node head1, Node head2, int carry) {

		if (head1 == null && head2 == null && carry == 0) return null;
		
		Node result = new Node();
		int value = carry;

		if (head1 != null) value += head1.data;
		if (head2 != null) value += head2.data;
		
		result.data = value % 10;

		if (head1 != null || head2 != null) {
			Node more = sumList(head1 == null ? null : head1.next,
					head2 == null ? null : head2.next,
				value >= 10 ? 1 : 0);

			result.next = more;	//Replacement of setNext() from CTCI
		}
		return result;			
	}
}