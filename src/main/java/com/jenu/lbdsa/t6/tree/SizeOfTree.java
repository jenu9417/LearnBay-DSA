package com.jenu.lbdsa.t6.tree;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * 
 * SizeOfTree
 * ----------
 * 
 * Find the number of elements in the tree. Do a DFS and keep track of a counter.
 * 
 * Time  : O(N)
 *
 * @author Janardhanan V S
 *
 */
public class SizeOfTree {
	
	static int sizeOfTree(BinarySearchTree btree) {
		return recursiveFindSize(btree.getRoot(), 0);
	}
	
	static int recursiveFindSize(Node node, int size) {
		if(node != null) {
			size = recursiveFindSize(node.left, size);
			size++;
			size = recursiveFindSize(node.right, size);
		}

		return size;
	}
	
	public static void main(String[] args) {
		BinarySearchTree btree = new BinarySearchTree();
		btree.insert(4);
		btree.insert(2);
		btree.insert(1);
		btree.insert(3);
		btree.insert(6);
		btree.insert(5);
		btree.insert(7);
		
		System.out.println("Size of tree : " + sizeOfTree(btree));
	}

}
