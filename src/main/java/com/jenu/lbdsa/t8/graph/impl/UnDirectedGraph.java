package com.jenu.lbdsa.t8.graph.impl;

/**
 * UnDirectedGraph
 *
 * @author Janardhanan V S
 *
 */
public class UnDirectedGraph extends DirectedGraph {
	
	@Override
	public void addEdge(String source, String destination) {
		addEdge(new Edge(source, destination, 1));
		addEdge(new Edge(destination, source, 1));
	}
	
	@Override
	public void addEdge(String source, String destination, int weight) {
		addEdge(new Edge(source, destination, weight));
		addEdge(new Edge(destination, source, weight));
	}
	
}
