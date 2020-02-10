package com.jenu.lbdsa.t3.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximumNumber {
	
	static int[] findMaxArray(int[] array, int k) {
		final Deque<Integer> deq = new LinkedList<>();
		final int[] maxArray = new int[array.length-k+1];
		int n = 0;
		for(int i=0; i<array.length; i++) {
			if(deq.isEmpty()) {
				deq.offerFirst(i);
				continue;
			}
			if(i - deq.peekFirst() > 2) {
				deq.pollFirst();
			}
			while(!deq.isEmpty() && array[i] > array[deq.peekLast()]) {
				deq.pollLast();
			}
			deq.offerLast(i);
			if(i >= (k-1)) {
				maxArray[n++] =  array[deq.peekFirst()];
			}
		}
		
		return maxArray;
	}
	
	public static void main(String[] args) {
		int[] array = { 1,3,-1,-3,5,3,6,7 };
		int k = 3;
		int[] maxArray = findMaxArray(array, k);
		System.out.println("Max Array : " + Arrays.toString(maxArray));
	}

}
