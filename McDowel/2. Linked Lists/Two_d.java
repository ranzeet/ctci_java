class Two_d {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main (String argr[]) {
	
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
		System.out.println("O/P: " + kthToLast(head, 2));      
	}

	static int kthToLast(Node head, int k) {
		Node p1 = head, p2 = head;
	
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return -1;
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;
	}
	
}