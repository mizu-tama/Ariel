package com.gmail.mizuno.tamaki.binary_search_tree;

import java.util.Iterator;

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<K>{
	public class Node<K extends Comparable<K>, V> {
		private K key;
		private V value;
		private Node<K, V> parent;
		private Node<K, V> lChild;
		private Node<K, V> rChild;

		public Node(K key, V value, Node<K, V> parent, Node<K, V> lChild, Node<K, V> rChild) {
			this.key = key;
			this.value = value;
			this.parent = parent;
			this.lChild = lChild;
			this.rChild = rChild;
		}
	}

	private Node<K, V> root = null;
	
	public void add(K key, V value) {
		if (root == null) {
			root = new Node<K, V>(key, value, null, null, null);
			return;
		}
		
		Node<K, V> tmp = root;
		while (true) {
			if (key.compareTo(tmp.key) < 0) {
				if (tmp.lChild == null) {
					tmp.lChild = new Node<K, V>(key, value, tmp, null, null);
					break;
				} else {
					tmp = tmp.lChild;
				}
			} else {
				if (tmp.rChild == null) {
					tmp.rChild = new Node<K, V>(key, value, tmp, null, null);
					break;
				} else {
					tmp = tmp.rChild;
				}
			}
		}
	}
	
	public V search(K key) {
		Node<K, V> tmp = root;
		while (true) {
			if (tmp == null) {
				return null;
			}
			
			if (key.equals(tmp.key)) {
				return tmp.value;
			} else if (key.compareTo(tmp.key) < 0) {
				tmp = tmp.lChild;
			} else {
				tmp = tmp.rChild;
			}
		}
	}
	
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
