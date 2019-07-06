class Eight_a {
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
		head.next.next.next.next.next.next = head.next.next;//cycle at 3 [1-2-(3-4-5-6)]

		//printLinkedList(head);
		Node res = findBeginning(head);

		if (res == null)
			System.out.println("No cycle in the LinkedList");
		else
			System.out.println(res.data +" is the beginning of cycle."); 
	}

	static Node findBeginning(Node head) {
		if (head == null || head.next == null) return null;

		Node slow = head;
		Node fast = head;

		while (fast != null && slow != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) break;	
		}

		if (fast == null || slow == null) return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
