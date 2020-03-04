package com.jenu.lbdsa.t6.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * IterativeTraversalUsingSingleStack
 * ----------------------------------
 * 
 * Usually we do tree traversal - PreOrder, InOrder, PostOrder traversals using recursion, which magically reduces the code to few lines
 * and is also highly readable.
 * 
 * This attempt is to do the same using iteration instead of recursion.
 * This happens to be the best example of how recursion efficiently removes the complexities of iterative approach.
 * 
 * We are allowed to use a single stack.
 * 
 * Approach:
 * ---------
 * InOrder := Keep a stack and push the elements as they encounter. Move to left if exists. If not, print, pick from stack and move to right.
 * 
 * PreOrder := Print. Keep a stack and push the elements as they encounter. Move to left if exists. If not, pick from stack and move to right.
 * 
 * PostOrder := Keep a stack and push the elements as they encounter. Move to left if exists. If not, pick from stack and move to right.Print.
 *              While reverting back, check if the previous element was the right of current element to avoid infinite loop.
 *              
 * Time  :
 * -------
 * O(N) - Slightly greater than O(N), since we keep retreat back.
 * 
 * Space :
 * -------
 * O(logN) - Since at any point we will only store atmax 1 path of the tree from root to leaf which is equal to logN.
 * 
 * @author Janardhanan V S
 *
 */
public class IterativeTraversalUsingSingleStack {
	
	static List<Integer> preOrderTraversal(BinarySearchTree btree) {
		final List<Integer> inorderList = new ArrayList<>();
		final Stack<Node> stack = new Stack<>();
		Node node = btree.getRoot();
		
		while(node != null) {
			inorderList.add(node.data);
			stack.add(node);
			if(node.hasLeft()) {
				node = node.left;
				continue;
			}
			
			node = null;
			
			while(!stack.isEmpty()) {
				final Node root = stack.pop();
				if(root.hasRight()) {
					node = root.right;
					break;
				}
			}
		}
		
		return inorderList;
	}
	
	static List<Integer> inOrderTraversal(BinarySearchTree btree) {
		final List<Integer> inorderList = new ArrayList<>();
		final Stack<Node> stack = new Stack<>();
		Node node = btree.getRoot();
		
		while(node != null) {
			stack.add(node);
			if(node.hasLeft()) {
				node = node.left;
				continue;
			}
			
			node = null;
			
			while(!stack.isEmpty()) {
				final Node root = stack.pop();
				inorderList.add(root.data);
				if(root.hasRight()) {
					node = root.right;
					break;
				}
			}
		}
		
		return inorderList;
	}
	
	static List<Integer> postOrderTraversal(BinarySearchTree btree) {
		final List<Integer> inorderList = new ArrayList<>();
		final Stack<Node> stack = new Stack<>();
		
		Node node = btree.getRoot();
		Node prevNode = null;
		
		while(node != null) {
			stack.add(node);
			if(node.hasLeft()) {
				prevNode = node;
				node = node.left;
				continue;
			}
		
			node = null;
			
			while(!stack.isEmpty()) {
				final Node root = stack.peek();
				if(root.hasRight() && root.right != prevNode) {
					node = root.right;
					break;
				}
				stack.pop();
				prevNode = root;
				inorderList.add(root.data);
			}
		}
		
		return inorderList;
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
		
		final List<Integer> preOrderList = preOrderTraversal(btree);
		System.out.println("PreOrder Traversal  : " + String.join(" -> ", preOrderList.stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
		
		final List<Integer> inOrderList = inOrderTraversal(btree);
		System.out.println("InOrder Traversal   : " + String.join(" -> ", inOrderList.stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
		
		final List<Integer> postOrderList = postOrderTraversal(btree);
		System.out.println("PostOrder Traversal : " + String.join(" -> ", postOrderList.stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
	}

}
