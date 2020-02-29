package com.jenu.lbdsa.t8.graph.impl;

import java.util.List;
import java.util.Map;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph.Edge;

/**
 * WeightedGraph
 * 
 * @author Janardhanan V S
 *
 */
public interface WeightedGraph {
	
	void addEdge(String source, String destination, int weight);
	
	void addEdge(Edge edge);
	
	void addVertex(String vertex, List<Edge> edges);
	
	Map<String, List<Edge>> getAdjacencyList();
	
	List<String> getVertices();
	
	List<Edge> getEdges(String vertex);
	
	List<String> breadthFirstSearch(String startingVertex);
	
	List<String> depthFirstSearch(String startingVertex);

}
