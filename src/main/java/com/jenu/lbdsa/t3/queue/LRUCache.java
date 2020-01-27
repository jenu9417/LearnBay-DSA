package com.jenu.lbdsa.t3.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*

LRUCache / LeastFrequentQueue:
-------------------

A queue which return the least frequent element in the stack. If there are elements with same frequency, 
it should return in FIFO order.

Time  : O(n)
Space : O(n)

*/

public class LRUCache {

	private Map<Integer, Queue<Integer>> bucketMap;

	private Map<Integer, Integer> frequencyMap;

	private int topBucket;

	public LRUCache() {
		bucketMap = new TreeMap<>();
		frequencyMap = new HashMap<>();
		topBucket = 1;
	}

	public void push(Integer num) {
		// Update frequency
		Integer frequency = frequencyMap.get(num);
		if (frequency == null) {
			frequency = 1;
		} else {
			frequency++;
		}
		frequencyMap.put(num, frequency);

		// Update bucket
		Queue<Integer> bucket = bucketMap.get(frequency);
		if (bucket == null) {
			bucket = new LinkedList<>();
		}
		bucket.offer(num);
		bucketMap.put(frequency, bucket);
	}

	public Integer pop() {
		// Update bucket
		Queue<Integer> bucket = bucketMap.get(topBucket);
		if (bucket == null) {
			return null;
		}
		Integer num = bucket.poll();
		if (bucket.isEmpty()) {
			bucketMap.remove(topBucket);
		} else {
			bucketMap.put(topBucket, bucket);
		}

		// Update frequency
		Integer frequency = frequencyMap.get(num);
		if (frequency != null) {
			frequency--;
			frequencyMap.put(num, frequency);
		}

		return num;
	}

	public Integer peek() {
		Queue<Integer> bucket = bucketMap.get(topBucket);
		if (bucket == null) {
			return null;
		}
		return bucket.peek();
	}

	public void printCache() {
		System.out.println("\n--------- Current Cache ---------\n");
		for (Map.Entry<Integer, Queue<Integer>> entry : bucketMap.entrySet()) {
			System.out.printf("[ %d ]  ==> %s \n", entry.getKey(), entry.getValue().toString());
		}
		System.out.println("\n---------------------------------\n");
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.push(1);
		cache.push(2);
		cache.push(2);
		cache.push(2);
		cache.push(3);
		cache.push(3);
		cache.push(4);

		System.out.println("Peek : " + cache.peek());
		cache.printCache();

		cache.pop();
		cache.pop();
		cache.push(4);
		cache.push(4);
		cache.push(4);

		System.out.println("Peek : " + cache.peek());
		cache.printCache();
	}

}
