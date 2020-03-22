package com.jenu.lbdsa.t9.dp;

/**
 * +---------------------+
 * | Rod Cutting Problem |
 * +---------------------+
 * 
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of 
 * the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 
 * (by cutting in two pieces of lengths 2 and 6) 
 * 
 * length   | 1   2   3   4   5   6   7   8  
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * 
 * 
 * 
 * Time  : O(max(lengths) * number of rods)
 * Space : O(max(lengths) * number of rods)
 * 
 * 
 * @author Janardhanan V S
 *
 */
public class RodCuttingProblem {

	static int maxProfit(int finalLength, int[] length, int[] profit) {
		int[][] profitTable = new int[length.length][finalLength + 1];
		int maxProfit = 0;
		
		for (int i = 0; i < length.length; i++) {
			for (int j = 1; j < finalLength + 1; j++) {
				// First Row
				if (i == 0) {
					// Length less than available rod length
					if (j < length[i]) {
						profitTable[i][j] = 0;
					} else {
						profitTable[i][j] = (j / length[i]) * profit[i];
					}
				} else {
					// Length less than available rod length
					if (j < length[i]) {
						profitTable[i][j] = profitTable[i - 1][j];
					} else {
						int includedValue = profit[i] + profitTable[i - 1][j - length[i]];
						int notIncludedValue = profitTable[i - 1][j];
						profitTable[i][j] = Math.max(includedValue, notIncludedValue);
					}
				}
				maxProfit = Math.max(maxProfit,profitTable[i][j]);
			}
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] profit = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int maxProfit = maxProfit(8, length, profit);
		System.out.println("Max Profit : " + maxProfit);
	}

}
