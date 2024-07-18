package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Graph: data structure with nodes (vertices) and edges (connections)
// Directed or undirected
// Undirected -> the connections don't have a specific direction
// Directed -> connection do have a specific direction


public class GraphDemo {

	public static void main(String[] args) {
		Graph<String> airportGraph = new Graph<>();
		
		airportGraph.addNode("Atlanta");
		airportGraph.addNode("Newark");
		airportGraph.addNode("Charlotte");
		airportGraph.addNode("Miami");
		airportGraph.addNode("Los Angeles(LAX)");
		airportGraph.addNode("New York(JFK)");
		airportGraph.addNode("Chicago");
		airportGraph.addNode("Boston");
		
		airportGraph.addConnection("Charlotte","Atlanta");
		airportGraph.addConnection("Charlotte","New York(JFK)");
		airportGraph.addConnection("Atlanta","Boston");
		airportGraph.addConnection("Charlotte","Newark");
		airportGraph.addConnection("Charlotte","Miami");
		airportGraph.addConnection("Atlanta","Los Angeles(LAX)");
		airportGraph.addConnection("Atlanta","New York(JFK)");
		airportGraph.addConnection("Newark","Miami");
		airportGraph.addConnection("Los Angeles(LAX)","Miami");
		
		System.out.println("Is Charlotte connected to Atlanta? " 
							+ airportGraph.isConnected("Charlotte", "Atlanta"));
		System.out.println("Is Los Angeles connected to Boston? " 
				+ airportGraph.isConnected("Los Angeles(LAX)", "Boston"));
		
		System.out.println("How many airports are in the system? " 
							+ airportGraph.getNumberOfNodes());
		
		airportGraph.printGraph();
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







