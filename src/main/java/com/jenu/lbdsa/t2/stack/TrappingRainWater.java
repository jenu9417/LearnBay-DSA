package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

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

3 Approaches:

a) Find the LeftMax Array (Array containing the highest left element yet for each position) and RightMax Array.
   Water = Min(LeftMax,RightMax)-Height[i]
b) The same above approach, instead of using arrays, we will use head and tail recursion to find the LeftMax and RightMax.
c) Create a stack and maintain elements in non-decreasing order.


Time  : O(n)
Space  : O(n)

*/

public class TrappingRainWater {
	
	static int rainwaterTrapped(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int totalWater = 0;
		int maxTillNow = 0;
		for(int i=0;i<height.length;i++) {
			if(stack.isEmpty() || height[i] < height[stack.peek()]) {
				stack.push(i);
				maxTillNow = Math.max(maxTillNow, height[i]);
				continue;
			}
			
			while(!stack.isEmpty() && height[i] >= height[stack.peek()]) {
				int rightBound = height[i];
				int current = height[stack.pop()];
				int leftBound = maxTillNow;
				totalWater += Math.min(leftBound, rightBound) - current;
			}
			
			stack.push(i);
			maxTillNow = Math.max(maxTillNow, height[i]);
		}
		
		return totalWater;
	}
	
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 9, 8, 2, 6 };
		int water = rainwaterTrapped(height);
		System.out.println("Rain Water Trapped : " + water);
	}

}
