package com.jenu.lbdsa.week1.warmup1;

/*

Question : Minimum Sum Sub Array of size given size K
Input : 10, 4, 3, 5 , 6, 3, 8 , 1
Output : Index 1 to 3 with Sum as 12

*/

public class MinimumSumSubArray {
	
	static int[] minimumSubArray(int[] arr, int k) {
		if(k > arr.length) {
			return null;
		}
		
		int sum = 0;
		int minSum = Integer.MAX_VALUE;
		int m = 0, n = 0;
		int minM = 0, minN = 0;
		
		for(int i=0; i<k; i++) {
			sum += arr[i];
			n++;
		}
		
		if(sum < minSum) {
			minSum = sum;
			minM = m;
			minN = n;
		}
		
		for( ; n<arr.length; m++, n++) {
			sum = sum - arr[m] + arr[n];
			if(sum < minSum) {
				minSum = sum;
				minM = m+1;
				minN = n;
			}
		}
		
		int[] result = new int[3];
		result[0] = sum;
		result[1] = minM;
		result[2] = minN;
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = { 10, 4, 3, 5 , 6, 3, 8 , 1 };
		int[] result = minimumSubArray(arr, 3);
		System.out.printf("Sum: %d, Index Start: %d, Index End: %d", result[0], result[1], result[2]);
	}

}
