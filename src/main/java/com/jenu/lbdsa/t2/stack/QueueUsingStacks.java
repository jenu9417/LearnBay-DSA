package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

public class QueueUsingStacks {

	private Stack<Integer> offerStack;
	
	private Stack<Integer> pollStack;
	
	public QueueUsingStacks() {
		offerStack = new Stack<>();
		pollStack = new Stack<>();
	}
	
	public void offer(Integer num) {
		offerStack.push(num);
	}
	
	public Integer poll() {
		if(pollStack.isEmpty()) {
			while(!offerStack.isEmpty()) {
				pollStack.push(offerStack.pop());
			}
		}
		return pollStack.pop();
	}
	
	public Integer peek() {
		if(pollStack.isEmpty()) {
			while(!offerStack.isEmpty()) {
				pollStack.push(offerStack.pop());
			}
		}
		return pollStack.peek();
	}
	
	public boolean isEmpty() {
		return offerStack.isEmpty() && pollStack.isEmpty();
	}
	
	public static void main(String[] args) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		
		System.out.println("Current peek : " + q.peek());
		
		q.poll();
		q.poll();
		q.poll();
		
		System.out.println("Current peek : " + q.peek());
	}
}
