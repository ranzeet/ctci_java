class Eight_e {
	static Node root;
	public static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	public static class Result {
		boolean isAncestor;
		Node node;
		public Result(Node node, boolean isAnc) {
			this.node = node;
			this.isAncestor = isAnc;
		}
	}
	public Result commonAncHelper(Node root, Node p, Node q) {
		if (root == null) return new Result(null, false);
		if (root == p && root == q) return new Result(root, true);

		Result rx = commonAncHelper(root.left, p, q);
		if (rx.isAncestor) return rx;
		Result ry = commonAncHelper(root.right, p, q);
		if (ry.isAncestor) return ry;

		if (rx.node != null && ry.node != null) return new Result(root, true);
		else if (root == p || root == q) return new Result(root, rx.node != null || ry.node != null);	// this is y v r here
		else return new Result(rx.node != null ? rx.node : ry.node, false);
	}
	public Node commonAncestor(Node root, Node p, Node q) {
		Result r = commonAncHelper(root, p, q);
		if (r.isAncestor) return r.node;
		return null;
	}
	public static void main(String argr[]) {
		root = new Node(8);
		root.left = new Node(6);
		root.right = new Node(10);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		root.right.right = new Node(12);
		
		System.out.println("Common Ancestor is " + new Eight_e().commonAncestor(root, root.left, root.right.left).data);
	}
}
