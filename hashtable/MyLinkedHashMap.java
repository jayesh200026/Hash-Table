package com.hashtable;

import java.util.ArrayList;

/**
 * @author jayeshkumar
 *Has bucket of ArrayList type which stores linkedlist.
 */
public class MyLinkedHashMap<K,V> {
	
	private final int bucketSize;
	ArrayList<MyLinkedList<K,V>> bucketList;
	
	MyLinkedHashMap(){
		bucketSize=10;
		bucketList=new ArrayList<>(bucketSize);
		for(int i=0;i<bucketSize;i++) {
			bucketList.add(null);
		}
	}
	
	/**
	 * @param key= key of the node
	 * @return returns a value between 0 and bucketSize-1
	 */
	public int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index= hashCode % bucketSize;
		return index;
		
	}
	
	/**
	 * @param key=key of the node
	 * @param value=value of the node
	 * First get the index using hashcode.
	 * Then get the linkedlist in that index.
	 * If no linked list creates one.
	 * Then searches for key in the found linked list.
	 * If founds updates the value
	 * else creates and adds new node.
	 */
	public void add(K key,V value) {
		int index=getBucketIndex(key);
		MyLinkedList<K,V> myLinkedList = bucketList.get(index);
		if(myLinkedList==null) {
			myLinkedList= new MyLinkedList<>();
			bucketList.set(index, myLinkedList);
		}
		MyMapNode<K,V> myMapNode = myLinkedList.search(key);
		if(myMapNode==null) {
			myMapNode= new MyMapNode<>(key,value);
			myLinkedList.append(myMapNode);
		}
		myMapNode.setValue(value);
	}
	
	/**
	 * @param key=key of node.
	 * @return value associated with key.
	 */
	public V get(K key) {
		int index=getBucketIndex(key);
		MyLinkedList<K,V> myLinkedList = bucketList.get(index);
		if(myLinkedList==null) {
			return null;
		}
		MyMapNode<K,V> myMapNode = myLinkedList.search(key);
		if(myMapNode==null) {
			return null;
		}
		return myMapNode.getValue();
	}
	
	public String toString() {
		return "MyLinkedHashMap List{"+bucketList+ '}';
	}

}
