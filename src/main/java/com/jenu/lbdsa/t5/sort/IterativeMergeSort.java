package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;

/*

Iterative MergeSort:
--------------------

This is a little complex implementation of merge sort.

Approach:
---------

First sort all 2 elements.

Then sort all 4 elements. Then 8.. and so.

Finally, if anything is left over merge it with the previous array.

*/
public class IterativeMergeSort {

	static void sort(int[] arr) {
		int i = 0;
		for(i=1; i< arr.length; i*=2) {
			for(int j=0; j<arr.length; j+= 2*i) {
				int low = j;
				int high = ((j + 2*i) < arr.length)  ? (j + 2*i) : arr.length;
				int mid = (low + high) / 2;
				merge(arr, low, mid, high);
			}
		}
		if(i/2 != arr.length) {
			merge(arr, 0, i/2, arr.length);
		}
	}
	
	static void merge(int[] arr, int low, int mid, int high) {
		int[] tmpArr = new int[high-low];
		
		int i = low;
		int j = mid;
		int k = 0;
		
		while(i < mid && j < high) {
			if(arr[i] <= arr[j]) {
				tmpArr[k++] = arr[i++];
			} else {
				tmpArr[k++] = arr[j++];
			}
		}
		
		while(i < mid) {
			tmpArr[k++] = arr[i++];
		}
		
		while(j < high) {
			tmpArr[k++] = arr[j++];
		}
		
		int m = 0;
		int n = low;
		while(m < k) {
			arr[n++] = tmpArr[m++];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 4, 3 };
		System.out.println("UnSorted Array : " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
	
}
