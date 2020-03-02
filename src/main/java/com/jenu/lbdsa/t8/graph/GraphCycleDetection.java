package com.jenu.lbdsa.t8.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph;
import com.jenu.lbdsa.t8.graph.impl.DirectedGraph.Edge;
import com.jenu.lbdsa.t8.graph.impl.Graph;

/**
 * 
 * Cycle Detection
 * ---------------
 * 
 * A graph is said to contain cycle if there are backedges in it.
 * 
 * Approach:
 * ---------
 * a) Iteratate through vertices and do a DFS. Flag the visited ones, available in the current recursion stack
 *    and check if there is any node visited twice.
 * b) Special Case: In case of undirected graphs, the parent from which we move will also be a child to the current
 *    node. Hence we have to ignore the parent.
 *
 * Time:  O(n)
 * 
 *
 * @author Janardhanan V S
 *
 */
public class GraphCycleDetection {
	
	public static boolean cycleExists(Graph graph) {
		final Map<String, List<Edge>> adjacencyList = graph.getAdjacencyList();
		final boolean isDirectedGraph = (graph instanceof DirectedGraph);
		final Set<String> visitedSet = new HashSet<>();
		boolean cycleExists = false;
		
		for(String vertex : adjacencyList.keySet()) {
			cycleExists = recursiveFindCycle(vertex, null, adjacencyList, visitedSet, isDirectedGraph);
			if(cycleExists) {
				break;
			}
		}
		
		return cycleExists;
	}
	
	public static boolean recursiveFindCycle(String current, String parent, Map<String, List<Edge>> adjacencyList, Set<String> visitedSet, boolean isDirectedGraph) {
		final List<Edge> edgeList = adjacencyList.get(current);
		boolean cycleExists = false;
		if(edgeList == null || edgeList.isEmpty()) {
			return cycleExists;
		}
		
		visitedSet.add(current);
		
		for(Edge edge : edgeList) {
			final String next = edge.getDestination();
			if(!isDirectedGraph && next.equals(parent)) {
				continue;
			}
			if(visitedSet.contains(next)) {
				cycleExists = true;
				break;
			}
			cycleExists = recursiveFindCycle(next, current, adjacencyList, visitedSet, isDirectedGraph);
			if(cycleExists) {
				break;
			}
		}
		
		visitedSet.remove(current);
		return cycleExists;
	}
	
	public static void main(String[] args) {
		Graph graph = new DirectedGraph();
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("D", "A");
		graph.addEdge("A", "E");
		graph.addEdge("E", "F");
		graph.addEdge("B", "G");
		graph.addEdge("G", "H");
		graph.addEdge("C", "I");
		graph.addEdge("I", "J");
		
		boolean cycleExists = cycleExists(graph);
		System.out.println("Cycle Exists : " + cycleExists);
	}

}
