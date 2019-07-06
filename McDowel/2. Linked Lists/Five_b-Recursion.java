class Five_b {
	static Node head1, head2;
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class partialSum {
		Node sum = null;
		int carry = 0;
	}

	public static void main(String argr[]) {
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);

		head2 = new Node(5);
		head2.next = new Node(6);
		head2.next.next = new Node(7);

		print(head1);
		print(head2);

		Node sumHead = add(head1, head2);
		
		print(sumHead);
	}

	static void print(Node head) {
		Node temp = head;
		System.out.println();
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node add(Node l1, Node l2) {
		int len1 = length(l1);
		int len2 = length(l2);

		if (len1 > len2) {
			l2 = padList(l2, len1 - len2);
		} else {
			l1 = padList(l1, len2 - len1);
		}

		partialSum sum = addListHelper(l1, l2);

		if (sum.carry == 0) {
			return sum.sum;
		} else {
			return insertBefore(sum.sum, sum.carry);
		}
	}

	static partialSum addListHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null)
			return new partialSum();

		partialSum sum = addListHelper(l1.next, l2.next);

		int val = sum.carry + l1.data + l2.data;

		Node result = insertBefore(sum.sum, val % 10);
		
		sum.sum = result;
		sum.carry = val / 10;
		return sum;		
	}

	static int length(Node l) {
		Node temp = l;
		int len = 0;
		
		while (temp != null) {
			len += 1;
			temp = temp.next;
		}

		//System.out.println("length: " + len);
		return len;
	}

	static Node padList(Node l, int padding) {
		Node temp = l;
		for (int i = 0; i < padding; i++)
			temp = insertBefore(temp, 0);

		return temp;
	}

	static Node insertBefore(Node l, int data) {
		Node temp = new Node(data);
		if (l != null) temp.next = l;
		return temp;
	}
}
