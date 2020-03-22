package com.jenu.lbdsa.t5.sort;

import com.jenu.lbdsa.t4.linkedlist.MyLinkedList;
import com.jenu.lbdsa.t4.linkedlist.MyLinkedList.Node;

/**
 * 
 * Quick Sort 
 * ----------
 * 
 * Time : O(NLogN)
 *
 * @author Janardhanan V S
 *
 */
public class QuickSortLinkedList {
	
	static void quickSort(Node start, Node end) { 

		if(start == end ) 
	        return; 
	          
	    // split list and partion recurse 
	    Node pivot_prev = paritionLast(start, end); 
	    quickSort(start, pivot_prev); 
	      
	    // if pivot is picked and moved to the start, 
	    // that means start and pivot is same  
	    // so pick from next of pivot 
	    if( pivot_prev != null &&  
	        pivot_prev == start ) 
	    	quickSort(pivot_prev.getNext(), end); 
	          
	    // if pivot is in between of the list, 
	    // start from next of pivot,  
	    // since we have pivot_prev, so we move two nodes 
	    else if(pivot_prev != null &&  
	            pivot_prev.getNext() != null) 
	    	quickSort(pivot_prev.getNext().getNext(), end); 
	} 


	// takes first and last node, 
	// but do not break any links in  
	// the whole linked list 
	static Node paritionLast(Node start, Node end) { 

		if(start == end ||  
	       start == null || end == null) 
	        return start; 
	  
	    Node pivot_prev = start; 
	    Node curr = start;  
	    int pivot = end.getData();  
	      
	    // iterate till one before the end,  
	    // no need to iterate till the end  
	    // because end is pivot 
	    while(start != end ) 
	    { 
	        if(start.getData() < pivot) 
	        {  
	            // keep tracks of last modified item 
	            pivot_prev = curr;  
	            int temp = curr.getData();  
	            curr.setData(start.getData());  
	            start.setData(temp);  
	            curr = curr.getNext();  
	        } 
	        start = start.getNext();  
	    } 
	      
	    // swap the position of curr i.e. 
	    // next suitable index and pivot 
	    int temp = curr.getData();  
	    curr.setData(pivot);  
	    end.setData(temp);  
	  
	    // return one previous to current 
	    // because current is now pointing to pivot 
	    return pivot_prev; 
	} 
	  
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(6);
		
		Node first = linkedList.getHead();
	    Node last = linkedList.getHead(); 
	    while(last.getNext() != null) 
	        last= last.getNext(); 

		quickSort(first, last);
		linkedList.print();
	}
}
