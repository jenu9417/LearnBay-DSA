package com.jenu.lbdsa.t4.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLinkedList {
	
	private Node head;
	
	private int size;
	
	public Node getHead() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtBegining(int data) {
		if(head == null) {
			head = new Node(data, null);
		} else {
			Node node = new Node(data, head);
			head = node;
		}
		size++;
	}
	
	public void insertAtEnd(int data) {
		if(head == null) {
			head = new Node(data, null);
		} else {
			Node currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			Node node = new Node(data, null);
			currentNode.setNext(node);
		}
		size++;
	}
	
	public Node searchByValue(int data) {
		Node currentNode = head;
		while(currentNode != null && !currentNode.getData().equals(data)) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
	
	public Node searchByIndex(int index) {
		Node currentNode = head;
		int i = 0;
		while(currentNode != null && i++ != index) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
	
	public Node deleteByValue(int data) {
		if(head == null || head.getData().equals(data)) {
			Node deleteNode = head;
			head = null;
			size = 0;
			return deleteNode;
		}
		
		Node currentNode = head;
		while(currentNode.getNext() != null) {
			if(currentNode.getNext().getData().equals(data)) {
				Node nodeToDelete = currentNode.getNext();
				currentNode.setNext(nodeToDelete.getNext());
				size--;
				return nodeToDelete;
			}
			currentNode = currentNode.getNext();
		}
		
		return null;
	}
	
	public Node deleteByIndex(int index) {
		if(head == null || index == 0) {
			Node deleteNode = head;
			head = null;
			size = 0;
			return deleteNode;
		}

		Node currentNode = head;
		int i = 1;
		while(currentNode.getNext() != null) {
			if(i==index) {
				Node nodeToDelete = currentNode.getNext();
				currentNode.setNext(nodeToDelete.getNext());
				size--;
				return nodeToDelete;
			}
			currentNode = currentNode.getNext();
		}
		
		return null;
	}
	
	public void sort() {
		if(head == null || head.getNext() == null) {
			return;
		}
		
		List<Integer> dataList = new ArrayList<>();
		Node currentNode = head;
		while(currentNode != null) {
			dataList.add(currentNode.getData());
			currentNode = currentNode.getNext();
		}
		
		Collections.sort(dataList);
		
		currentNode = head;
		for(Integer data : dataList) {
			currentNode.setData(data);
			currentNode = currentNode.getNext();
		}
	}
	
	public Node reverseUsingRecursion(Node node) {
		if(node == null || node.getNext() == null) {
			this.head = node;
			return node;
		}
		Node currentNode = node;
		Node nextNode = node.getNext();
		
		Node head = reverseUsingRecursion(nextNode);
		
		nextNode.setNext(currentNode);
		currentNode.setNext(null);
		
		return head;
	}
	
	public Node reverseUsingIteration(Node node) {
		if(node == null || node.getNext() == null) {
			return node;
		}
		Node currentNode = node;
		Node prevNode = null;
		while(currentNode != null) {
			Node nextNode = currentNode.getNext();
			currentNode.setNext(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		this.head = prevNode;

		return currentNode;
	}

	public void print() {
		Node currentNode = head;
		System.out.print("Linked List [\t");
		while(currentNode != null) {
			System.out.print(currentNode.getData() + "\t");
			currentNode = currentNode.getNext();
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		System.out.println("Inserting values 1 to 6");
		linkedList.insertAtBegining(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtBegining(1);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		
		linkedList.print();
		
		System.out.println("Deleting node with value 5 and node at index 1");
		linkedList.deleteByValue(5);
		linkedList.deleteByIndex(1);
		
		linkedList.print();
		
		System.out.println("Searching for value 4 : " + linkedList.searchByValue(4));
		System.out.println("Searching for value 5 : " + linkedList.searchByValue(5));
		System.out.println("Searching for index 3 : " + linkedList.searchByIndex(3));
		System.out.println("Searching for index 6 : " + linkedList.searchByIndex(6));
		
		System.out.println("Reversing LinkedList Using Recursion");
		linkedList.reverseUsingRecursion(linkedList.getHead());
		linkedList.print();
		
		System.out.println("Reversing LinkedList Using Iteration");
		linkedList.reverseUsingIteration(linkedList.getHead());
		linkedList.print();
		
		System.out.println("LinkedList Current Size : " + linkedList.getSize());
	}

	static class Node {
		Integer data;
		Node next;
		
		Node(Integer data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}	
}

