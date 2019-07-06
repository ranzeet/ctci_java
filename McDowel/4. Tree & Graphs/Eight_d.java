/*Finding first common ancestor with out link to parent*/
/*LOGIC: Traverse top to bottom if found just bubble them up*/
/*there is a BUG*//*Th BUG is this code wont work if 'p' or 'q' are not present in the tree*/
class Eight_d {
	static Node root;
	public static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	public Node commonAncestor(Node root, Node p, Node q) {
		if (root == null) return null;
		if (root == p && root == q) return root;
		Node x = commonAncestor(root.left, p, q);
		if (x != null && x != p && x != q) return root;// already found ancestor so just bubblig up
		Node y = commonAncestor(root.right, p, q);
		if (y != null && y != p && y != q) return root;// already found ancestor so just bubblig up

		if (x != null && y != null) return root;	//Common this is the answer!!
		else if (root == p || root == q) return root;	// here we found first node p or q
		else return x == null ? y : x;
	}
	public static void main(String argr[]) {
		root = new Node(8);
		root.left = new Node(6);
		root.right = new Node(10);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		root.right.right = new Node(12);
		
		System.out.println("Common Ancestor is " + new Eight_d().commonAncestor(root, root.left, root.right.left).data);
	}
}
