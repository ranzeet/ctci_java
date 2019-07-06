import java.util.*;
class Seven_b {
	public boolean doDFS(Project p, Stack<Project> stack) {
		if (p.getState() == Project.State.PARTIAL) return false;
		if (p.getState() == Project.State.BLANK) {
			p.setState(Project.State.PARTIAL);
			ArrayList<Project> children = p.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) return false;
			}
			p.setState(Project.State.COMPLETE);
			stack.push(p);
		}
		return true;
	}
	public Stack<Project> buildOrder(Graph g) {
		Stack<Project> stack = new Stack<Project>();
		for (Project p : g.getVertices()) {
			if (p.getState() == Project.State.BLANK) {
				if (!doDFS(p, stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	public Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String p : projects) { graph.createNode(p); }
		for (String[] deps : dependencies) { graph.addEdge(deps[0], deps[1]); }
		return graph;
	}
	public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph g = buildGraph(projects, dependencies);
		return buildOrder(g);
	}
	class Graph {
		ArrayList<Project> vertices = new ArrayList<Project>();
		HashMap<String, Project> map = new HashMap<String, Project>();

		Project createNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				vertices.add(node);
				map.put(name, node);
				return node;
			}
			return map.get(name);
		}

		public void addEdge(String first, String second) {
			Project f = createNode(first);
			Project s = createNode(second);
			f.addNeighbour(s);
		}

		public ArrayList<Project> getVertices() { return vertices; }
	}
	public static class Project {
		ArrayList<Project> children = new ArrayList<Project>();
		HashMap<String, Project> map = new HashMap<String, Project>();
		String name;
		public Project(String name) { this.name = name; }

		public enum State {COMPLETE, PARTIAL, BLANK};
		private State state = State.BLANK;
		
		public State getState() { return state; }
		public void setState(State state) { this.state = state; }

		public void addNeighbour(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
			}
		}

		public String getName() { return this.name; }
		public ArrayList<Project> getChildren() { return children; }				
	}

	public static void main(String argr[]) {
		Seven_b obj = new Seven_b();
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {{"f","c"}, {"f","b"}, {"f","a"}, {"a","e"}, {"b","a"}, {"b","e"}, {"b","h"}, {"d","g"},};

		Stack<Project> res = obj.findBuildOrder(projects, dependencies);

		while (!res.isEmpty()) System.out.print(res.pop().getName() + " ");
		System.out.println();
	}
}
