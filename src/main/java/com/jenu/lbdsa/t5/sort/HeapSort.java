package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;

import com.jenu.lbdsa.t5.heap.Heap;

/**
 *
 * +-----------+
 * | Heap Sort |
 * +-----------+
 * 
 * Heap sort is a sorting algorithm which makes use of the Heap DataStructure.
 * The basic idea is to form a heap and then pick out the smallest / largest
 * from the heap continuously until the heap is empty.
 * 
 * Heap sort is not Inplace, as it requires extra space to create heap.
 * Heap sort is not stable as well.
 * 
 * Time  : O(logN)
 * Space : O(N)
 *
 *
 * @author Janardhanan V S
 *
 */
public class HeapSort {
	
	private static int[] sort(int[] arr, boolean sortAscending) {
		final Heap heap = new Heap(arr.length, sortAscending);
		heap.addAll(arr);
		heap.print();
		
		final int[] sortedArr = new int[arr.length];
		int i = 0;
		
		while(!heap.isEmpty()) {
			System.out.println("Element : " + heap.peek());
			sortedArr[i++] = heap.poll();
			heap.print();
		}
		
		return sortedArr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 4, 3 };
		System.out.println("UnSorted Array : " + Arrays.toString(arr));
		int[] sortedArr = sort(arr, true);
		System.out.println("\nSorted Array : " + Arrays.toString(sortedArr));
	}

}
