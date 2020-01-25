package com.jenu.lbdsa.t3.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {
	
	static void sortQueue(Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return;
		}
		Integer num = queue.poll();
		sortQueue(queue);
		insertToSortedQueue(num, queue);
	}
	
	static void insertToSortedQueue(Integer num, Queue<Integer> queue) {
		if(queue.isEmpty()) {
			queue.offer(num);
			return;
		}
		int limit = queue.size();
		int count = limit;
		boolean isInserted = false;
		while(count-- > 0) {
			if(!isInserted && queue.peek().compareTo(num) > -1) {
				queue.offer(num);
				isInserted = true;
			}
			queue.offer(queue.poll());
		}
		
		if(!isInserted) {
			queue.offer(num);
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(5);
		queue.add(1);
		queue.add(2);
		queue.add(4);
		queue.add(3);
		
		System.out.println("Before Sorting : " + Arrays.toString(queue.toArray()));
		sortQueue(queue);
		System.out.println("After Sorting : " + Arrays.toString(queue.toArray()));
	}

}
