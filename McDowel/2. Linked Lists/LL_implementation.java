import java.util.Scanner;
public class LL_implementation {
	static Node head;

	static class Node {
		Node next = null;
		int data;
	
		public Node(int data) {
			this.data = data;
		}
	}	

	public static void main (String[] argr) {
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		LL_implementation obj = new LL_implementation();
		do {
			System.out.println("Welcome to LinkedList DataStructure Exercise");
			System.out.println("Menu:");
			System.out.println("1. Add at Starting.\n2. Add in Ending.\n3. Add " +
				"at nth position.\n4. Traverse. \n5. Delete at Beginning." +
				 "\n6. Delete in End. \n7. Delete at nth position. \n8. Exit.");
			menu = sc.nextInt();
			obj.head = operate(menu, head);
			
		} while (true);
	}
	
	static Node operate(int menu, Node head) {
		switch(menu) {
			case 1: return addBeginning(head);
			case 2: return addEnd(head);
			case 3: return addAtPosition(head);
			case 4: traverse(head); break;
			case 5: return deleteBeginning(head);
			case 6: return deleteEnd(head);
			case 7: return deleteAtPosition(head);
			case 8: System.out.println("Thank You :) \n\n"); System.exit(0); break;
			default: System.out.println("Invalid Option"); System.exit(0);
		}
		return head;
	}

	static Node addBeginning(Node head) {
		System.out.println("Enter Data for the LinkedList: ");
		int val = new Scanner(System.in).nextInt();
		if (head == null) {
			head = new Node(val);
			return head;
		} else {
			Node node = new Node(val);
			node.next = head;
			head = node;
			return head;
		}
	}

	static Node addEnd(Node head) {
		System.out.println("Enter Data for the LinkedList: ");
		int val = new Scanner(System.in).nextInt();
		if (head == null) {
			head = new Node(val);
			return head;
		} else {
			Node node = new Node(val);
			Node temp = head;
			while (temp.next != null) temp = temp.next;
			temp.next = node;
			return head;
			
		}
	}

	static Node addAtPosition(Node head) {
		System.out.println("Enter Data for the LinkedList: ");
		int val = new Scanner(System.in).nextInt();

		System.out.println("Enter position/index for the node: ");
		int pos = new Scanner(System.in).nextInt();

		if (head == null && pos == 1) {
			head = new Node(val);
			return head;
		} else {
			Node node = new Node(val);
			Node temp = head;
			while (pos > 2) {
				temp = temp.next;
				pos--;
			}
			Node temp1 = temp.next;
			temp.next = node;
			node.next = temp1;
			return head;
			
		}
	}

	static Node deleteBeginning(Node head) {
		if (head == null) {
			System.out.println("\t\t\tNothing to delete!\n");
			return head;
		} else {
			head = head.next;
			System.out.println("\t\t\tDeleted Successfully!\n");
			System.gc();
			return head;
		}
	}

	static Node deleteEnd(Node head) {
		if (head == null) {
			System.out.println("\t\t\tNothing to delete\n");
			return head;
		} else if (head.next == null) {
				head = null;
				return head;					
		} else {
			Node temp = head;
			while (temp.next.next != null) temp = temp.next;
			temp.next = null;
			System.out.println("\t\t\tDeleted Successfully!\n");
			System.gc();
			return head;
		} 
	}

	static Node deleteAtPosition(Node head) {
		System.out.println("Enter position to be deleted from the LinkedList: ");
		int pos = new Scanner(System.in).nextInt();

		if (head == null) {
			System.out.println("Nothing to delete...");
			return head;
		} else if (pos == 1) {
			return deleteBeginning(head);
		} else {
			Node temp = head;
			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			return head;
		}
	}

	static void traverse(Node head) {
		Node temp = head;
		System.out.println("\t\t\t[Traversal]");
		while (temp != null) {
			System.out.print(temp.data+"  ");
			temp = temp.next;
		}
		System.out.println("\n");
	}
}