package com.jenu.lbdsa.t3.queue;

/*

Dynamic Queue:

Create a circular dynamic queue, which increases its size

*/
public class DynamicQueue {
	
	private int[] data;
	
	private int front;
	
	private int rear;
	
	private double threshold;
	
	private double shrinkThreshold;
	
	private static final int DEFAULT_SIZE = 10;
	
	private static final int MAX_SIZE = 1000;
	
	public DynamicQueue(int size) {
		data = new int[size];
		front = 0;
		rear = -1;
		threshold = 0.75;
		shrinkThreshold = 0.1;
	}
	
	public void offer(int n) throws Exception {
		if(shouldIncreaseCapacity()) {
			doubleCapacity();
		}
		data[++rear] = n;
	}

	public int poll() throws Exception {
		if(shouldDecreaseCapacity()) {
			halfCapacity();
		}
		int num = data[front++];
		if(front-1 == rear) {
			front = -1;
			rear = -1;
		} else if(front == data.length) {
			front = front % data.length;
			rear = rear % data.length;
		}
		return num;
	}

	public int peek() {
		return data[front];
	}
	
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	public boolean isFull() {
		return (rear-front == (data.length -1));
	}
	
	private boolean shouldIncreaseCapacity() {
		if((data.length * threshold) < (rear-front+1) && data.length < MAX_SIZE) {
			return true;
		}
		return false;
	}
	
	private void doubleCapacity() {
		int newSize = (data.length*2 > MAX_SIZE) ? MAX_SIZE : data.length*2;
		int[] newData = new int[newSize];
		if(rear > data.length) {
			System.arraycopy(data, 0, newData, front, data.length);
			System.arraycopy(data, (data.length-front), newData, 0, (rear%data.length)+1);
		} else {
			System.arraycopy(data, 0, newData, front, rear+1);
		}
		rear = rear-front;
		front = 0;
		data = newData;
	}
	
	private boolean shouldDecreaseCapacity() {
		if(data.length > DEFAULT_SIZE && ((rear-front-1) < (data.length*shrinkThreshold))) {
			return true;
		}
		return false;
	}

	private void halfCapacity() {
		int newSize = (data.length/2 < DEFAULT_SIZE) ? DEFAULT_SIZE : data.length/2;
		int[] newData = new int[newSize];
		if(rear > data.length) {
			System.arraycopy(data, front, newData, 0, data.length);
			System.arraycopy(data, 0, newData, (data.length-front), (rear%data.length)+1);
		} else {
			System.arraycopy(data, front, newData, 0, rear);
		}
		rear = rear-front;
		front = 0;
		data = newData;
	}
	
	public void print() {
		int i = front;
		System.out.print("Queue : [\t");
		while(i <= rear) {
			System.out.print(data[i%data.length] + "\t");
			i++;
		}
		System.out.println("]\n");
	}
	
	public static void main(String[] args) throws Exception {
		final DynamicQueue q = new DynamicQueue(10);
		System.out.println("Initial Size : " + q.data.length);
		q.print();
		
		for(int i = 0; i<10; i++) {
			q.offer(i);
		}
		System.out.println("Expanded Size : " + q.data.length);
		q.print();
		
		for(int i = 0; i<8; i++) {
			q.poll();
		}
		
		for(int i = 10; i<14; i++) {
			q.offer(i);
		}
		
		System.out.println("Shrinked Size : " + q.data.length);
		q.print();
	}

}
