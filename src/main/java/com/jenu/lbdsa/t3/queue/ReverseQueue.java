package com.jenu.lbdsa.t3.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
	
	static Queue<Integer> reverseQueue(Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return queue;
		}
		
		Integer front = queue.poll();
		reverseQueue(queue);
		queue.offer(front);
		
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
		
		queue = reverseQueue(queue);
		
		System.out.println("After Reversal : " + Arrays.toString(queue.toArray()));
	}

}
