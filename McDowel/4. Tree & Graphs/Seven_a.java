import java.util.*;
class Seven_a {
	int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project p : projects) {
			if (p.getDependencies() == 0) order[offset++] = p;
		}
		return offset;
	}

	Project[] buildOrder(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];
		int endOfList = addNonDependent(order, projects, 0);
		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			if (current == null) return null;
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) { child.decrementDependencies(); }
			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}
		return order;
	}
	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph g = new Graph();
		for (String project : projects) { g.createNode(project); }
		for (String[] dependency : dependencies) { g.addEdge(dependency[0], dependency[1]); }
		return g;
	}
	class Project {
		ArrayList<Project> children = new ArrayList<Project>();
		HashMap<String, Project> map = new HashMap<String, Project>();
		int dependencies;
		String name;

		public Project(String name) { this.name = name; }

		void addNeighbour(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
				node.incrementDependencies();
			} 
		}

		String getName() { return name; }
		int getDependencies() { return dependencies; }
		void incrementDependencies() { dependencies++; }
		void decrementDependencies() { dependencies--; }
		ArrayList<Project> getChildren() { return children; }
	}
	class Graph {
		ArrayList<Project> nodes = new ArrayList<Project>();
		HashMap<String, Project> map = new HashMap<String, Project>();

		Project createNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		void addEdge(String firstNode, String secondNode) {
			Project first = createNode(firstNode);
			Project second = createNode(secondNode);
			first.addNeighbour(second);
		}

		public ArrayList<Project> getNodes() { return nodes;}
	}
	public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return buildOrder(graph.getNodes());
	}
	public static void main(String argr[]) {
		Seven_a obj = new Seven_a();
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {{"f","c"}, {"f","b"}, {"f","a"}, {"a","e"}, {"b","a"}, {"b","e"}, {"b","h"}, {"d","g"},};

		Project[] res = obj.findBuildOrder(projects, dependencies);

		for (Project p : res) System.out.println(p.getName() + " ");
	}
}
