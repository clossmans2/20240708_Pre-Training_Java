package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Minimum Spanning Tree: a subset of the edges of a connected, edge-
// weighted undirected graph that connects all nodes (vertices) without any
// cycles and with the minimum edge weight.
// Output is usually the total weight of that path or the list of
// nodes in the order traversed
// Greedy Algorithm - Picks the best option locally in hopes that it will
// in turn be the best option globally, ignoring potential downsides in the
// moment
// Prim's Algorithm - randomly select a node, add the least expensive
// connection(edge) from the node to the tree, continues adding least
// expensive connection(edge) from the nodes (vertices) already added to
// the spanning tree to grow it and ends when all the nodes are added to
// the tree (greedy)
// Kruskal's Algorithm
// Grabs a node, sorts the connections(edges) of the node in ascending
// order of cost/weight, picks the connection(edge) with the least weight,
// checks if putting this connection onto the tree will form a cycle, if
// it does cause a cycle then ignore the connection, otherwise add it to
// the tree, continue sorting and checking connections till there are
// no more nodes left in the graph (greedy)

public class MSTDemo {

	public static void main(String[] args) {
//		KGraph graph = new KGraph();
//		graph.setVertices(6);
//		graph.addEdge(0, 1, 4);
//		graph.addEdge(0, 2, 3);
//		graph.addEdge(1, 2, 1);
//		graph.addEdge(1, 3, 2);
//		graph.addEdge(2, 3, 4);
//		graph.addEdge(3, 4, 2);
//		graph.addEdge(4, 5, 6);
//		graph.makeMST();
		
		PGraph pgraph = new PGraph(6);
		pgraph.addEdge(0, 1, 4);
		pgraph.addEdge(0, 2, 3);
		pgraph.addEdge(1, 2, 1);
		pgraph.addEdge(1, 3, 2);
		pgraph.addEdge(2, 3, 4);
		pgraph.addEdge(3, 4, 2);
		pgraph.addEdge(4, 5, 6);
		pgraph.makeMST();
		
	}
}

record Edge(int source, int destination, int weight) {}

class KGraph {
	private int vertices;
	private List<Edge> edges;
	
	public KGraph() {
		this.edges = new ArrayList<>();
	}
	
	public KGraph(int vertices) {
		this.vertices = vertices;
		this.edges = new ArrayList<>();
	}
	
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
	
	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		this.edges.add(edge);
	}
	
	public void makeMST() {
		PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(),
				Comparator.comparingInt(o -> o.weight()));
		
		// Add all edges into our queue and let the queue
		// sort them based on weight
		for(int i = 0; i < edges.size(); i++) {
			pq.add(edges.get(i));
		}
		
		int[] parent = new int[vertices];
		makeSet(parent);
		ArrayList<Edge> mst = new ArrayList<>();
		
		// Move through nodes and connections
		int index = 0;
		while(index < vertices - 1) {
			Edge edge = pq.remove();
			int x_set = find(parent, edge.source());
			int y_set = find(parent, edge.destination());
			
			if(x_set == y_set) {
				// could cause a loop
				// Skip
			} else {
				// Save this to MST
				mst.add(edge);
				index++;
				union(parent, x_set, y_set);
			}
		}
		System.out.println("==== Our Minimum Spanning Tree ====");
		printGraph(mst);
	}
	
	public void makeSet(int[] parent) {
		for(int i = 0; i < vertices; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int[] parent, int node) {
		if(parent[node] != node) {
			return find(parent, parent[node]);
		}
		return node;
	}
	
	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		parent[y_set_parent] = x_set_parent;
	}
	
	public void printGraph(ArrayList<Edge> edgeList) {
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			System.out.println("Edge-" + i 
					+ " { source: " + edge.source()
					+ ", destination: " + edge.destination()
					+ ", weight: " + edge.weight() + " }");
		}
	}
}

record Node(int to, int weight) {}

class PGraph {
	private List<List<Node>> graph;
	private boolean[] visited;
	
	public PGraph(int nodes) {
		graph = new ArrayList<>(nodes);
		visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		graph.get(src).add(new Node(dest, weight));
		graph.get(dest).add(new Node(src, weight)); // Undirected, weighted graph
	}
	
	public void makeMST() {
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(a, b) -> a.weight() - b.weight());
		int startNode = 0;
		visited[startNode] = true;
		
		for(Node node : graph.get(startNode)) {
			pq.add(node);
		}
		
		int mstWeight = 0;
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			if (visited[currentNode.to()]) {
				continue;
			}
			
			visited[currentNode.to()] = true;
			mstWeight += currentNode.weight();
			System.out.println("Node added to MST: " 
							+ currentNode.to()
							+ " with weight "
							+ currentNode.weight());
			
			for(Node node : graph.get(currentNode.to())) {
				if(!visited[node.to()]) {
					pq.add(node);
				}
			}
		}
		System.out.println("Total weight of MST: " + mstWeight);
	}
}







