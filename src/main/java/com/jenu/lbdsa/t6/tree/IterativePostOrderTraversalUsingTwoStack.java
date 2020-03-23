package com.jenu.lbdsa.t6.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 *
 * IterativePostOrderTraversalUsingTwoStack
 * ----------------------------------------
 * 
 * Approach:
 * ---------
 * The idea is to maintain two stacks, one which keeps track of the iteration and the other which keeps track of
 * visited root nodes.
 * 
 * 
 * Time  :
 * -------
 * O(N) - Slightly greater than O(N), since we keep retreat back.
 * 
 * Space :
 * -------
 * O(N) - since we use multiple stacks and a list
 *
 * @author Janardhanan V S
 *
 */
public class IterativePostOrderTraversalUsingTwoStack {
	
	static List<Integer> postOrderTraversal(BinarySearchTree tree) {
		List<Integer> postOrderList = new ArrayList<>();
		Stack<Node> processedStack = new Stack<>();
		Stack<Node> rootStack = new Stack<>();
		rootStack.add(tree.getRoot());
		
		while(!rootStack.isEmpty()) {
			Node node = rootStack.pop();
			processedStack.push(node);
			if(node.hasLeft()) {
				rootStack.add(node.left);
			}
			if(node.hasRight()) {
				rootStack.add(node.right);
			}
		}
		
		while (!processedStack.isEmpty()) {
			postOrderList.add(processedStack.pop().data);
		}
		
		return postOrderList;
	}
	
	public static void main(String[] args) {
		final BinarySearchTree btree = new BinarySearchTree();
		btree.insert(4);
		btree.insert(2);
		btree.insert(1);
		btree.insert(3);
		btree.insert(6);
		btree.insert(5);
		btree.insert(7);
		
		final List<Integer> postOrderList = postOrderTraversal(btree);
		System.out.println("PostOrder Traversal : " + String.join(" -> ", postOrderList.stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
	}

}
