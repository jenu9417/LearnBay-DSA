package com.jenu.lbdsa.t1.matrix;

/*

TrappingRainWater:
------------------

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Explanation:
------------
When plotted as histogram, the area between the bars [1,0,2] [2,1,0,1,3] and [2,1,2] will hold water.


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

Now from the area matrix, find the sum of zero's between non-zero numbers.


Time  : O(n^2)
Space  : O(n^2)

*/

public class TrappingRainWater {
	
	static int rainwaterTrapped(int[] height) {
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
				} else {
					areaMatrix[i][j] = 0;
				}
			}
		}
		
		int totalWater = 0;
		for(int i=0; i<maxElement; i++) {
			int water = 0;
			boolean started = false;
			for(int j=0; j<height.length; j++) {
				if(areaMatrix[i][j] != 0) {
					if(started) {
						totalWater += water;
						water=0;
					} else {
						started=true;
					}
				} else {
					if(started) {
						water+=1;
					}
				}
			}
		}
		
		return totalWater;
	}
	
	public static void main(String[] args) {
		//int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 9, 8, 2, 6 };
		int water = rainwaterTrapped(height);
		System.out.println("Rain Water Trapped : " + water);
	}

}
