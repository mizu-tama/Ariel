package com.gmail.mizuno.tamaki.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<K>{
	public class BSTreeIterator implements Iterator<K> {
		
		private Queue<Node<K, V>> queue = new ArrayDeque<Node<K, V>>();
		private Node<K, V> next;
		
		public BSTreeIterator() {
			pushToQueue(root);
		}

		private void pushToQueue(Node<K, V> root) {
			Node<K, V> tmp = root;
			
			while (true) {
				queue.add(tmp);
				if (tmp.lChild == null) {
					return;
				} else {
					tmp = tmp.lChild;
				}
			}
		}

		@Override
		public boolean hasNext() {
			if (queue.isEmpty()) {
				return false;
			}
			return true;
		}

		@Override
		public K next() {
			next = getNext();
			return next.key;
		}

		private Node<K, V> getNext() {
			Node<K, V> tmp = queue.remove();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

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
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (lChild != null) {
				sb.append("<" + lChild + ">");
			}
			sb.append(value);
			if (rChild != null) {
				sb.append("<" + rChild + ">");
			}
			return  sb.toString();
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
	
	public V delete(K key) {
		Node<K, V> tmp = root;
		while (true) {
			if (tmp == null) {
				return null;
			}
			
			if (key.equals(tmp.key)) {
				return delete(tmp).value;
			} else if (key.compareTo(tmp.key) < 0) {
				tmp = tmp.lChild;
			} else {
				tmp = tmp.rChild;
			}
		}
	}

	private Node<K, V> delete(Node<K, V> node) {
		if (node.lChild == null && node.rChild == null) {
			if (node == node.parent.lChild) {
				node.parent.lChild = null;
			} else {
				node.parent.rChild = null;
			}
		} else if (node.lChild == null) {
			if (node == node.parent.lChild) {
				node.rChild.parent = node.parent;
				node.parent.lChild = node.rChild;
			} else {
				node.rChild.parent = node.parent;
				node.parent.rChild = node.rChild;
			}
		} else if (node.rChild == null) {
			if (node == node.parent.lChild) {
				node.lChild.parent = node.parent;
				node.parent.lChild = node.lChild;
			} else {
				node.lChild.parent = node.parent;
				node.parent.rChild = node.lChild;
			}
		} else {
			Node<K, V> maxNode = getMaxNode(node.lChild);
			if (node == node.parent.lChild) {
				delete(maxNode);
				maxNode.parent = node.parent;
				maxNode.lChild = node.lChild;
				maxNode.rChild = node.rChild;
				node.parent.lChild = maxNode;
				node.lChild.parent = maxNode;
				node.rChild.parent = maxNode;
			} else {
				delete(maxNode);
				maxNode.parent = node.parent;
				maxNode.lChild = node.lChild;
				maxNode.rChild = node.rChild;
				node.parent.rChild = maxNode;
				node.lChild.parent = maxNode;
				node.rChild.parent = maxNode;
			}
		}
		return node;
	}

	private Node<K, V> getMaxNode(Node<K, V> root) {
		Node<K, V> tmp = root;
		if (tmp.rChild == null) {
			return tmp;
		} else {
			tmp = tmp.rChild;
			return getMaxNode(tmp);
		}
	}

	@Override
	public Iterator<K> iterator() {
		return new BSTreeIterator();
	}
	
	@Override
	public String toString() {
		if (root == null) {
			return "";
		}
		return root.toString();
	}

}
