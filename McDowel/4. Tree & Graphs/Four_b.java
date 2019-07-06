// O ( N )
class Four_b {
	static Node root;
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	public static int checkHeight(Node root) {
		if (root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
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
		//root.right.left.left.left = new Node(7);

		if (checkHeight(root) == Integer.MIN_VALUE) {
			System.out.println("Tree is imbalanced");
		} else {
			System.out.println("Tree is balanced");
		}
	}
}
