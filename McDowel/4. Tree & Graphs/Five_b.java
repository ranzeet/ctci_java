/*Don't need an array directlt check if previous element is less or not to current element in inorder - traversal*/
class Five_b {
	static Node root;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static Integer last_visited;
	static boolean checkBST(Node root) {
		if (root == null) return true;

		if (!checkBST(root.left)) return false;
		if (last_visited != null && root.data <= last_visited) return false;
		last_visited = root.data;
		if (!checkBST(root.right)) return false;

		return true;
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
