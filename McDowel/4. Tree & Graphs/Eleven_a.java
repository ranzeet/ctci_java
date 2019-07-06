import java.util.Random;
class Eleven_a {
	class Node {
		int data, size;
		Node left, right;
		public Node(int data) {
			this.data = data;
			this.size = 1;
		}
		public Node getRandomNode() {
			int leftSize = left == null ? 0 : left.size;
			Random random = new Random();
			int index = random.nextInt(size);
			if (index < leftSize) {
				return left.getRandomNode();
			} else if (index == leftSize) {
				return this;
			} else {
				return right.getRandomNode();
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
	public static void main(String argr[]) {
		Eleven_a e = new Eleven_a();
		Eleven_a.Node en = e.new Node(20);
		int arr[] = {10, 30, 5, 15, 35, 3, 7, 17};
		for (int i : arr) en.insertInOrder(i);

		System.out.println("Printing random Node : " + en.getRandomNode().data);
	}
}
