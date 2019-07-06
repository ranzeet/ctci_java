import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class BinarySearchTree {
	static Node root;
	static class Node {
		int value;
		Node left, right;
		
		public Node(int data) {
			this.value = data;
		}
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;
		}

		if (data < node.value) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);	
		}
		return node;
	}

	private static Node constructBt(Node root, int[] inp) {
		for (int e : inp) {
			root = insert(root, e);
		}
		return root;
	}

	public static void preorder(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	public static void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");
	}

	public static void bfs(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.value + " ");		
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	public static void display(Node root) {
		System.out.println("Inorder Traversal is : ");
		inorder(root);
		System.out.println("\nPreOrder Traversal is : ");
		preorder(root);
		System.out.println("\nPostOrder Traversal is : ");
		postorder(root);
		System.out.println("\nBFS Traversal is : ");
		bfs(root);
		System.out.println();
	}

	public static void main(String argr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values to construct a binary search tree (space separated values)");
		String rawInput = sc.nextLine();

		int intArr[] = new int[rawInput.split(" ").length];
		int next = 0;

		for (String e : rawInput.split(" ")) {
			intArr[next++] = Integer.parseInt(e);
		}

		//System.out.println(java.util.Arrays.toString(intArr));
		
		root = constructBt(root, intArr);

		display(root);
	}
}

