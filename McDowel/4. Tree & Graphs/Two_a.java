class Two_a {
	static Node root;
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node createMinimalBst(int arr[], int l, int h) {
		Node temp = null;
		if (l <= h) {
			int mid = (l + h) / 2;
			temp = new Node(arr[mid]);
			temp.left = createMinimalBst(arr, l, mid - 1);
			temp.right = createMinimalBst(arr, mid + 1, h);		
		}
		return temp;
	}

	public static void printInorder(Node root) {
		if (root == null) return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static int height(Node node) {
		if (node == null) return 0;
		else {
			int l = height(node.left);
			int r = height(node.right);

			return l > r ? l + 1 : r + 1;
		}
	}

	public static void main(String argr[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		root = createMinimalBst(arr, 0, arr.length - 1);

		printInorder(root);
		System.out.println();
		System.out.println("height of tree is " + height(root));
	}
}
