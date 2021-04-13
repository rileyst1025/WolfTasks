package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * The SortedList class is an array based list, implements the ISortedList interface, and holds elements in a sorted order 
 * @author rsthoma5
 *
 * @param <E> type for the SortedList
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** The front of the list */
	private ListNode front;
	/** The size of the list */
	private int size;
	
	/**
	 * Creates an empty SortedList
	 */
	public SortedList() {
		front = null;
		size = 0;
	}
	/**
	 * Adds the element to the list in sorted order.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if(size == 0) {
			ListNode addNode = new ListNode(element, null);
			front = addNode;
			size++;
		}
		else {
			if(contains(element)) {
				throw new IllegalArgumentException("Cannot add duplicate element");
			}
			ListNode current = front;
			boolean hasAdded = false;
			if(element.compareTo(current.data) < 0) {
				ListNode addNode = new ListNode(element, front);
				front = addNode;
				hasAdded = true;
			}
			if(!hasAdded) {
				while(!(current.next == null)) {
					if(element.compareTo(current.next.data) < 0) {
						ListNode addNode = new ListNode(element, current.next);
						current.next = addNode;
						hasAdded = true;
						break;
					}
					current = current.next;
				}
			}
			if(!hasAdded) {
				ListNode addNode = new ListNode(element, null);
				current.next = addNode;
			}
			size++;
		}
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
	public E remove(int idx) {
		if(idx < 0 || idx >= size || size == 0) {
			throw new IllegalArgumentException("Invalid index.");
		}
		if(idx == 0) {
			E rtn = front.data;
			if(size > 1) {
				front = front.next;
				size--;
				return rtn;
			}
			front = null;
			size--;
			return rtn;
		}
		ListNode current = front;
		if(idx == size - 1) {
			for(int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			E rtn = current.next.data;
			current.next = null;
			size--;
			return rtn;
		}
		for(int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		E rtn = current.next.data;
		current.next = current.next.next;
		size--;
		return rtn;
	}

	/**
	 * Returns true if the element is in the list.
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		while(!(current.next == null)) {
			if(current.data.compareTo(element) == 0){
				return true;
			}
			current = current.next;
		}
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
	public E get(int idx) {
		if(idx < 0 || idx >= size || size == 0) {
			throw new IllegalArgumentException("Invalid index.");
		}
		ListNode current = front;
		for(int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return size;
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
			this.data = data;
			this.next = next;
		}
	}
}
