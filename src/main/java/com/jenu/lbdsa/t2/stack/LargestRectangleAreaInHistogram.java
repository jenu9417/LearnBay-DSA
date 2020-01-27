package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

LargestRectangleAreaInHistogram
-------------------------------

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Input: [2,1,5,6,2,3]
Output: 10

Approach:
---------

The basic approach is to create a stack of elements with the histogram bar in the non-decreasing order.
And then find the max area constituted in the bounded area.

Time  : O(n)
Space : O(n)

*/

public class LargestRectangleAreaInHistogram {
	
	static int largestAreaInHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int maxArea = 0;
		while(i<heights.length) {
			if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i++);
			} else {
				Integer top = heights[stack.pop()];
				int lowerBound = stack.isEmpty() ? -1 : stack.peek();
				int area = top * (i-1-lowerBound);
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while(!stack.isEmpty()) {
			Integer top = heights[stack.pop()];
			int lowerBound = stack.isEmpty() ? -1 : stack.peek();
			int area = top * (i-1-lowerBound);
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] heights = { 2, 1, 3, 6, 4, 5, 3, 4 };
		int area = largestAreaInHistogram(heights);
		System.out.println("Largest Rectangle Area : " + area);
	}

}
