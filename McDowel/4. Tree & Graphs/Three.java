import java.util.*;
class Three {
	static TreeMap<Integer, ArrayList<Integer>> tm;
	static Node root;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static void printInorder(Node node, int lvl) {
		if (node == null) return;
		if (tm.containsKey(lvl)) {
			tm.get(lvl).add(node.data);
		}else {
			tm.put(lvl, new ArrayList<Integer>());
			tm.get(lvl).add(node.data);
		}
		printInorder(node.left, lvl + 1);
		System.out.print(node.data + " ");
		printInorder(node.right, lvl + 1);
	}

	public static void main(String argr[]) {
		tm = new TreeMap<Integer, ArrayList<Integer>>();

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		printInorder(root, 1);
		System.out.println();

		System.out.println(Arrays.asList(tm));
	}
}
