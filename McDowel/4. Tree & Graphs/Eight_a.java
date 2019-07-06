/*First Common Ancesstor*/
import java.util.*;
class Eight_a {
	static Node root;
	static Queue<Node> q = new LinkedList<Node>();
	static class Node {
		int data;
		Node left, right, parent;

		public Node(int data) {
			this.data = data;
		}
	}
	public static Node goUpBy(Node deep, int delta) {
		while (delta != 0 && deep != null) {
			deep = deep.parent;
			delta--;
		}
		return deep;
	}
	public static int depth(Node node) {
		Node temp = node;
		int count = 0;
		while (temp != null) {
			count += 1;
			temp = temp.parent; 
		}
		return count;
	} 
	public static Node commonAncestor(Node p, Node q) {
		int delta = depth(p) - depth(q);
		Node first = delta > 0 ? q : p; //shallow
		Node second = delta > 0 ? p : q; //deep
		second = goUpBy(second, Math.abs(delta)); //moving deeeeeeeeper node up

		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return second;
	}
	public static void main(String argr[]) {
		root = new Node(8);			root.parent = null;
		root.left = new Node(6);		root.left.parent = root;
		root.right = new Node(10);		root.right.parent = root;
		root.left.left = new Node(3);		root.left.left.parent = root.left;
		root.left.right = new Node(7);		root.left.right.parent = root.left;
		root.right.left = new Node(9);		root.right.left.parent = root.right;
		root.right.right = new Node(12);	root.right.right.parent = root.right;
		
		System.out.println("Common Ancestor is " + commonAncestor(root.left, root.right.left).data);
	}
}

