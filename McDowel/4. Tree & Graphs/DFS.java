import java.util.*;
class Graph {
		int vertices;
		LinkedList<Integer> adj[];
		ArrayList<Integer> res;
		boolean visited[];

		public Graph(int v) {
			this.vertices = v;
			adj = new LinkedList[v];
			res = new ArrayList<Integer>();
			visited = new boolean[v];

			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int v1, int v2) {
			adj[v1].add(v2);
		}

		public void DFS() {
			for (boolean each : visited) { each = false; }

			for (int i = 0; i < vertices; i++) {
				DFS(i);
			}
		}
		
		public void DFS(int v) {
			if (!visited[v]) {
				visited[v] = true;
				res.add(v);
				for (Integer ech : adj[v]) {
					DFS(ech);
				}
			}
		}
	}

public class DFS {
	public static void main(String argr[]) {
		Graph graph = new Graph(8);
		graph.addEdge(5, 2);
		graph.addEdge(5, 1);
		graph.addEdge(5, 0);
		graph.addEdge(2, 0);
		graph.addEdge(1, 0);
		graph.addEdge(1, 4);
		graph.addEdge(1, 7);
		graph.addEdge(0, 4);
		graph.addEdge(3, 6);		

		System.out.println(Arrays.asList(graph.res));
		graph.DFS();
		System.out.println(Arrays.asList(graph.res));
	}
}
