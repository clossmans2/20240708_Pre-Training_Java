package search;

import java.util.*;

// Traversal Algorithms
// Breadth First Search - Across, starts at root node and explores 
// all neighbor nodes at that depth before moving downward another level
// Depth First Search - Down, starts at root node and explores are far as possible
// along each branch downward before backtracking and exploring neighbors

public class SearchDemo {

	public static void main(String[] args) {
		Graph<Integer> intGraph = new Graph<Integer>();
		intGraph.addNode(1);
		intGraph.addNode(2);
		intGraph.addNode(3);
		intGraph.addNode(4);
		intGraph.addNode(5);
		intGraph.addNode(6);
		intGraph.addNode(7);
		intGraph.addNode(8);
		intGraph.addNode(9);
		intGraph.addNode(10);
		intGraph.addNode(11);
		intGraph.addNode(12);
		intGraph.addConnection(1, 2);
		intGraph.addConnection(1, 3);
		intGraph.addConnection(2, 4);
		intGraph.addConnection(2, 5);
		intGraph.addConnection(3, 6);
		intGraph.addConnection(4, 7);
		intGraph.addConnection(4, 8);
		intGraph.addConnection(5, 9);
		intGraph.addConnection(5, 10);
		intGraph.addConnection(6, 11);
		intGraph.addConnection(6, 12);
		
		SearchDemo search = new SearchDemo();
		Set<Integer> visited = new HashSet<>();
		System.out.println("DFS starting with node 1");
		search.depthSearch(intGraph, 1, visited);
		System.out.println("BFS starting with node 1");
		search.breadthSearch(intGraph, 1);
	}
	////	      1
	////		 / \
	////	    2   3
	////	   / \   \
	////	  4   5   6
	////	 / \ / \ / \ 
	////	7  8 9 1011 12  
	public void depthSearch(Graph<Integer> graph, int start, Set<Integer> visited) {
		visited.add(start);
		System.out.println(start + " ");
		
		for (int neighbor : graph.getFriends(start)) {
			if (!visited.contains(neighbor)) {
				depthSearch(graph, neighbor, visited);
			}
		}
	}
	
	public void breadthSearch(Graph<Integer> graph, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		
		queue.add(start);
		visited.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node + " ");
			
			for (int neighbor : graph.getFriends(node)) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}
}

class Graph<T> {
	private Map<T, List<T>> adjacencyList;
	
	public Graph() {
		this.adjacencyList = new HashMap<>();
	}
	
	public void addNode(T v) {
		if(!adjacencyList.containsKey(v)) {
			adjacencyList.put(v, new ArrayList<>());
		}
	}
	
	public void addConnection(T v1, T v2) {
		if(adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
			adjacencyList.get(v1).add(v2);
			adjacencyList.get(v2).add(v1);
		} else {
			System.out.println("Both nodes must exist to form a connection");
		}
	}
	
	public void removeConnection(T v1, T v2) {
		if(adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
			adjacencyList.get(v1).remove(v2);
			adjacencyList.get(v2).remove(v1);
		}
	}
	
	public List<T> getFriends(T v) {
		if (!adjacencyList.containsKey(v)) {
			throw new RuntimeException("Node " + v + " not found in the graph.");
		}
		return adjacencyList.get(v);
	}
	
	public boolean isConnected(T v1, T v2) {
		return adjacencyList.get(v1).contains(v2);
	}
	
	public int getNumberOfNodes() {
		return adjacencyList.keySet().size();
	}
	
	public void printGraph() {
		System.out.println("Graph overview");
		System.out.println("=====================");
		for (Map.Entry<T, List<T>> entry : adjacencyList.entrySet()) {
			System.out.println(entry.getKey() + " :==: " + entry.getValue());
		}
		System.out.println("=====================");
	}
}

