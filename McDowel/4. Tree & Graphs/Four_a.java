// O ( NlogN )
class Four_a {
	static Node root;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static int getHeight(Node root) {
		if (root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	
	}

	static boolean isBalanced(Node root) {
		if (root == null) return true;

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		
	}
	public static void main(String argr[]) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		//root.right.left.left = new Node(7); //imbalanced case

		if (isBalanced(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}

	}
}
