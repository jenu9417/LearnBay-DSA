package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;

/*

Shift all the zeros in a array to right end.

Input  : [ 0, 1, 2, 0, 0, 3, 0 ]
Output : [ 1, 2, 3, 0, 0, 0, 0 ]

Approach:
---------

a) BruteForce
Tweak the insertion sort to pick zero and move it to the last available slot, shifting all the elements
in between.

Time  : O(n^2)
Space : O(1)

b) Optimized
Here we only need to move the zeros to the last and we are not really concerned with the relative order
among zeros. Hence we can complete this in onepass itself. Iterate the array from left to right. While doing
so, keep track of the earliest index of zero. Whenever a non-zero is found, swap with earliest index of zero.

Time  : O(n)
Space : O(1)

*/

public class MoveAllZerosToEnd {
	
	static void moveAllZerosToEnd(int[] arr) {
		int earliestZero = -1;
		for(int i=0; i < arr.length-1; i++) {
			if(arr[i] == 0) {
				earliestZero = (earliestZero == -1) ? i : Math.min(earliestZero, i);
			} else if (earliestZero != -1) {
				swap(arr, i, earliestZero);
				earliestZero = -1;
			}
		}
	}
	
	static void moveAllZerosToEndBruteForce(int[] arr) {
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] == 0) {
				int j = i;
				while(j+1 < arr.length-1 && arr[j+1] != 0) {
					arr[j] = arr[j+1];
					j++;
				}
				arr[j] = 0;
			}	
		}
	}
	
	static void swap(int[] arr, int src, int dst) {
		int tmp = arr[src];
		arr[src] = arr[dst];
		arr[dst] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 0, 3, 0 };
		System.out.println("Before Moving : " + Arrays.toString(arr));
		moveAllZerosToEnd(arr);
		System.out.println("After Moving : " + Arrays.toString(arr));
	}

}
