package com.jenu.lbdsa.t5.sort;

import com.jenu.lbdsa.t4.linkedlist.MyLinkedList;
import com.jenu.lbdsa.t4.linkedlist.MyLinkedList.Node;

/**
 * 
 * MergeSort
 * ---------
 * 
 * Time  : O(NLogN)
 *
 * @author Janardhanan V S
 *
 */
public class MergeSortLinkedList {

	static Node mergeSort(Node head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		Node mid = findMid(head);
		Node nextToMid = mid.getNext();
		mid.setNext(null);
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextToMid);
		
		return merge(left, right);
	}
	
	static Node merge(Node left, Node right) {
		Node result = null;
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		
		if(left.getData() < right.getData()) {
			result = left;
			result.setNext(merge(result.getNext(), right));
		} else {
			result = right;
			result.setNext(merge(left, right.getNext()));
		}
		return result;
	}
	
	static Node findMid(Node head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.getNext();
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(6);
		
		Node result = mergeSort(linkedList.getHead());
		linkedList.setHead(result);
		linkedList.print();
	}
}