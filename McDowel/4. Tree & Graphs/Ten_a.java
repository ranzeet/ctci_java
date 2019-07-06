/*Check if Tree 2 is a subtree of Tree1*/
class Ten_a {
	public static Node root1;
	public static Node root2;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	static void getOrderString(Node node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");
			return;
		}
		sb.append(node.data);
		getOrderString(node.left, sb);
		getOrderString(node.right, sb);
	}
	public static boolean containsTree(Node t1, Node t2) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		getOrderString(t1, s1);
		getOrderString(t2, s2);
		return s1.indexOf(s2.toString()) != -1;
	}
	public static void main(String argr[]) {
		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);

		root2 = new Node(3);
		root2.left = new Node(6);
		root2.right = new Node(7);

		System.out.println("Oh!" + (containsTree(root1, root2) ? " YES T2 is " : " NO T2 is not ") + "subtree of T1");
	}
}
