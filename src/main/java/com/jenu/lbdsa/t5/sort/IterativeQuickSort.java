package com.jenu.lbdsa.t5.sort;

import java.util.Arrays;
import java.util.Stack;

/*
 
 Iterative QuickSort
 -------------------
 
 Similar to the more common recursive implementation. Just that we don't have a recurive stack to hold on the values of start and pivot.
 Hence we use a stack to hold them as and when we do each round of partition.
 
 Time  : O(nLog(n))
 Space : O(Log(n))
 
 */

public class IterativeQuickSort {

	static void sort(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int pivot = end;
		
		Tuple tuple = new Tuple(start, end);
		Stack<Tuple> stack = new Stack<>();
		stack.push(tuple);
		
		while(!stack.isEmpty()) {
			tuple = stack.pop();
			start = tuple.start;
			end = tuple.end;
			pivot = end;
			if(start < pivot) {
				pivot = partition(arr, start, pivot);
				stack.push(new Tuple(start, pivot-1));
				stack.push(new Tuple(pivot+1, end));
			}
		}
	}

	static int partition(int[] arr, int start, int pivot) {
		int pivotValue = arr[pivot];
		int i = start-1;
		for(int j=start; j<=pivot; j++) {
			if(arr[j]<pivotValue) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, i, pivot);
		
		return i;
	}
	
	static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 4, 3 };
		System.out.println("UnSorted Array : " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
	
	static class Tuple {
		int start;
		int end;
		
		public Tuple(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
}
