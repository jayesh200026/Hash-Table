package com.hashtable;

/**
 * @author jayeshkumar Created a contract to create a node.Anyone who wants to
 *         create node has to implement these methods.
 * 
 */
public interface INode<K> {

	K getKey();

	public void setkey(K key);

	public void setNext(INode<K> next);

	public INode<K> getNext();

}
