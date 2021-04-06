package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * SwapList is a customized ArrayList with added functionality for moving items up and down 
 * @author rsthoma5
 * @param <E> type for the SwapList
 */
public class SwapList<E> implements ISwapList<E> {

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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		E rtn = get(idx);
		for(int i = idx; i < size-1; i++) {
			list[i] = list[i+1];
		}
		size--;
		return rtn;
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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		if(idx > 0) {
			E temp = list[idx];
			list[idx] = list[idx - 1];
			list[idx - 1] = temp;
		}
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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		if(idx < size - 1) {
			E temp = list[idx];
			list[idx] = list[idx + 1];
			list[idx + 1] = temp;
		}
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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		E front = list[idx];
		for(int i = idx; i > 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = front;
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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		E back = list[idx];
		for(int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = back;
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
		if(idx >= size || idx < 0 || size == 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		return list[idx];
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
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element");
		}
		checkCapacity();
		list[size] = element;
		size++;
	}
	/**
	 * Checks to see if list is at capacity and if so, grows the capacity by 10
	 */
	private void checkCapacity() {
		if(size == list.length) {
			@SuppressWarnings("unchecked")
			E[] newlist = (E[]) new Object[size + 10];
			for(int i = 0; i < size; i++) {
				newlist[i] = list[i];
			}
			list = newlist;
		}
	}
}
