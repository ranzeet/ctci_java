class Node {
	public int adjacentCount;
	private Node[] adjacent;
	private String vertex;
	public One_a.State state;

	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacent = new Node[adjacentLength];
		adjacentCount = 0;
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < adjacent.length) {
			adjacent[adjacentCount++] = x;
		} else {
			System.out.println("No more adjacent can be added");
		}
	}

	public Node[] getAdjacent() { return adjacent; };

	public String getVertex() { return vertex; }
}
