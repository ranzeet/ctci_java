class Two_c {
	static Node head;
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class Index {
		public int value = 0;
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
		System.out.println("O/P: " + kthToLast(head, 2).data);      
	}
	
	static Node kthToLast(Node head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	static Node kthToLast(Node head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value += 1;
		if (idx.value == k) {
			//System.out.println("****");
			return head;
		}
		//System.out.println(node != null ? node.data : "Null");
		return node;
	}

}