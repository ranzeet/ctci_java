/*using BFS*/
import java.util.*;
class Three_b {
	static Node root;
	static ArrayList<LinkedList<Node>> resultList;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		
		while (current.size() > 0) {
			result.add(current);
			LinkedList<Node> parent = current;
			current = new LinkedList<Node>();
			for (Node node : parent) {
				if (node.left != null) {
					current.add(node.left);
				}
				if (node.right != null) {
					current.add(node.right);
				}
			}
		}
		return result;
	}

	static void print(LinkedList<Node> ll) {
		for (Node node : ll) {
			System.out.print(node.data + " ");
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

		resultList = createLevelLinkedList(root);
		int i = 1;
		for (LinkedList<Node> ll : resultList) {
			System.out.println("Level " + i++);
			print(ll);
			System.out.println();
		}
	}
}
