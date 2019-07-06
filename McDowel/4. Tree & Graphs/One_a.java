import java.util.*;
class One_a {
	public static enum State {
		Unvisited, Visiting, Visited
	}

	public static boolean search(Graph g, Node start, Node end) {
		if (start == end) return true;

		Queue<Node> q = new LinkedList<Node>();

		for (Node u : g.getNodes())
			u.state = State.Unvisited;		

		q.add(start);
		start.state = State.Visiting;
		while (!q.isEmpty()) {
			Node u = q.poll();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();

		Node temp[] = new Node[6];
		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);

		for (int i = 0; i < 6; i++)
			g.addNode(temp[i]);
		return g;		
	}

	public static void main(String argr[]) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();

		System.out.println(search(g, n[0], n[5]));
	}
}
