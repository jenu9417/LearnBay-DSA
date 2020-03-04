package com.jenu.lbdsa.t6.tree;

/**
 * 
 * Binary Search Tree
 * ------------------
 * 
 * Binary Search Tree or BST is a very usefull datastructure. Basically it is a binary tree which follows the rule
 * 			"left" < "root" < "right" 
 * Hence it is very easy to search elements in a BST, due to the above rule. A bruteforce approach will take O(N),
 * where as BST reduces this to O(LogN), assuming its balanced binary tree.
 * 
 * Time Complexity:
 * ----------------
 * Insert :  O(LogN)
 * Find   :  O(LogN)
 * Delete :  O(LogN)
 *
 *
 * @author Janardhanan V S
 *
 */
public class BinarySearchTree {

	private Node root;
	
	public Node getRoot() {
		return this.root;
	}
	
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
	
	public void insertIterative(int data, Node current, Node parent) {
		if(root == null) {
			root = new Node(data);
			return;
		}
		
		while(current != null) {
			if(data <= current.data) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		
		if(current == null) {
			if(data <= parent.data) {
				parent.left = new Node(data);
			} else {
				parent.right = new Node(data);
			}
		}
	}
	
	public Node findRecursive(int data, Node current) {
		if(current != null && current.data != data) {
			if(data <= current.data) {
				current = findRecursive(data, current.left);
			} else {
				current = findRecursive(data, current.right);
			}
		}
			
		return current;
	}
	
	public Node findIterative(int data, Node current) {
		while(current != null && current.data != data) {
			if(data <= current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		return current;
	}
	
	public Node findPreviousRecursive(int data, Node current, Node parent) {
		if(current != null && current.data != data) {
			if(data <= current.data) {
				parent = findPreviousRecursive(data, current.left, current);
			} else {
				parent = findPreviousRecursive(data, current.right, current);
			}
		}
			
		return parent;
	}
	
	public boolean deleteIterative(int data) {
		final Node previousNode = findPreviousRecursive(data, this.root, null);
		if(previousNode == null) {
			return false;
		}
		
		if(previousNode.left.data == data) {
			Node node = previousNode.left;
			if(node.hasLeft() && node.hasRight()) {
				Node parent = node.left;
				Node successor = parent.right;
				if(successor == null) {
					previousNode.left = node.left;
				}
				while(successor.hasRight()) {
					parent = successor;
					successor = successor.right;
				}
				parent.right = successor.left;
				previousNode.left = successor;
			} else if(node.hasLeft()) {
				previousNode.left = node.left;
			} else {
				previousNode.left = node.right;
			}
		} else {
			Node node = previousNode.right;
			if(node.hasLeft() && node.hasRight()) {
				Node parent = node.left;
				Node successor = parent.right;
				if(successor == null) {
					previousNode.left = node.left;
				}
				while(successor.hasRight()) {
					parent = successor;
					successor = successor.right;
				}
				parent.right = successor.left;
				previousNode.right = successor;
			} else if(node.hasLeft()) {
				previousNode.right = node.left;
			} else {
				previousNode.right = node.right;
			}
		}
		
		return true;
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
		
		public boolean hasLeft() {
			return (this.left != null);
		}
		
		public boolean hasRight() {
			return (this.right != null);
		}
	}
	
}
