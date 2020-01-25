package com.jenu.lbdsa.t3.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	
	private Queue<Integer> queue;
	
	public StackUsingQueues() {
		queue = new LinkedList<>();
	}
	
	public void push(Integer num) {
		queue.offer(num);
	}
	
	public Integer pop() {
		int count = queue.size()-1;
		while(count-->0) {
			queue.offer(queue.poll());
		}
		return queue.poll();
	}
	
	public Integer peek() {
		int count = queue.size()-1;
		while(count-->0) {
			queue.offer(queue.poll());
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		StackUsingQueues sq = new StackUsingQueues();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		
		System.out.println("Current Peek : " + sq.peek());
		
		sq.pop();
		sq.pop();
		
		System.out.println("Current Peek : " + sq.peek());
	}

}
