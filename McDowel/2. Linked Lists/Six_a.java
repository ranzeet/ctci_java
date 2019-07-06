class Six_a {
	static Node head;
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static void printLinkedList(Node head) {
		Node temp = head;
		System.out.println("------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n---------------------------");
	}

	public static void main (String argr[]) {
		head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(8);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(1);

		printLinkedList(head);
		if (isPallindrome(head))
			System.out.println("It is Pallindromic LinkedList :)");
		else
			System.out.println("It is not Pallindromic :(");
	}

	static boolean isPallindrome(Node head) {
		Node reversed = revAndClone(head);
		return isEqual(head, reversed);
	}

	static Node revAndClone(Node oldhead) {
		Node head = null;
		while (oldhead != null) {
			Node node = new Node(oldhead.data);
			node.next = head;
			head = node;
			oldhead = oldhead.next;
		}
		return head;
	}

	static boolean isEqual(Node one, Node two) {
		while (one != null && two != null) {
			if (one.data != two.data)
				return false;
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
}
