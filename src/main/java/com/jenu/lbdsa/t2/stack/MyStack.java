package com.jenu.lbdsa.t2.stack;

import java.util.EmptyStackException;

public class MyStack {
	
	private int[] data;
	
	private int size;
	
	private int top;
	
	public MyStack(int size) {
		data = new int[size];
		top = -1;
	}
	
	public void push(int n) throws Exception {
		if(isFull()) {
			throw new IndexOutOfBoundsException();
		}
		data[++top] = n;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return data[top--];
	}
	
	public int peek() {
		return data[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == size-1);
	}
	
	public void print() {
		int i = 0;
		while(i <= top) {
			System.out.println(data[i++]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyStack s = new MyStack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop();
		s.print();
		System.out.println(s.peek());
	}


}
