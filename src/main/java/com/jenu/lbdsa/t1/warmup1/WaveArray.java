package com.jenu.lbdsa.t1.warmup1;

import java.util.Arrays;

/*

Wave Array:
-----------
An array is said to be wave array if a[0] >= a[1] <= a[2] >= a[3]
ie, peak, valley, peak, valley

eg: 1, 2, 3, 4, 5, 6  =>  2, 1, 4, 3, 6, 5



2 Approaches:
-------------
a) Sort the array and swap adjacent numbers  -  O(nlogn)

b) Parse the even index numbers and swap     -  O(n)
	i) a[i] and a[i+i], if a[i] < a[i+1]
	2) a[i-1] and a[i], if a[i] < a[i-1]

*/

public class WaveArray {
	
	static void waveArray(int[] arr) {
		if(arr.length < 3) {
			if(arr.length < 2) {
				return;
			}
			if(arr[0] < arr[1]) {
				swap(arr, 0, 1);
			}
		}
		for(int i = 0; i < arr.length; i+=2) {
			if(validIndex(i-1, arr) && arr[i] < arr[i-1]) {
				swap(arr, i, i-1);
			}
			if(validIndex(i+1, arr) && arr[i] < arr[i+1]) {
				swap(arr, i, i+1);
			}
		}
	}
	
	static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	static boolean validIndex(int index, int[] arr) {
		return ((index > -1) && (index < arr.length));
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		waveArray(arr);
		System.out.println("Wave Array : " + Arrays.toString(arr));
	}

}
