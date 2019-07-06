class Six_a {
	static Node root;
	static class Node {
		int data;
		Node left, right, parent;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node leftMostChild(Node n) {
		if (n == null) return null;

		while (n.left != null)
			n = n.left;
		return n;
	}

	public static Node inOrderSuccessor(Node n) {
		if (n == null) return null;

		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			Node q = n;
			Node x = q.parent;

			while (q != x.left && x != null) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	public static void main(String argr[]) {
		root = new Node(8);			root.parent = null;
		root.left = new Node(6);		root.left.parent = root;
		root.right = new Node(10);		root.right.parent = root;
		root.left.left = new Node(3);		root.left.left.parent = root.left;
		root.left.right = new Node(7);		root.left.right.parent = root.left;
		root.right.left = new Node(9);		root.right.left.parent = root.right;
		root.right.right = new Node(12);	root.right.right.parent = root.right;

		Node successor = inOrderSuccessor(root.left.right );

		System.out.println("The In-order successor of " + root.left.right .data + " is "
			+ successor.data);
	}
}
