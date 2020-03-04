package com.jenu.lbdsa.t6.tree;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * 
 * SumOfKSmallestElements
 * ----------------------
 * 
 * In a BST, inorder traversal will be in ascending order. Taking advantage of this, do an inorder traveral
 * till k iterations, while keeping the sum till now.
 * 
 * Time : O(N)
 *
 *
 * @author Janardhanan V S
 *
 */
public class SumOfKSmallestElements {
	
	static int sumOfKElements(BinarySearchTree btree, int k) {
		return recursiveFindSumOfKElements(btree.getRoot(), k, new Tuple(0, 0));
	}
	
	static int recursiveFindSumOfKElements(Node node, int k, Tuple t) {
		if(node != null && t.count < k) {
			t.sum = recursiveFindSumOfKElements(node.left, k, t);
			t.sum+=node.data;
			t.count++;
			t.sum = recursiveFindSumOfKElements(node.right, k, t);
		}

		return t.sum;
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
		
		System.out.println("Sum of 4 smallest elements : " + sumOfKElements(btree, 4));
	}
	
	static class Tuple {
		int sum;
		int count;
		
		Tuple(int sum, int count) {
			this.sum = sum;
			this.count = count;
		}
	}

}
