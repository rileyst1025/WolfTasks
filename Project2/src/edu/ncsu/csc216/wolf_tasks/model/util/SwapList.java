package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * SwapList is a customized ArrayList with added functionality for moving items up and down 
 * @author rsthoma5
 * @param <E> type for the SwapList
 */
public class SwapList<E> implements ISwapList<E>{

	/** The initial capacity of a SwapList */
	private static final int INITIAL_CAPACITY = 10;
	/** The list holding the swap lists information */
	private E[] list;
	/** The size of the list */
	private int size;
	/**
	 * Constructs an empty SwapList of generic type E
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveUp(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveDown(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToFront(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToBack(int idx) {
		// TODO Auto-generated method stub
		
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
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new IllegalArgumentException("Cannot add null element");
		}
	}
}
