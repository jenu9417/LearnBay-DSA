package com.jenu.lbdsa.t6.tree;

public class BinarySearchTree {

	private Node root;
	
	public void insert(int data) {
		insertRecursive(data, this.root, this.root);
	}
	
	private void insertRecursive(int data, Node current, Node parent) {
		if(root == null) {
			root = new Node(data);
			return;
		}
		
		if(current == null) {
			if(data <= parent.data) {
				parent.left = new Node(data);
			} else {
				parent.right = new Node(data);
			}
		} else {
			if(data <= current.data) {
				insertRecursive(data, current.left, current);
			} else {
				insertRecursive(data, current.right, current);
			}
		}
	}
	
	public void printTree() {
		if(this.root == null) {
			return;
		}
	}
	
	public int height() {
		if(this.root == null) {
			return 0;
		}
		return heightRecursive(this.root);
	}
	
	private int heightRecursive(Node root) {
		if(root == null) {
			return -1;
		}
		
		int left = heightRecursive(root.left);
		int right = heightRecursive(root.right);
		
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		BinarySearchTree btree = new BinarySearchTree();
		System.out.println("Current Height : " + btree.height());
		btree.insert(4);
		btree.insert(2);
		btree.insert(1);
		btree.insert(3);
		btree.insert(6);
		btree.insert(5);
		btree.insert(7);
		
		System.out.println("Current Height : " + btree.height());
	}
	
	static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
}
