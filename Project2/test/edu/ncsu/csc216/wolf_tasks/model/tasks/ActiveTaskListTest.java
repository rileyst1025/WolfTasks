package edu.ncsu.csc216.wolf_tasks.model.tasks;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The ActiveTaskListTest class tests that ActiveTaskList holds the correct functionality for an active task list
 * @author rsthoma5
 *
 */
public class ActiveTaskListTest {
	/**
	 * Tests that the ActiveTaskList constructor works correctly
	 */
	@Test
	public void testActiveTaskList() {
		ActiveTaskList atl = new ActiveTaskList();
		assertEquals("Active Tasks", atl.getTaskListName());
		assertEquals(0, atl.getCompletedCount());
	}
	/**
	 * Tests that addTask checks to see if the Task is active before adding it
	 */
	@Test
	public void testAddTask() {
		ActiveTaskList atl = new ActiveTaskList();
		Task t1 = new Task("name1", "description1", false, true);
		Task t2 = new Task("name2", "description2", false, true);
		Task t3 = new Task("name3", "description3", false, true);
		Task t4 = new Task("name4", "description4", false, false);
		assertEquals(0, atl.getTasks().size());
		atl.addTask(t1);
		assertEquals(1, atl.getTasks().size());
		assertEquals(t1, atl.getTask(0));
		atl.addTask(t2);
		assertEquals(2, atl.getTasks().size());
		assertEquals(t1, atl.getTask(0));
		assertEquals(t2, atl.getTask(1));
		atl.addTask(t3);
		assertEquals(3, atl.getTasks().size());
		assertEquals(t1, atl.getTask(0));
		assertEquals(t2, atl.getTask(1));
		assertEquals(t3, atl.getTask(2));
		try {
			atl.addTask(t4);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Cannot add task to Active Tasks.", e.getMessage());
		}
	}
	/**
	 * Tests that setTaskName only sets to the correct name for an ActiveTaskList
	 */
	@Test
	public void testSetTaskListName() {
		ActiveTaskList atl = new ActiveTaskList();
		assertEquals("Active Tasks", atl.getTaskListName());
		atl.setTaskListName("Active Tasks");
		assertEquals("Active Tasks", atl.getTaskListName());
		try {
			atl.setTaskListName("Inactive Tasks");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Active Tasks", atl.getTaskListName());
			assertEquals("The Active Tasks list may not be edited.", e.getMessage());
		}
	}
	/**
	 * Tests that getTasksAsArray returns the correct array of Strings
	 */
	@Test
	public void testGetTasksAsArray() {
		Task t1 = new Task("name1", "description1", false, true);
		Task t2 = new Task("name2", "description2", false, true);
		Task t3 = new Task("name3", "description3", false, true);
		Task t4 = new Task("name4", "description4", false, true);
		ActiveTaskList atl = new ActiveTaskList();
		TaskList tl1 = new TaskList("list1", 0);
		TaskList tl2 = new TaskList("list2", 0);
		TaskList tl3 = new TaskList("list3", 0);
		tl1.addTask(t1);
		tl2.addTask(t2);
		tl3.addTask(t3);
		atl.addTask(t1);
		atl.addTask(t2);
		atl.addTask(t3);
		atl.addTask(t4);
		assertEquals("list1", atl.getTasksAsArray()[0][0]);
		assertEquals("name1", atl.getTasksAsArray()[0][1]);
		assertEquals("list2", atl.getTasksAsArray()[1][0]);
		assertEquals("name2", atl.getTasksAsArray()[1][1]);
		assertEquals("list3", atl.getTasksAsArray()[2][0]);
		assertEquals("name3", atl.getTasksAsArray()[2][1]);
		assertEquals("Active Tasks", atl.getTasksAsArray()[3][0]);
		assertEquals("name4", atl.getTasksAsArray()[3][1]);
	}
	/**
	 * Tests that clearTasks correctly clears the ActiveTaskList
	 */
	@Test
	public void testClearTasks() {
		Task t1 = new Task("name1", "description1", false, true);
		Task t2 = new Task("name2", "description2", false, true);
		Task t3 = new Task("name3", "description3", false, true);
		Task t4 = new Task("name4", "description4", false, true);
		ActiveTaskList atl = new ActiveTaskList();
		atl.addTask(t1);
		atl.addTask(t2);
		atl.addTask(t3);
		atl.addTask(t4);
		assertEquals(4, atl.getTasks().size());
		atl.clearTasks();
		assertEquals(0, atl.getTasks().size());
	}
}