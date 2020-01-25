package com.jenu.lbdsa.t3.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingStack {

	static Queue<Integer> reverseQueueUsingStack(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		
		while(!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		
		return queue;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		
		System.out.println("Before Reversal : " + Arrays.toString(queue.toArray()));
		
		queue = reverseQueueUsingStack(queue);
		
		System.out.println("After Reversal : " + Arrays.toString(queue.toArray()));
	}

	
}
