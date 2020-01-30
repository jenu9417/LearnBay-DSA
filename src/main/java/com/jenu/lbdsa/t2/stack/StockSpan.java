package com.jenu.lbdsa.t2.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 
Stock Span
----------

The span of the stock's price today is defined as the maximum number of consecutive days 
(starting from today and going backwards) for which the price of the stock was less than 
or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

2 Approaches:

a) Brute-Force
   For each element in the stock array, parse backwards and find how many consecutive elements 
   are there which are either lesser than or equal to that number.
	Time : O(n)
	
b) Stack-Based
   Basically we will iterate through the array of stocks and we will store the indices of greater elements
   till then in the stack. Hence, if the stack is empty than span is length of elements
   parsed till then. If stack has some elements, then diff in index between current and last greater 
   element.

*/

public class StockSpan {
	
	static int[] stockSpan(int[] stocks) {
		final int[] span = new int[stocks.length];
		final Stack<Integer> indexStack = new Stack<>();
		//indexStack.push(1);
		
		for(int i=0; i<stocks.length; i++) {
			// pop the indices of lesser elements from the stack
			while(!indexStack.isEmpty() && stocks[indexStack.peek()] < stocks[i]) {
				indexStack.pop();
			}
			span[i] = indexStack.isEmpty() ? (i+1) : (i-indexStack.peek());
			indexStack.push(i);
		}
		
		return span;
	}
	
	public static void main(String[] args) {
		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
		int[] spanArr = stockSpan(arr);
		
		System.out.print("Span Array : " + Arrays.toString(spanArr));
	}

}
