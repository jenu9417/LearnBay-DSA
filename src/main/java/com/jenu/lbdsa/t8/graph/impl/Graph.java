package com.jenu.lbdsa.t8.graph.impl;

import java.util.List;
import java.util.Map;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph.Edge;

/**
 * Graph
 * 
 * @author Janardhanan V S
 *
 */
public interface Graph {

	void addEdge(String source, String destination);
	
	void addEdge(Edge edge);
	
	void addVertex(String vertex, List<Edge> edges);
	
	Map<String, List<Edge>> getAdjacencyList();
	
	List<String> getVertices();
	
	List<Edge> getEdges(String vertex);
	
	List<String> breadthFirstSearch(String startingVertex);
	
	List<String> depthFirstSearch(String startingVertex);
}
