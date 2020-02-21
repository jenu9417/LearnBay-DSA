package com.jenu.lbdsa.t5.sort;

import com.jenu.lbdsa.t4.linkedlist.MyLinkedList;
import com.jenu.lbdsa.t4.linkedlist.MyLinkedList.Node;

/*

SortLinkedListWithZeroOneTwo
----------------------------

This is a special case of sorting. Here we alread know what is the range of the possible values.
Hence we create an array and store a chain of these values separately and finally link them together.

Counting sort is also possible, if there is no differentiation between object.

Time  : O(n) + O(m^2) , m is the range of keys
Space : O(n)

*/

public class SortLinkedListWithZeroOneTwo {
	
	static Node sort(Node head, int count) {
		Node node = head;
		
		Node[] headArray = new Node[count];
		Node[] endArray = new Node[count];
		
		Node nodeToStore = null;
		
		while(node != null) {
			nodeToStore = node;
			node = node.getNext();
			
			int index = nodeToStore.getData().intValue();
			nodeToStore.setNext(null);
			if(index >= count) {
				continue;
			}
			
			if(headArray[index] == null) {
				headArray[index] = nodeToStore;
			} else {
				endArray[index].setNext(nodeToStore);
			}
			endArray[index] = nodeToStore;
		}
		
		
		int i = count-1;
		Node headToReturn = headArray[i]; 
		while(i >= 0) {
			if(headArray[i] != null) {
				headToReturn = headArray[i];
				int j = i-1;
				while(j >= 1 && endArray[j] == null) {
					j--;
				}
				if(j >= 0 && endArray[j] != null) {
					endArray[j].setNext(headArray[i]);
				}
			}
			i--;
		}
		
		return headToReturn;
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(0);
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(0);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		
		Node head = sort(linkedList.getHead(), 8);
		linkedList.setHead(head);
		
		linkedList.print();
		
	}

}
