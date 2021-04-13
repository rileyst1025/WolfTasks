package edu.ncsu.csc216.wolf_tasks.model.util;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The SortedListTest class test that SortedList maintains a correctly sorted list of elements 
 * @author rsthoma5
 *
 */
public class SortedListTest {
	/**
	 * Tests that the SortedList constructor works correctly
	 */
	@Test
	public void testSortedList() {
		SortedList<String> s = new SortedList<String>();
		assertEquals(0, s.size());
	}
	/**
	 * Tests that add correctly adds an element to the sortedList
	 */
	@Test
	public void testAdd() {
		SortedList<String> s = new SortedList<String>();
		s.add("Apple");
		assertEquals(1, s.size());
		assertEquals("Apple", s.get(0));
		s.add("Orange");
		assertEquals(2, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Orange", s.get(1));
		s.add("Peach");
		assertEquals(3, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Orange", s.get(1));
		assertEquals("Peach", s.get(2));
		s.add("Grape");
		assertEquals(4, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Grape", s.get(1));
		assertEquals("Orange", s.get(2));
		assertEquals("Peach", s.get(3));
		s.add("Tangerine");
		assertEquals(5, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Grape", s.get(1));
		assertEquals("Orange", s.get(2));
		assertEquals("Peach", s.get(3));
		assertEquals("Tangerine", s.get(4));
		s.add("Banana");
		assertEquals(6, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Banana", s.get(1));
		assertEquals("Grape", s.get(2));
		assertEquals("Orange", s.get(3));
		assertEquals("Peach", s.get(4));
		assertEquals("Tangerine", s.get(5));
		s.add("Acai");
		assertEquals(7, s.size());
		assertEquals("Acai", s.get(0));
		assertEquals("Apple", s.get(1));
		assertEquals("Banana", s.get(2));
		assertEquals("Grape", s.get(3));
		assertEquals("Orange", s.get(4));
		assertEquals("Peach", s.get(5));
		assertEquals("Tangerine", s.get(6));
		s.add("Blueberry");
		assertEquals(8, s.size());
		assertEquals("Acai", s.get(0));
		assertEquals("Apple", s.get(1));
		assertEquals("Banana", s.get(2));
		assertEquals("Blueberry", s.get(3));
		assertEquals("Grape", s.get(4));
		assertEquals("Orange", s.get(5));
		assertEquals("Peach", s.get(6));
		assertEquals("Tangerine", s.get(7));
		s.add("Strawberry");
		assertEquals(9, s.size());
		assertEquals("Acai", s.get(0));
		assertEquals("Apple", s.get(1));
		assertEquals("Banana", s.get(2));
		assertEquals("Blueberry", s.get(3));
		assertEquals("Grape", s.get(4));
		assertEquals("Orange", s.get(5));
		assertEquals("Peach", s.get(6));
		assertEquals("Strawberry", s.get(7));
		assertEquals("Tangerine", s.get(8));
		try {
			s.add(null);
			fail();
		} catch(NullPointerException e) {
			assertEquals(9, s.size());
		}
		try {
			s.add("Strawberry");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals(9, s.size());
		}
	}
	/**
	 * Tests that remove correctly removes the element at the given index
	 */
	@Test
	public void testRemove() {
		SortedList<String> s = new SortedList<String>();
		try {
			s.remove(0);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		s.add("Apple");
		s.add("Banana");
		s.add("Mango");
		s.add("Apricot");
		s.add("Tomato");
		assertEquals("Apple", s.get(0));
		assertEquals("Apricot", s.get(1));
		assertEquals("Banana", s.get(2));
		assertEquals("Mango", s.get(3));
		assertEquals("Tomato", s.get(4));
		assertEquals("Banana", s.remove(2));
		assertEquals(4, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Apricot", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Tomato", s.get(3));
		assertEquals("Apple", s.remove(0));
		assertEquals(3, s.size());
		assertEquals("Apricot", s.get(0));
		assertEquals("Mango", s.get(1));
		assertEquals("Tomato", s.get(2));
		assertEquals("Tomato", s.remove(2));
		assertEquals(2, s.size());
		assertEquals("Apricot", s.get(0));
		assertEquals("Mango", s.get(1));
		try {
			s.remove(5);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(2, s.size());
		}
		try {
			s.remove(-1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(2, s.size());
		}
	}
}
