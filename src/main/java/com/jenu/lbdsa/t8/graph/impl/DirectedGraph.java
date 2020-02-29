package com.jenu.lbdsa.t8.graph.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * DirectedGraph
 *
 * @author Janardhanan V S
 *
 */
public class DirectedGraph implements Graph, WeightedGraph {
	
	protected Map<String, List<Edge>> adjacencyList;
	
	public DirectedGraph() {
		adjacencyList = new HashMap<>();
	}
	
	public Map<String, List<Edge>> getAdjacencyList() {
		return adjacencyList;
	}
	
	public List<String> getVertices() {
		return adjacencyList.keySet().stream().collect(Collectors.toList());
	}
	
	public List<Edge> getEdges(String vertex) {
		return adjacencyList.get(vertex);
	}
	
	public void addEdge(String source, String destination) {
		addEdge(new Edge(source, destination, 1));
	}
	
	public void addEdge(String source, String destination, int weight) {
		addEdge(new Edge(source, destination, weight));
	}
	
	public void addEdge(Edge edge) {
		addVertex(edge.getSource(), Arrays.asList(edge));
	}
	
	public void addVertex(String vertex, List<Edge> edges) {
		List<Edge> edgeList = adjacencyList.get(vertex);
		if(edgeList == null) {
			edgeList = new ArrayList<>();
		}
		
		edgeList.addAll(edges);
		adjacencyList.put(vertex, edgeList);
	}
	
	public List<String> breadthFirstSearch(String startingVertex) {
		final List<String> vertexList = new ArrayList<>();
		final Set<String> visitedSet = new HashSet<>();
		final Queue<String> bfsQueue = new LinkedList<>();
		
		bfsQueue.offer(startingVertex);
		
		while(!bfsQueue.isEmpty()) {
			String vertex = bfsQueue.poll();
			if(visitedSet.add(vertex)) {
				vertexList.add(vertex);
				final List<Edge> edgeList = adjacencyList.get(vertex);
				if(edgeList != null) {
					bfsQueue.addAll(edgeList.stream().map(x -> x.getDestination()).collect(Collectors.toList()));
				}
			}
		}
		
		return vertexList;
	}
	
	public List<String> depthFirstSearch(String startingVertex) {
		final List<String> vertexList = new ArrayList<>();
		final Set<String> visitedSet = new HashSet<>();
		final Stack<String> dfsStack = new Stack<>();
		
		dfsStack.push(startingVertex);
		
		while(!dfsStack.isEmpty()) {
			String vertex = dfsStack.pop();
			if(visitedSet.add(vertex)) {
				vertexList.add(vertex);
				final List<Edge> edgeList = adjacencyList.get(vertex);
				if(edgeList != null) {
					final List<String> childVertices = edgeList.stream().map(x -> x.getDestination()).collect(Collectors.toList());
					Collections.reverse(childVertices);
					dfsStack.addAll(childVertices);
				}
			}
		}
		
		return vertexList;
	}

	public static class Edge {
		private String source;
		private String destination;
		private int weight;
		
		public Edge(String source, String destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	}
	
}
