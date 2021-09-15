package com.hashtable;

/**
 * @author jayeshkumar
 *
 *         Every node of linked list is of MyMapNode
 */
public class MyLinkedList<K, V> {

	MyMapNode<K, V> head;
	MyMapNode<K, V> tail;

	/**
	 * Adds a new node at the end of linked list.
	 * 
	 * @param newNode= newly created node that need to be added.
	 */
	public void append(MyMapNode<K, V> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	/**
	 * this method searches for the particuler key in linked list.
	 * 
	 * @param key to be searched
	 * @return node of MyMapNode type whose key=key.
	 */
	public MyMapNode<K, V> search(K key) {
		MyMapNode<K, V> temp = head;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}
			temp = (MyMapNode<K, V>) temp.getNext();
		}
		return null;

	}

	/**
	 * @return all the content of linked list in string format
	 */

	public String toString() {
		return "My node[ " + head + " ]";
	}

}
