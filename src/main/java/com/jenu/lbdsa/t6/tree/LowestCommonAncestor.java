package com.jenu.lbdsa.t6.tree;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * LowestCommonAncestor
 * --------------------
 * 
 * Lowest Common Ancestor of two nodes is defined as the shared ancestor of 
 * n1 and n2 that is located farthest from the root.
 *
 * We leverage the fact that in a BST, for two nodes to have a common ancestor,
 * either the two nodes will be lesser than the root or both nodes will be greater
 * than the root.
 * 
 * 
 * Time  : LogN
 *
 *
 * @author Janardhanan V S
 *
 */
public class LowestCommonAncestor {

	static Node lowestCommonAncestor(Node root, int n1, int n2) {
		if (root == null) {
			return root;
		}

		if (root.data >= n1 && root.data >= n2) {
			lowestCommonAncestor(root.left, n1, n2);
		}

		if (root.data < n2 && root.data < n2) {
			lowestCommonAncestor(root.right, n1, n2);
		}

		return root;
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
		
		int n1 = 1;
		int n2 = 3;
		Node lca = lowestCommonAncestor(btree.getRoot(), n1, n2);
		System.out.printf("LCA of [ %d ] and [ %d ] is  : [ %d ]", n1, n2, lca.data);
	}
}
