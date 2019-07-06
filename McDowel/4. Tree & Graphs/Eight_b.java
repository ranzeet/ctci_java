class Eight_b {
	static Node root;
	static class Node {
		int data;
		Node left, right, parent;

		public Node(int data) {
			this.data = data;
		}
	}
	public static Node getSibling(Node node) {
		if (node == null || node.parent == null) return null;
		Node parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
	public static boolean covers(Node root, Node p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	public static Node commonAncestor(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) return null;

		if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}

		Node sibling = getSibling(p);
		Node parent = p.parent;
		while (!covers(sibling, q)) {
			parent = parent.parent;
			sibling = getSibling(parent);
		}
		return parent;
	}
	public static void main(String argr[]) {
		root = new Node(8);			root.parent = null;
		root.left = new Node(6);		root.left.parent = root;
		root.right = new Node(10);		root.right.parent = root;
		root.left.left = new Node(3);		root.left.left.parent = root.left;
		root.left.right = new Node(7);		root.left.right.parent = root.left;
		root.right.left = new Node(9);		root.right.left.parent = root.right;
		root.right.right = new Node(12);	root.right.right.parent = root.right;
		
		System.out.println("Common Ancestor is " + commonAncestor(root, root.left, root.right.left).data);
	}
}
