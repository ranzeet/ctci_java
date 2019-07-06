/*Finding first common ancestor with out link to parent*/
/*LOGIC: Traverse top to bottom the place where after one node is in left and other in right!!! done it is it*/
class Eight_c {
	static Node root;
	public static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	public Node ancestorHelper(Node root, Node p, Node q) {
		if (root == null || root == p || root == q) return root;
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);

		if (pIsOnLeft != qIsOnLeft) return root;
		Node childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}
	public boolean covers(Node root, Node m) {
		if (root == null) return false;
		if (root == m) return true;
		return covers(root.left, m) || covers(root.right, m);
		
	}
	public Node commonAncestor(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) return null;
		return ancestorHelper(root, p, q);
	}
	public static void main(String argr[]) {
		root = new Node(8);
		root.left = new Node(6);
		root.right = new Node(10);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		root.right.right = new Node(12);
		
		System.out.println("Common Ancestor is " + new Eight_c().commonAncestor(root, root.left, root.right.left).data);
	}
}
