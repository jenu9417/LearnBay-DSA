package com.jenu.lbdsa.t6.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.jenu.lbdsa.t6.tree.BinarySearchTree.Node;

/**
 * 
 * ConnectPeersInBinaryTree
 * ------------------------
 * 
 * The basic idea here is to use a BFS and find the nodes at the same level. For this we add a 'null' object after completing parsing each level.
 * 
 * 
 * Time  : O(N)
 *
 * @author Janardhanan V S
 *
 */
public class ConnectPeersInBinaryTree {
	
	static List<List<Node>> connectPeers(BinarySearchTree btree) {
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
		
		final List<List<Node>> peerList = connectPeers(btree);
		System.out.println("Peer List : ");
		peerList.stream().forEach(y -> System.out.println(String.join(" -> ", y.stream().map(x -> String.valueOf(x.data)).collect(Collectors.toList()))));
	}

}
