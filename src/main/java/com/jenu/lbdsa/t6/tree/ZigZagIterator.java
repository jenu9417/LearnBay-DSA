package com.jenu.lbdsa.t6.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * ZigZagIterator
 * --------------
 * 
 * The basic idea here is to use a BFS and find the nodes at the same level.
 * Then, iterate over the node list and for each odd iteration, reverse the list.
 * 
 * Time  : O(N)
 * 
 * @author Janardhanan V S
 *
 */
public class ZigZagIterator {
	
	static List<List<Node>> findPeers(BinarySearchTree btree) {
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
		
		final List<List<Node>> peerList = findPeers(btree);
		System.out.println("Peer List : ");
		int i = 0;
		for(List<Node> peers : peerList) {
			final List<String> dataList = peers.stream().map(x -> String.valueOf(x.data)).collect(Collectors.toList());
			if(i%2!=0) {
				Collections.reverse(dataList);
			}
			System.out.println(String.join(" -> ", dataList));
			i++;
		}
	}

}
