package com.hashtable;

public class MyHashMap<K, V> {
	MyLinkedList<K, V> myLinkedList;

	MyHashMap() {
		myLinkedList = new MyLinkedList<>();
	}

	/**
	 * @param key=  key value of node
	 * @param value = value of the node Checks if the node with key values exits if
	 *              does just updates its value parameter else creates new node and
	 *              adds to linked list
	 */
	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = myLinkedList.search(key);
		if (myMapNode == null) {
			MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
			myLinkedList.append(newNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	/**
	 * @param key=key of node whose value we are looking for
	 * @return value of the node with key=key.
	 */
	public V get(K key) {
		MyMapNode<K, V> myMapNode = myLinkedList.search(key);
		if (myMapNode == null) {
			return null;
		}
		return myMapNode.getValue();
	}

	@Override
	public String toString() {
		return "MyHashMap [myLinkedList=" + myLinkedList.printAllNodes() + "]";
	}

}
