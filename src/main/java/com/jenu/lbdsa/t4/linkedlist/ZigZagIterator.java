package com.jenu.lbdsa.t4.linkedlist;

import com.jenu.lbdsa.t4.linkedlist.MyLinkedList.Node;

public class ZigZagIterator {
	
	private Node vector1;
	private Node vector2;
	
	private boolean currentV1;
	private Node current;
	private Node v1Node;
	private Node v2Node;
	
	public ZigZagIterator(Node v1, Node v2) {
		this.vector1 = v1;
		this.vector2 = v2;
		this.currentV1 = true;
		this.current = vector1;
		this.v1Node = vector1;
		this.v2Node = vector2;
	}
	
	public boolean hasNext() {
		return current != null;
	}
	
	public Node next() {
		if(current == null) {
			return null;
		}
		
		Node tobeReturned = current;
		if(currentV1) {
			v1Node = v1Node.getNext();
			if(v2Node != null) {
				currentV1 = !currentV1;
				current = v2Node;
			} else {
				current = v1Node;
			}
		} else {
			v2Node = v2Node.getNext();
			if(v1Node != null) {
				currentV1 = !currentV1;
				current = v1Node;
			} else {
				current = v2Node;
			}
		}
		
		return tobeReturned;
	}
	
	public void reset() {
		this.currentV1 = true;
		this.current = vector1;
		this.v1Node = vector1;
		this.v2Node = vector2;
	}
	
	public static void main(String[] args) {
		MyLinkedList vector1 = new MyLinkedList();
		vector1.insertAtEnd(1);
		vector1.insertAtEnd(3);
		vector1.insertAtEnd(5);
		
		MyLinkedList vector2 = new MyLinkedList();
		vector2.insertAtEnd(2);
		vector2.insertAtEnd(4);
		vector2.insertAtEnd(6);
		vector2.insertAtEnd(7);
		vector2.insertAtEnd(8);
		
		ZigZagIterator iterator = new ZigZagIterator(vector1.getHead(), vector2.getHead());
		System.out.print("Data : [\t");
		while(iterator.hasNext()) {
			System.out.print(iterator.next().getData() + "\t");
		}
		System.out.println("]");
		
		ZigZagIterator iterator2 = new ZigZagIterator(vector2.getHead(), vector1.getHead());
		System.out.print("Data : [\t");
		while(iterator2.hasNext()) {
			System.out.print(iterator2.next().getData() + "\t");
		}
		System.out.println("]");
		
		System.out.println("Resetting Iterator 1");
		iterator.reset();
		System.out.print("Data : [\t");
		while(iterator.hasNext()) {
			System.out.print(iterator.next().getData() + "\t");
		}
		System.out.println("]");
	}

}
