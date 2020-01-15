package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

MinStack:
---------

Use and extra stack and maintain the min element till then

*/

public class MinStack {
	
	private Stack<Integer> stack;

	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			minStack.push(x);
		} else {
			if (x <= minStack.peek()) {
				minStack.push(x);
			}
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(512);
		m.push(-1024);
		m.push(-1024);
		m.push(512);
		m.pop();
		
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
	}

}
