/*solution #2: The Min/Max Solution*/
/*In BST inorder-traversal observe that right tree maintains minimum and left maintains maximum*/
class Five_c {
	static Node root;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static boolean checkBST(Node n, Integer min, Integer max) {
		if (n == null) return true;

		if ((min != null && n.data <= min) || (max != null && n.data > max))
			return false;
		if (!checkBST(n.left, min, n.data)) return false;
		if (!checkBST(n.right, n.data, max)) return false;

		return true;
	}

	static boolean checkBST(Node root) {
		return checkBST(root, null, null);
	}

	public static void main(String argr[]) {
				        root = new Node(6);		
		  root.left = new Node(4);		  root.right = new Node(8);
		
		root.left.left = new Node(3);		root.right.left = new Node(7);
		root.left.right = new Node(5);		root.right.right = new Node(9);

		if (checkBST(root)) {
			System.out.println("This tree is a BST");
		} else {
			System.out.println("This is not a BST");
		}
	}
}
