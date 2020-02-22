package com.jenu.lbdsa.t1.array;

/*
 
 LargestSumContiguousSubArray
 ----------------------------
 
 Sliding window problem. Kadane's algorithm.
 The approach is to keep track of sum till now and maxsum.
 When sum till now goes below, reset.
 
 Time  : O(n)
 Space : O(n)

*/

public class LargestSumContiguousSubArray {

	static int largestSum(int[] array) {
		int sumTillNow = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int n : array) {
			if(n + sumTillNow < n) {
				sumTillNow = n;
			} else {
				sumTillNow += n;
			}
			
			if(maxSum < sumTillNow) {
				maxSum = sumTillNow;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] array = { 2, 0, -2, 4, -1, 5, 0 };
		int sum = largestSum(array);
		System.out.println("Largest Sum : " + sum);
	}
	
}
