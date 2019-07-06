import java.util.Random;
class Eleven_b {
	static Node root;
	static class Node {
		int data, size;
		Node left, right;
		public Node(int data) {
			this.data = data;
			this.size = 1;
		}
		public Node getIthNode(int i) {
			int leftSize = left == null ? 0 : left.size;
			if (i < leftSize) {
				return left.getIthNode(i);
			} else if (i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
		public void insertInOrder(int d) {
			if (d <= data) {
				if (left == null) {
					left = new Node(d);
				} else {
					left.insertInOrder(d);
				}
			} else {
				if (right == null) {
					right = new Node(d);
				} else {
					right.insertInOrder(d);
				}
			}
			size++;
		}
		public Node find(int d) {
			if (d == data) return this;
			if (d < data) {
				return left == null ? null : left.find(d);
			} else {
				return right == null ? null : right.find(d);
			}
		}
	}
	public int size() {return root == null ? 0 : root.size;}
	public void insertInOrder(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insertInOrder(value);
		}
	}
	public Node getRandomNode() {
		if (root == null) return null;
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
	public static void main(String argr[]) {
		Eleven_b e = new Eleven_b();
		int arr[] = {20, 10, 30, 5, 15, 35, 3, 7, 17};
		for (int i : arr) e.insertInOrder(i);

		System.out.println("Printing random Node : " + e.getRandomNode().data);
	}
}
