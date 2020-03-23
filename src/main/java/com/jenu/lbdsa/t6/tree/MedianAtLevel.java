package com.jenu.lbdsa.t6.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * MedianAtLevel
 * -------------
 * 
 * The basic idea here is to use a BFS and find the nodes at the same level.
 * Mean is defined as the middle value when we place the elements in sorted order.
 * When there are even number of elements, then median is defined as the mean of
 * middle two elements.
 * 
 * Time  : O(N)
 *
 * @author Janardhanan V S
 *
 */
public class MedianAtLevel {
	
	static void printMedianAtLevel(BinarySearchTree btree) {
		final List<List<Node>> peerList = findPeersAtSameLevel(btree);
		final List<Integer> meanList = new ArrayList<>();
		for(List<Node> peers : peerList) {
			final List<Integer> dataList = peers.stream().map(x -> x.data).sorted().collect(Collectors.toList());
			if(dataList.size() % 2 != 0) {
				final int mean = dataList.get(dataList.size() / 2);
				meanList.add(mean);
			} else {
				final int mid = (dataList.size()-1) / 2;
				final int mean = (dataList.get(mid) + dataList.get(mid+1)) / 2;
				meanList.add(mean);
			}
		}
		
		final Iterator<List<Node>> peerListIterator = peerList.iterator();
		final Iterator<Integer> meanListIterator = meanList.iterator();
		
		int i = 0;
		while(peerListIterator.hasNext() && meanListIterator.hasNext()) {
			final List<Node> peers = peerListIterator.next();
			final Integer mean = meanListIterator.next();
			final String peerString = String.join(", ", peers.stream().map(x -> String.valueOf(x.data)).collect(Collectors.toList()));
			System.out.printf("Level : %d  |:|  Mean : %d  |:|  [ %s ]\n", i++, mean, peerString);
		}
	}
	
	static List<List<Node>> findPeersAtSameLevel(BinarySearchTree btree) {
		final List<List<Node>> peerList = new ArrayList<>();
		final Queue<Node> queue = new LinkedList<>();
		queue.add(btree.getRoot());
		queue.add(null);
		
		while(queue.size() > 1 && queue.peek() != null) {
			final List<Node> peers = new ArrayList<>();
			while(queue.peek() != null) {
				final Node node = queue.poll();
				peers.add(node);
				queue.add(node.left);
				queue.add(node.right);
			}
			queue.add(queue.poll());
			peerList.add(peers);
		}
		
		return peerList;
	}
	
	public static void main(String[] args) {
		final BinarySearchTree btree = new BinarySearchTree();
		btree.insert(4);
		btree.insert(2);
		btree.insert(1);
		btree.insert(3);
		btree.insert(6);
		btree.insert(5);
		btree.insert(7);
		
		printMedianAtLevel(btree);
	}

}
