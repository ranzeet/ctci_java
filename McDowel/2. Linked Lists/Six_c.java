class Six_c {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class Result {
		boolean result;
		Node node;

		public Result(Node node, boolean result) {
			this.result = result;
			this.node = node;
		}
	}

	static void print(Node head) {
		System.out.println("\t\tPriting");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String argr[]) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(1);

		print(head);
		if (isPallindrome(head)) {
			System.out.println("It is pallindromic :)");
		} else {
			System.out.println("It is not pallindromic :(");
		}
	}

	static boolean isPallindrome(Node head) {
		int length =  length(head);
		return isPallindromeRecurse(head, length).result;
	}

	static Result isPallindromeRecurse(Node head, int length) {
		if (head == null || length <= 0) {
			return new Result(head, true);
		}

		if (length == 1) {
			return new Result(head.next, true);
		}

		Result res = isPallindromeRecurse(head.next, length - 2);

		if (!res.result || res.node == null)
			return res;

		res.result = (head.data == res.node.data);
		res.node = res.node.next;
		
		return res;
	}

	static int length(Node head) {
		Node temp = head;
		int len = 0;
		
		while (temp != null) {
			len +=1;
			temp = temp.next;
		}

		return len;
	}
}
