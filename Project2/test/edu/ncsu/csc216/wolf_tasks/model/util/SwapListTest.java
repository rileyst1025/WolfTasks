package edu.ncsu.csc216.wolf_tasks.model.util;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The SwapListTest class tests that SwapList correctly stores and moves its elements
 * @author rsthoma5
 *
 */
public class SwapListTest {
	/**
	 * Tests that the SwapList constrcutor works correctly
	 */
	@Test
	public void testSwapList() {
		SwapList<String> s = new SwapList<String>();
		assertEquals(0, s.size());
	}
	/**
	 * Tests that the add method correctly adds the given element
	 */
	@Test
	public void testAdd() {
		SwapList<String> s = new SwapList<String>();
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
		s.add("Tangerine");
		s.add("Banana");
		s.add("Cantelope");
		s.add("Blueberry");
		s.add("Strawberry");
		s.add("Blackberry");
		s.add("Mango");
		assertEquals(11, s.size());
		try {
			s.add(null);
			fail();
		} catch(NullPointerException e) {
			assertEquals(11, s.size());
		}
	}
	/**
	 * Tests that the remove method correctly removes the element at the given index
	 */
	@Test
	public void testRemove() {
		SwapList<String> s = new SwapList<String>();
		try {
			s.remove(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		s.add("Apple");
		s.add("Orange");
		s.add("Peach");
		s.add("Apricot");
		assertEquals("Orange", s.remove(1));
		assertEquals(3, s.size());
		assertEquals("Apple", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Apricot", s.get(2));
		assertEquals("Apple", s.remove(0));
		assertEquals(2, s.size());
		assertEquals("Peach", s.get(0));
		assertEquals("Apricot", s.get(1));
		assertEquals("Apricot", s.remove(1));
		assertEquals(1, s.size());
		assertEquals("Peach", s.get(0));
		try {
			s.remove(2);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(1, s.size());
		}
		try {
			s.remove(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(1, s.size());
		}
	}
	/**
	 * Tests that all the move methods work correctly
	 */
	@Test
	public void testMove() {
		SwapList<String> s = new SwapList<String>();
		try {
			s.moveToFront(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		try {
			s.moveToBack(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		try {
			s.moveUp(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		try {
			s.moveDown(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		s.add("Apple");
		s.add("Orange");
		s.add("Peach");
		s.add("Apricot");
		s.add("Mango");
		s.moveToFront(2);
		assertEquals("Peach", s.get(0));
		assertEquals("Apple", s.get(1));
		assertEquals("Orange", s.get(2));
		assertEquals("Apricot", s.get(3));
		assertEquals("Mango", s.get(4));
		s.moveToFront(3);
		assertEquals("Apricot", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Apple", s.get(2));
		assertEquals("Orange", s.get(3));
		assertEquals("Mango", s.get(4));
		s.moveToFront(0);
		assertEquals("Apricot", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Apple", s.get(2));
		assertEquals("Orange", s.get(3));
		assertEquals("Mango", s.get(4));
		s.moveToBack(2);
		assertEquals("Apricot", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Orange", s.get(2));
		assertEquals("Mango", s.get(3));
		assertEquals("Apple", s.get(4));
		s.moveToBack(0);
		assertEquals("Peach", s.get(0));
		assertEquals("Orange", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Apple", s.get(3));
		assertEquals("Apricot", s.get(4));
		s.moveToBack(4);
		assertEquals("Peach", s.get(0));
		assertEquals("Orange", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Apple", s.get(3));
		assertEquals("Apricot", s.get(4));
		s.moveUp(1);
		assertEquals("Orange", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Apple", s.get(3));
		assertEquals("Apricot", s.get(4));
		s.moveUp(4);
		assertEquals("Orange", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Apricot", s.get(3));
		assertEquals("Apple", s.get(4));
		s.moveUp(0);
		assertEquals("Orange", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Mango", s.get(2));
		assertEquals("Apricot", s.get(3));
		assertEquals("Apple", s.get(4));
		s.moveDown(2);
		assertEquals("Orange", s.get(0));
		assertEquals("Peach", s.get(1));
		assertEquals("Apricot", s.get(2));
		assertEquals("Mango", s.get(3));
		assertEquals("Apple", s.get(4));
		s.moveDown(0);
		assertEquals("Peach", s.get(0));
		assertEquals("Orange", s.get(1));
		assertEquals("Apricot", s.get(2));
		assertEquals("Mango", s.get(3));
		assertEquals("Apple", s.get(4));
		assertEquals("Apple", s.get(4));
		s.moveDown(4);
		assertEquals("Peach", s.get(0));
		assertEquals("Orange", s.get(1));
		assertEquals("Apricot", s.get(2));
		assertEquals("Mango", s.get(3));
		assertEquals("Apple", s.get(4));
		try {
			s.moveToFront(7);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveToBack(7);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveUp(7);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveDown(7);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveToFront(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveToBack(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveUp(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
		try {
			s.moveDown(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(5, s.size());
		}
	}
}

