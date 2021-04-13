package edu.ncsu.csc216.wolf_tasks.model.tasks;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The TaskTest class tests that all of Task's methods work correctly
 * @author rsthoma5
 *
 */
public class TaskTest {
	/**
	 * Tests that the Task constructor works correctly
	 */
	@Test
	public void testTask() {
		Task t = new Task("name", "description", false, false);
		assertEquals("name", t.getTaskName());
		assertEquals("description", t.getTaskDescription());
		assertFalse(t.isRecurring());
		assertFalse(t.isActive());
		assertEquals("", t.getTaskListName());
		Task a = new Task("name", "description", false, true);
		assertEquals("name", a.getTaskName());
		assertEquals("description", a.getTaskDescription());
		assertFalse(a.isRecurring());
		assertTrue(a.isActive());
		assertEquals("", a.getTaskListName());
		Task r = new Task("name", "description", true, false);
		assertEquals("name", r.getTaskName());
		assertEquals("description", r.getTaskDescription());
		assertTrue(r.isRecurring());
		assertFalse(r.isActive());
		assertEquals("", r.getTaskListName());
		Task ar = new Task("name", "description", true, true);
		assertEquals("name", ar.getTaskName());
		assertEquals("description", ar.getTaskDescription());
		assertTrue(ar.isRecurring());
		assertTrue(ar.isActive());
		assertEquals("", ar.getTaskListName());
		try {
			Task i = new Task("", "description", true, true);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Incomplete task information", e.getMessage());
		}
		try {
			Task i = new Task(null, "description", true, true);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Incomplete task information", e.getMessage());
		}
		try {
			Task i = new Task("name", "", true, true);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Incomplete task information", e.getMessage());
		}
		try {
			Task i = new Task("name", null, true, true);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Incomplete task information", e.getMessage());
		}
	}
	/**
	 * Tests that completeTask correctly completes the Task
	 */
	@Test
	public void testCompleteTask() {
		Task t1 = new Task("name1", "description1", false, false);
		Task t2 = new Task("name2", "description2", true, false);
		Task t3 = new Task("name3", "description3", false, false);
		TaskList tL = new TaskList("taskList", 0);
		tL.addTask(t1);
		tL.addTask(t2);
		tL.addTask(t3);
		assertEquals(3, tL.getTasks().size());
		assertEquals("taskList", t1.getTaskListName());
		assertEquals("taskList", t2.getTaskListName());
		assertEquals("taskList", t3.getTaskListName());
		assertEquals(t1, tL.getTasks().get(0));
		assertEquals(t2, tL.getTasks().get(1));
		assertEquals(t3, tL.getTasks().get(2));
		assertEquals(0, tL.getCompletedCount());
		t1.completeTask();
		assertEquals(2, tL.getTasks().size());
		assertEquals(t2, tL.getTasks().get(0));
		assertEquals(t3, tL.getTasks().get(1));
		assertEquals(1, tL.getCompletedCount());
		t2.completeTask();
		assertEquals(2, tL.getTasks().size());
		assertEquals(t3, tL.getTasks().get(0));
		assertEquals("name2", tL.getTasks().get(1).getTaskName());
		assertEquals("description2", tL.getTasks().get(1).getTaskDescription());
	}
	/**
	 * Tests that toString generates the correct String
	 */
	@Test
	public void testToString() {
		Task t1 = new Task("name1", "description1", false, false);
		Task t2 = new Task("name2", "description2", true, false);
		Task t3 = new Task("name3", "description3", true, true);
		assertEquals("name1/ndescription1", t1.toString());
		assertEquals("name2,recurring/ndescription2", t2.toString());
		assertEquals("name3,recurring,active/ndescription3", t3.toString());
	}
}
