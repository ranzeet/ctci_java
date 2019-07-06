import java.util.Stack;
class Six_b {
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
		Node fast = head;
		Node slow = head;

		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			int top = stack.pop().intValue();

			if (top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
