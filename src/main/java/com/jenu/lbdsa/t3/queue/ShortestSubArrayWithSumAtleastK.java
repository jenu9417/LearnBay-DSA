package com.jenu.lbdsa.t3.queue;

public class ShortestSubArrayWithSumAtleastK {

	static int shortestSubArrayWithSumK(int arr[], int k) {
		int length = arr.length;
		int min_len = length + 1;

		for (int start = 0; start < length; start++) {
			int curr_sum = arr[start];
			if (curr_sum > k) {
				return 1;
			}
			for (int end = start + 1; end < length; end++) {
				curr_sum += arr[end];
				if (curr_sum > k && (end - start + 1) < min_len) {
					min_len = (end - start + 1);
				}
			}
		}
		
		return min_len;
	}
	
	public static void main(String[] args) {
		int arr[] = { 1, 4, 45, 6, 10, 19 };
		int k = 51;
		int len = shortestSubArrayWithSumK(arr, k);
		System.out.println("Shortest SubArray Length : " + len);
	}

}
