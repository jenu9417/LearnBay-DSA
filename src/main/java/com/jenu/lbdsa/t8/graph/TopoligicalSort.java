package com.jenu.lbdsa.t8.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph.Edge;
import com.jenu.lbdsa.t8.graph.impl.DirectedGraph;
import com.jenu.lbdsa.t8.graph.impl.Graph;

/**
 * Topological Sort
 * ----------------
 * Topological sort is used sort vertices according to their dependency from least dependent to most dependent.
 * Build systems and tools such as Maven and Jenkins use top sort to resolve dependency issues.
 * 
 * TopSort works only for DAG - Directed Acyclic Graph
 * 
 * Time:
 * -----
 * O(V+E)
 *
 * @author Janardhanan V S
 *
 */
public class TopoligicalSort {

	static List<String> topologicalSort(Graph graph) {
		final Map<String, List<Edge>> adjacencyList = graph.getAdjacencyList();
		final Stack<String> dfsStack = new Stack<>();
		final Set<String> visitedSet = new HashSet<>();
		final List<String> vertexList = new ArrayList<>();
		
		for(String	vertex : adjacencyList.keySet()) {
			dfs(vertex, dfsStack, visitedSet, adjacencyList);
		}
		
		while(!dfsStack.isEmpty()) {
			vertexList.add(dfsStack.pop());
		}
		
		return vertexList;
	}
	
	static void dfs(String current, Stack<String> dfsStack, Set<String> visitedSet, Map<String, List<Edge>> adjacencyList) {
		if(visitedSet.contains(current)) {
			return;
		}
		visitedSet.add(current);
		final List<Edge> edgeList = adjacencyList.get(current);
		if(edgeList != null && !edgeList.isEmpty()) {
			for(Edge edge : edgeList) {
				if(visitedSet.contains(edge.getDestination())) {
					continue;
				}
				dfs(edge.getDestination(), dfsStack, visitedSet, adjacencyList);
			}
		}
		dfsStack.push(current);
	}
	
	public static void main(String[] args) {
		Graph graph = new DirectedGraph();
		graph.addEdge("C", "N");
		graph.addEdge("C", "M");
		graph.addEdge("M", "N");
		graph.addEdge("A", "C");
		graph.addEdge("A", "B");
		graph.addEdge("S", "A");
		graph.addEdge("K", "B");
		
		final List<String> vertexList = topologicalSort(graph);
		System.out.println("Top Sort : " + String.join(" -> ", vertexList));
	}
}
