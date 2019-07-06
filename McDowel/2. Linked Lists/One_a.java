import java.util.*;
class One_a {
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
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(2);		
		
		Node temp = head;
		System.out.println("-----------------------------------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n-----------------------------------------------------");

		removeDups(head);

		System.out.println("-----------------------------------------------------");
		Node temp1 = head;
		while (temp1 != null) {
			System.out.print(temp1.data + " ");
			temp1 = temp1.next;
		}
		System.out.println("\n-----------------------------------------------------");
		
	}

	static void removeDups(Node head) {
		Node prev = head;
		Node temp = head;
		HashSet<Integer> hs = new HashSet<Integer>();
		while (temp != null) {
			if (hs.contains(temp.data)) {
				prev.next = temp.next;
				temp = temp.next;
			} else {
				hs.add(temp.data);
				prev = temp;
				temp = temp.next;
			}
		}//System.out.println(hs);
	}
}