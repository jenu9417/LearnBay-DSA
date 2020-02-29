package com.jenu.lbdsa.t5.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * +------+
 * | Heap |
 * +------+
 * 
 * Heap is a famous and very usefull data structure. It is also known as priorityQueue.
 * It is basically used in circumstances where we need to find min or max, with constant
 * time, but also need to support dynamic insert and delete efficiently as well, without
 * extra space.
 * 
 * [Heap has 2 properties]
 * 1) Binary Tree Property -> Heap should be a complete binary tree. ie, all the level except 
 *    the root level should be filled and last level should be filled from left to right.
 *    
 * 2) Min / Max Heap property -> Based on the implementation root element should be smaller / 
 *    larger than it children.
 * 
 * [Heap is of 2 types] : MinHeap and MaxHeap
 * The classification is based on whether the root element is the smaller or larger
 * than its children.
 * 
 * [Heap has mainly 2 operations] : SwimUp and SinkDown
 * SwimUp   ->  Add a node at the last available slot and then move up, till root, to maintain heap property. (Add)
 * SinkDown ->  Add a node at the current slot and then move down till last element, to maintain heap property. (Delete)
 *
 *
 * Time Complexity:
 * ----------------
 * Add      ->  O(logN)
 * Find     ->  O(logN)
 * Delete   ->  O(logN)
 * Find Min ->  O(1)
 * Find Max ->  O(1)
 * 
 * 
 * @author Janardhanan V S
 *
 */
public class Heap {
	
	private int[] heap;
	
	private boolean minHeap;
	
	private int tail;
	
	private Comparator<Integer> comparator;
	
	public Heap(int size, boolean minHeap) {
		this.heap = new int[size];
		this.minHeap = minHeap;
		this.tail = -1;
		if(minHeap) {
			comparator = ascendingComparator();
		} else {
			comparator = descendingComparator();
		}
		Arrays.fill(heap, -1);
	}
	
	public boolean isEmpty() {
		return (tail < 0);
	}
	
	public boolean isFull() {
		return (tail == heap.length);
	}
	
	public boolean isMinHeap() {
		return minHeap;
	}
	
	
	public boolean add(int data) {
		if(isFull()) {
			return false;
		}
		heap[++tail] = data;
		swimUp(tail);
		return true;
	}
	
	public void addAll(int... datas) {
		for(int data : datas) {
			add(data);
		}
	}
	
	public boolean delete(int data) {
		int index = find(data);
		if(index == -1) {
			return false;
		}
		heap[index] = heap[tail];
		heap[tail] = -1;
		tail--;
		sinkDown(index);
		
		return true;
	}
	
	public int find(int data) {
		if(isEmpty()) {
			return -1;
		}
		for(int i=0; i<=tail; i++) {
			if(heap[i]==data) {
				return i;
			}
		}
		return -1;
	}
	
	public int findMin() {
		return (isMinHeap() && !isEmpty()) ? heap[0] : -1;
	}
	
	public int findMax() {
		return (!isMinHeap() && !isEmpty()) ? heap[0] : -1;
	}
	
	public int poll() {
		if(isEmpty()) {
			return -1;
		}
		int element = heap[0];
		delete(element);
		return element;
	}
	
	public int peek() {
		return isEmpty() ? -1 : heap[0];
	}
	
	public void print() {
		System.out.println("--------- Heap ---------\n");
		int i = 0;
		int newLine = 0;
		while(i <= tail) {
			System.out.printf("%d\t", heap[i]);
			if(i == newLine) {
				newLine = (2*i)+2;
				System.out.println();
			}
			i++;
		}
		System.out.println("\n------------------------");
	}
	
	private void swimUp(int index) {
		if(index < 1) {
			return;
		}
		int parent = (index-1) / 2;
		if(comparator.compare(heap[index], heap[parent]) < 0) {
			swap(heap, index, parent);
		}
		swimUp(parent);
	}
	
	private void sinkDown(int index) {
		int leftChild = (2*index) + 1;
		int rightChild = (2*index) + 2;
		
		// If both left and right exist, then swap with min of the two
		if(leftChild <= tail && comparator.compare(heap[index], heap[leftChild]) > 0 && (rightChild > tail || comparator.compare(heap[rightChild], heap[leftChild]) > 0)) {
			swap(heap, index, leftChild);
			sinkDown(leftChild);
			return;
		}
		
		
		if(rightChild <= tail && comparator.compare(heap[index], heap[rightChild]) > 0) {
			swap(heap, index, rightChild);
			sinkDown(rightChild);
			return;
		}
	}
	
	private void swap(int[] arr, int src, int dst) {
		int tmp = arr[src];
		arr[src] = arr[dst];
		arr[dst] = tmp;
	}
	
	private Comparator<Integer> ascendingComparator() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
	}
	
	private Comparator<Integer> descendingComparator() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(10, true);
		heap.add(5);
		heap.add(7);
		heap.add(2);
		heap.add(4);
		heap.add(1);
		heap.add(8);
		heap.add(3);
		heap.add(2);
		
		System.out.println("Add 5, 7, 2, 4, 1, 8, 3, 2");
		heap.print();
		
		System.out.println("\nFind 7");
		int index = heap.find(7);
		System.out.printf("Found : %b, Index : %d\n", (index == -1), index);
		
		System.out.println("\nFind 10");
		index = heap.find(10);
		System.out.printf("Found : %b, Index : %d\n", (index == -1), index);
		
		System.out.println("\nFind Min");
		int min = heap.findMin();
		System.out.printf("Min : %d\n", min);
		
		System.out.println("\nFind Max");
		int max = heap.findMax();
		System.out.printf("Max : %d\n", max);
		
		System.out.println("\nDelete 7");
		boolean deleted = heap.delete(7);
		System.out.printf("Deleted : %b\n", deleted);
		heap.print();
		
		System.out.println("\nDelete 1");
		deleted = heap.delete(1);
		System.out.printf("Deleted : %b\n", deleted);
		heap.print();
		
		System.out.println("\nFind Min");
		min = heap.findMin();
		System.out.printf("Min : %d\n", min);
		
		System.out.println("\nFind Max");
		max = heap.findMax();
		System.out.printf("Max : %d\n", max);
	}

}
