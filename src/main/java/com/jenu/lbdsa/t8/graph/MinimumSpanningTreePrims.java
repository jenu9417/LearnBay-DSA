package com.jenu.lbdsa.t8.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph.Edge;
import com.jenu.lbdsa.t8.graph.impl.UnDirectedGraph;
import com.jenu.lbdsa.t8.graph.impl.WeightedGraph;

/**
*
* MinimumSpanningTreeKruskals
* ---------------------------
*
* Approach:
* ---------
*
* In Prims Algorithm, we start with one vertex. Find the smallest outgoing edge, add it to visited vertices.
* Then from the network of visited vertices, find the smallest outgoing edge.
* This process is continued till we visit all the vertices.
*
* We can visualize Prim's algorithm as similar to infection spreading in one direction.
*
* The difference between prims and kruskals algorithm is that, prims moves in one direction from visted vertices to
* unvisited vertices where as in kruskal, smallest possible edge is chosen.
* 
* Time  : O((V+E)logV)
*
* @author Janardhanan V S
*
*/

public class MinimumSpanningTreePrims {
	
	private WeightedGraph graph;
	
	public MinimumSpanningTreePrims() {
		graph = new UnDirectedGraph();
	}
	
	public void fillGraph() {
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 7);
		graph.addEdge("B", "C", 5);
		graph.addEdge("B", "D", 4);
		graph.addEdge("D", "E", 2);
		graph.addEdge("B", "E", 3);
		graph.addEdge("E", "C", 6);
	}
	
	public List<String> getMinimumSpanningTree(String startingVertex) {
		final List<String> vertexList = new ArrayList<>();
		final Set<String> visitedSet = new HashSet<>();
		final int totalVertices = graph.getVertices().size();
		final PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.getWeight(), o2.getWeight());
			}
		});
		
		edgeQueue.offer(new Edge(null, startingVertex, 1));
		
		do {
			final Edge edge = edgeQueue.poll();
			if(visitedSet.add(edge.getDestination())) {
				vertexList.add(edge.getDestination());
				final List<Edge> edgeList = graph.getEdges(edge.getDestination());
				if(edgeList != null) {
					edgeList.stream().forEach(x -> edgeQueue.offer(x));
				}
			}
		} while(vertexList.size() < totalVertices);
		
		return vertexList;
	}
	
	public static void main(String[] args) {
		MinimumSpanningTreePrims mst = new MinimumSpanningTreePrims();
		mst.fillGraph();
		List<String> mstList = mst.getMinimumSpanningTree("A");
		System.out.println("Minimum Spanning Tree : ");
		System.out.println(String.join(" -> ", mstList));
	}

}
