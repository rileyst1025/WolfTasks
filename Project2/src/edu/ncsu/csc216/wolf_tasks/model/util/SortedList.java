package edu.ncsu.csc216.wolf_tasks.model.util;

public class SortedList<E extends Comparable<E>> implements ISortedList{

	/** The front of the list */
	private ListNode front;
	/** The size of the list */
	private int size;
	
	/**
	 * Adds the element to the list in sorted order.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@Override
	public void add(Comparable element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public Comparable remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns true if the element is in the list.
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(Comparable element) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public Comparable get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * The ListNode class represents a single element in a SortedList
	 * @author rsthoma5
	 *
	 */
	private class ListNode {
		/**The data the ListNode is holding */
		private E data;
		/**The next node in the list */
		private ListNode next;
		/**
		 * Constructs a ListNode with the given data and next ListNode
		 * @param data the data to set for the ListNode
		 * @param next the next ListNode in the list
		 */
		private ListNode(E data, ListNode next) {
			
		}
	}
}
