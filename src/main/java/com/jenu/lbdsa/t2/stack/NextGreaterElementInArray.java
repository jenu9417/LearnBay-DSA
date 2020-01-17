package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

NextGreaterElementInArray:

Find the next greater element on the immediate right.

Input : 4, 5, 2, 25, 7, 32, 8, 6
Output :
4 --> 5
5 --> 25
2 --> 25
25 --> 32
7 --> 32
32 --. -1
8 --> -1
6 --> -1

*/

public class NextGreaterElementInArray {
	
	static Stack<Tuple> nextGreaterElementInArray(int[] arr) {
		final Stack<Tuple> arrStack = new Stack<>();
		for(int i=(arr.length-1); i>=0; i--) {
			final int nextGreater = findNextGreaterElementInStack(arr[i], arrStack);
			arrStack.push(Tuple.New(arr[i], nextGreater));
		}
		
		return arrStack;
	}
	
	static int findNextGreaterElementInStack(int num, Stack<Tuple> s) {
		if(s.isEmpty()) {
			return -1;
		}
		
		if(s.peek().number > num) {
			return s.peek().number;
		} else if(s.peek().nextGreater > num) {
			return s.peek().nextGreater;
		}
		
		final Tuple t = s.pop();
		final int greaterNum = findNextGreaterElementInStack(num, s);
		s.push(t);
		
		return greaterNum;
	}
	
	static void printAndEmptyStack(Stack<Tuple> s) {
		while(!s.isEmpty()) {
			final Tuple t = s.pop();
			System.out.printf("Num : %d    ::    Next Greater : %d \n", t.number, t.nextGreater);
		}
	}
	
	public static void main(String[] args) {
		final int[] arr = { 4, 5, 2, 25, 7, 32, 8, 6 };
		final Stack<Tuple> arrStack = nextGreaterElementInArray(arr);
		printAndEmptyStack(arrStack);
	}
	
	static class Tuple {
		int number;
		int nextGreater;
		
		private Tuple(int number, int nextGreater) {
			this.number = number;
			this.nextGreater = nextGreater;
		}
		
		static Tuple New(int number, int nextGreater) {
			return new Tuple(number, nextGreater);
		}
		
		@Override
		public String toString() {
			return "Tuple [number=" + number + ", nextGreater=" + nextGreater + "]";
		} 
	}

}

