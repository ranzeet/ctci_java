/*Check if Tree 2 is a subtree of Tree1*/
class Ten_b {
	public static Node root1;
	public static Node root2;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	static boolean matchTree(Node r1, Node r2) {
		if (r1 == null && r2 == null) return true;
		if (r1 == null || r2 == null) return false;
		if (r1.data != r2.data) return false;
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
	}
	static boolean subTree(Node r1, Node r2) {
		if (r1 == null) return false;
		if (r1.data == r2.data && matchTree(r1, r2)) return true;
		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}
	public static boolean containsTree(Node t1, Node t2) {
		if (t2 == null) return true;
		return subTree(t1, t2);
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
