class Two_a {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main (String[] argr) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		Node temp = head;
		System.out.println("-----------------------------------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n-----------------------------------------------------");
		System.out.println("\nIndex O/P: " + printKthToLast(head, 2));
	}

	static int printKthToLast(Node head, int k) {
		if (head == null)
			return 0;
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last Node is " + head.data);
		}
		//System.out.println("Index = " + index);
		return index;
	}
	
}