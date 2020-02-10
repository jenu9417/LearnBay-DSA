package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;

/*

Bubble Sort:
------------

Bubble sort is a inplace, stable comparision based sorting. The idea is to swap adjacent elements, if the next
element is greater than current and hence moving the largest element available to the end of the array.
This is similiar to a bubble rising up in jar.

Inplace
Stable

Time  : O(n^2)
Space : O(1)

*/

public class RecursiveBubbleSort {
	
	static void sort(int[] arr) {
		sortRecursive(arr, arr.length-1, 0);
	}

	static void sortRecursive(int[] arr, int i, int j) {
		if (i < 1) {
			return;
		}

		if (j >= i) {
			sortRecursive(arr, i-1, 0);
			return;
		} 
			
		if(arr[j] > arr[j+1]) {
			swap(arr, j, j+1);
		}
		
		sortRecursive(arr, i, j+1);
	}
	
	static void swap(int[] arr, int src, int dst) {
		int tmp = arr[src];
		arr[src] = arr[dst];
		arr[dst] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 4, 3 };
		System.out.println("UnSorted Array : " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
}
