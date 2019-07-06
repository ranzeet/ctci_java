class Graph {
	private static final int MAX_LENGTH = 6;
	private Node[] vertices;
	public int vertexCount;

	public Graph() {
		vertices = new Node[MAX_LENGTH];
		vertexCount = 0;
	}

	public void addNode(Node x) {
		if (vertexCount < MAX_LENGTH) {
			vertices[vertexCount++] = x;
		} else {
			System.out.println("Graph is full");
		}
	}

	public Node[] getNodes() { return vertices; }
}
