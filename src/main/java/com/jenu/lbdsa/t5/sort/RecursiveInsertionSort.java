package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;

/*

Insertion Sort
--------------

Insertion sort is a inplace, stable comparision based sorting. The idea is to take an element from the unsorted right and
inserting it into its correct place in the sorted left side, effectively shifting all the elements between new and old
position.

Inplace
Stable

Time  : O(n^2)
Space : O(1)

*/

public class RecursiveInsertionSort {

	static void sort(int[] arr) {
		sortRecursive(arr, 1, 1, arr[1]);
	}

	static void sortRecursive(int[] arr, int i, int j, int num) {
		if (i >= arr.length) {
			return;
		}
		
		if(j-1 >= 0 && arr[j-1] > num) {
			arr[j] = arr[j-1];
			sortRecursive(arr, i, j-1, num);
		} else {
			arr[j] = num;
			if(i+1 < arr.length) {
				sortRecursive(arr, i+1, i+1, arr[i+1]);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 4, 3 };
		System.out.println("UnSorted Array : " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
	
}
