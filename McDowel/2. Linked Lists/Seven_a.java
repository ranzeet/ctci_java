class Seven_a {
	static Node head1;
	static Node head2;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class Result {
		int size;
		Node tail;
		
		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	static void print(Node head) {
		Node temp = head;
		System.out.println("------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n---------------------------");
	}

	public static void main(String argr[]) {
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);

		head2 = new Node(10);
		head2.next = new Node(20);
		head2.next.next = head1.next.next.next.next;

		print(head1);
		print(head2);

		Node intersecto = findIntersection(head1, head2);
		
		print(intersecto);
	}

	static Node findIntersection(Node head1, Node head2) {
		if (head1 == null || head2 == null) return null;

		Result res1 = getTailAndSize(head1);
		Result res2 = getTailAndSize(head2);

		if (res1.tail != res2.tail) return null;

		Node shorter = res1.size < res2.size ? head1 : head2;
		Node longer = res1.size	< res2.size ? head2 : head1;

		longer = getKthNode(longer, Math.abs(res1.size - res2.size));

		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return new Node(longer.data);
	}

	static Result getTailAndSize(Node head) {
		if (head == null) return null;

		Node temp = head;
		int count = 1;
		while (temp.next != null) {
			count += 1;
			temp = temp.next;
		}
		return new Result(temp, count);
	}

	static Node getKthNode(Node node, int count) {
		Node temp = node;
		while (count > 0 && temp != null) {
			temp = temp.next;
			count -= 1;
		}
		return temp;
	}
}
