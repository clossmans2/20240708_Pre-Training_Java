package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Shortest Path Algorithms: finding the shortest distance between two nodes/points
// in a weighted graph
// Dijkstra's algorithm
// 1. Start a collection of all nodes in the graph (unvisited)
// 2. First node is 0 and all the others the largest number
// 3. Make the current node = starting node
// 4. Use the current node to check all unvisited neighbors, calculate distance
// adding the weight of the connection (edge) between each of the neighbor.
// 5. Compare distances, and determine distance of neighboring nodes
// 6. Check the current unvisited nodes from the current node and set current node as visited
// 7. Repeat the process until last node is marked as visited, and if not at the end node
// 8. Select the unvisited node with the shortest path, set it to current, repeat step 4

public class PathingDemo {

	public static void main(String[] args) {
//		Map<Integer, List<Node>> graph = new HashMap<>();
//		graph.put(0, Arrays.asList(new Node(1,4), new Node(2,1)));
//		graph.put(1, Arrays.asList(new Node(1,3)));
//		graph.put(2, Arrays.asList(new Node(1,2), new Node(3,5)));
//		graph.put(3, Arrays.asList());
//		PathingDemo pd = new PathingDemo();
//		pd.dijkstraPath(graph, 0);
		
		Dijkstra dijkstra = new Dijkstra(5);
		dijkstra.addEdge(0, 1, 10);
		dijkstra.addEdge(0, 2, 3);
		dijkstra.addEdge(1, 2, 1);
		dijkstra.addEdge(1, 3, 2);
		dijkstra.addEdge(2, 1, 4);
		dijkstra.addEdge(2, 3, 8);
		dijkstra.addEdge(2, 4, 2);
		dijkstra.addEdge(3, 4, 7);
		dijkstra.addEdge(4, 3, 9);
		
		dijkstra.shortestPath(0);
		dijkstra.printDistances();
	}
	
	public void dijkstraPath(Map<Integer, List<Node>> graph, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(
				Comparator.comparingInt(node -> node.cost()));
		Map<Integer, Integer> distances = new HashMap<>();
		for (int node : graph.keySet()) {
			distances.put(node, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			// Grabbing a current node from our PriorityQueue
			Node current = pq.poll();
			// Iterate through each neigbor of a node in the graph
			for(Node neighbor : graph.get(current.node())) {
				// Calculate the distance between the current node and a neighbor
				int newDist = distances.get(current.node()) + neighbor.cost();
				// If new distance is less than neighbor node value
				if (newDist < distances.get(neighbor.node())) {
					// Add the neighbor node value along with the new distance
					distances.put(neighbor.node(), newDist);
					// Adding the neigbor node value with the calculated distance
					pq.add(new Node(neighbor.node(), newDist));
				}
			}
		}
		
		System.out.println("Shortest distances from node " + start + ":");
		for(Map.Entry<Integer, Integer> entry : distances.entrySet()) {
			System.out.println("Node " + entry.getKey() + ": " + entry.getValue());
		}
	}
}

record Node(int node, int cost) {}

class Edge {
	public int to;
	public int weight;
	
	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

class Dijkstra {
	private List<List<Edge>> graph;
	private int[] distances;
	private boolean[] visited;
	
	public Dijkstra(int vertices) {
		this.graph = new ArrayList<>(vertices);
		this.distances = new int[vertices];
		this.visited = new boolean[vertices];
		
		for(int i = 0; i < vertices; i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int from, int to, int weight) {
		graph.get(from).add(new Edge(to, weight));
	}
	
	public void shortestPath(int src) {
		// Filling up the distances array with max values
		Arrays.fill(distances, Integer.MAX_VALUE);
		// Set the starting node value = 0;
		distances[src] = 0;
		// Use a priority queue of edges to hold the nodes to visit in order
		PriorityQueue<Edge> pq = new PriorityQueue<>(
				(a, b) -> a.weight - b.weight);
		// Add our starting node to the queue.
		pq.add(new Edge(src, 0));
		
		// As long as we still have nodes to visit/check
		while(!pq.isEmpty()) {
			// Get reference to our current edge
			Edge current = pq.poll();
			// Get reference to our current node (vertex)
			// we use the to property
			int vertex = current.to;
			// We check to see if we've visited a node yet
			if(visited[vertex]) {
				// Keep going if we have
				continue;
			}
			// Otherwise we set that value to true
			// Before we check it
			visited[vertex] = true;
			
			// For each connection (edge) to our current node (vertex)
			for(Edge edge : graph.get(vertex)) {
				// If current node distance plus the weight of the
				// connection is less than the distance to the next node
				if(distances[vertex] + edge.weight < distances[edge.to]) {
					// We set the distance to the next node equal to
					// the current node distance plus the weight of the
					// connection
					distances[edge.to] = distances[vertex] + edge.weight;
					// Add a new connection to our priority queue
					// using the next node and the distance to the next node
					pq.add(new Edge(edge.to, distances[edge.to]));
				}
			}
		}
	}
	
	public void printDistances() {
		System.out.println("Vertex distance from Source");
		for(int i = 0; i < distances.length; i++) {
			System.out.println(i + "\t\t " + distances[i]);
		}
	}
}


















