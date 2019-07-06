class Five_a {
	static Node root;
	static class Node {
		int data, size;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.size = 7;
		}
	}

	static int index;
	static void copyBST(Node root, int[] array) {
		if (root == null) return;

		copyBST(root.left, array);
		array[index++] = root.data;
		copyBST(root.right, array);
	}

	static boolean checkBST(Node root) {
		int []array = new int[root.size];
		copyBST(root, array);

		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[i - 1]) return false;
		}
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
