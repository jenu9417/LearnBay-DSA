package com.jenu.lbdsa.t8.graph;

import com.jenu.lbdsa.t8.graph.impl.DirectedGraph;
import com.jenu.lbdsa.t8.graph.impl.Graph;
import com.jenu.lbdsa.t8.graph.impl.UnDirectedGraph;
import com.jenu.lbdsa.t8.graph.impl.WeightedGraph;

/**
 * GraphImplementations
 * 
 * @author Janardhanan V S
 *
 */
public class GraphImplementations {
	
	public static void directedWeightedGraph() {
		WeightedGraph wgraph = new DirectedGraph();
		wgraph.addEdge("A", "B", 1);
		wgraph.addEdge("B", "C", 2);
		wgraph.addEdge("C", "D", 3);
		wgraph.addEdge("A", "E", 4);
		wgraph.addEdge("E", "F", 5);
		wgraph.addEdge("B", "G", 6);
		wgraph.addEdge("G", "H", 7);
		wgraph.addEdge("C", "I", 8);
		wgraph.addEdge("I", "J", 9);
		
		System.out.println("Breadth First Search :");
		System.out.println("----------------------");
		System.out.println(String.join(" -> ", wgraph.breadthFirstSearch("A")));
		System.out.println("\n");
		
		System.out.println("Depth First Search :");
		System.out.println("--------------------");
		System.out.println(String.join(" -> ", wgraph.depthFirstSearch("A")));
		System.out.println("\n");
	}
	
	public static void directedUnWeightedGraph() {
		Graph graph = new DirectedGraph();
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("A", "E");
		graph.addEdge("E", "F");
		graph.addEdge("B", "G");
		graph.addEdge("G", "H");
		graph.addEdge("C", "I");
		graph.addEdge("I", "J");
		
		System.out.println("Breadth First Search :");
		System.out.println("----------------------");
		System.out.println(String.join(" -> ", graph.breadthFirstSearch("A")));
		System.out.println("\n");
		
		System.out.println("Depth First Search :");
		System.out.println("--------------------");
		System.out.println(String.join(" -> ", graph.depthFirstSearch("A")));
		System.out.println("\n");
	}
	
	public static void unDirectedWeightedGraph() {
		WeightedGraph wgraph = new UnDirectedGraph();
		wgraph.addEdge("A", "B", 1);
		wgraph.addEdge("B", "C", 2);
		wgraph.addEdge("C", "D", 3);
		wgraph.addEdge("A", "E", 4);
		wgraph.addEdge("E", "F", 5);
		wgraph.addEdge("B", "G", 6);
		wgraph.addEdge("G", "H", 7);
		wgraph.addEdge("C", "I", 8);
		wgraph.addEdge("I", "J", 9);
		
		System.out.println("Breadth First Search :");
		System.out.println("----------------------");
		System.out.println(String.join(" -> ", wgraph.breadthFirstSearch("A")));
		System.out.println("\n");
		
		System.out.println("Depth First Search :");
		System.out.println("--------------------");
		System.out.println(String.join(" -> ", wgraph.depthFirstSearch("A")));
		System.out.println("\n");
	}
	
	public static void unDirectedUnWeightedGraph() {
		Graph graph = new UnDirectedGraph();
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("A", "E");
		graph.addEdge("E", "F");
		graph.addEdge("B", "G");
		graph.addEdge("G", "H");
		graph.addEdge("C", "I");
		graph.addEdge("I", "J");
		
		System.out.println("Breadth First Search :");
		System.out.println("----------------------");
		System.out.println(String.join(" -> ", graph.breadthFirstSearch("A")));
		System.out.println("\n");
		
		System.out.println("Depth First Search :");
		System.out.println("--------------------");
		System.out.println(String.join(" -> ", graph.depthFirstSearch("A")));
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		System.out.println("\n\n############---------- Directed-Weighted Graph ----------############\n");
		directedWeightedGraph();
		
		System.out.println("\n\n############---------- Directed-UnWeighted Graph ----------############\n");
		directedUnWeightedGraph();
		
		System.out.println("\n\n############---------- UnDirected-Weighted Graph ----------############\n");
		unDirectedWeightedGraph();
		
		System.out.println("\n\n############---------- UnDirected-UnWeighted Graph ----------############\n");
		unDirectedUnWeightedGraph();

	}

}
