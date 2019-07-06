/*using DFS preOrderTraversal*/
import java.util.*;
class Three_a {
	static Node root;
	static ArrayList<LinkedList<Node>> linkedLists;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static void createLevelLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if (root == null) return;

		LinkedList<Node> list = null;
		if (lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);		
	}

	static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	static void print(LinkedList<Node> ll) {
		for (Node ech : ll) {
			System.out.print(ech.data + " ");
		}
	}
	public static void main(String argr[]) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		linkedLists = new ArrayList<LinkedList<Node>>();
		linkedLists = createLevelLinkedList(root);

		for (int i = 0; i < linkedLists.size(); i++) {
			System.out.println("Linked List " + (i + 1));
			print(linkedLists.get(i));
			System.out.println();
		}
	}
}
