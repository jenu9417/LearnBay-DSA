package com.jenu.lbdsa.t1.matrix;

/*

LargestRectangleArea:
---------------------

Given n non-negative integers representing the histogram's bar height where the width of 
each bar is 1, find the area of largest rectangle in the histogram.

Input: [2,1,5,6,2,3]
Output: 10

Explanation:
------------
When plotted as histogram, the area between the bars 5,6 will constitute the maximum area.


Approach:
---------
Create an area matrix, such that

a[i][j] = a[i-1][j] + 1     ;   i != 0
a[i][j] = 1     			;   i == 0

for heights [ 1, 3, 2 ]

area matrix:

[ 0  3  0 ]
[ 0  2  2 ]
[ 1  1  1 ]

Now from the area matrix, find the consecutive non-zero sum.


Time  : O(n^2)
Space  : O(n^2)

*/

public class LargestRectangleAreaInHistogram {
	
	static int largestRectangleArea(int[] height) {
		int maxElement = 0;
		for(int i=0; i<height.length; i++) {
			if(height[i] > maxElement) {
				maxElement = height[i];
			}
		}
		
		int[][] areaMatrix = new int[maxElement][height.length];
		for(int i=0; i<maxElement; i++) {
			for(int j=0; j<height.length; j++) {
				if(i==0) {
					if(height[j] != 0) {
						areaMatrix[i][j] = 1;
					} else {
						areaMatrix[i][j] = 0;
					}
					continue;
				}
				if(height[j]>i) {
					areaMatrix[i][j] = areaMatrix[i-1][j] + 1;
				}
			}
		}
		
		int maxSum = 0;
		for(int i=0; i<maxElement; i++) {
			int sum = 0;
			for(int j=0; j<height.length; j++) {
				if(areaMatrix[i][j] != 0) {
					sum += areaMatrix[i][j];
					if(sum > maxSum) {
						maxSum = sum;
					}
				} else {
					sum = 0;
				}
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] height = { 2, 1, 5, 6, 2, 3 };
		int area = largestRectangleArea(height);
		System.out.println("Largest Rectangle Area : " + area);
	}

}
