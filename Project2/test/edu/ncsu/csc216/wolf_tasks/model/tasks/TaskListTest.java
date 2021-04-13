package edu.ncsu.csc216.wolf_tasks.model.tasks;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The TaskListTest class tests that TaskList can correcly be expressed as an array and compared to other TaskLists
 * @author rsthoma5
 *
 */
public class TaskListTest {
	/**
	 * Tests that the TaskList constructor works correctly
	 */
	@Test
	public void testTaskList() {
		TaskList tl = new TaskList("name", 2);
		assertEquals("name", tl.getTaskListName());
		assertEquals(2, tl.getCompletedCount());
		assertEquals(0, tl.getTasks().size());
		TaskList itl = new TaskList("name", 2);
		assertEquals(2, itl.getCompletedCount());
		try {
			itl = new TaskList("", 2);
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			itl = new TaskList(null, 2);
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			itl = new TaskList("name", -2);
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid completed count.", e.getMessage());
		}
	}
	/**
	 * Tests that addTask correctly adds a task to the TaskList
	 */
	@Test
	public void testAddTask() {
		TaskList tl = new TaskList("taskList", 0);
		Task t1 = new Task("name1", "description1", false, false);
		Task t2 = new Task("name2", "description2", false, false);
		Task t3 = new Task("name3", "description3", false, false);
		assertEquals(0, tl.getTasks().size());
		tl.addTask(t1);
		assertEquals(1, tl.getTasks().size());
		assertEquals(t1, tl.getTask(0));
		tl.addTask(t2);
		assertEquals(2, tl.getTasks().size());
		assertEquals(t1, tl.getTask(0));
		assertEquals(t2, tl.getTask(1));
		tl.addTask(t3);
		assertEquals(3, tl.getTasks().size());
		assertEquals(t1, tl.getTask(0));
		assertEquals(t2, tl.getTask(1));
		assertEquals(t3, tl.getTask(2));
	}
	/**
	 * Tests that removeTask correctly removes the task at the given index
	 */
	@Test
	public void testRemoveTask() {
		TaskList tl = new TaskList("taskList", 0);
		Task t1 = new Task("name1", "description1", false, false);
		Task t2 = new Task("name2", "description2", false, false);
		Task t3 = new Task("name3", "description3", false, false);
		Task t4 = new Task("name4", "description4", false, false);
		tl.addTask(t1);
		tl.addTask(t2);
		tl.addTask(t3);
		tl.addTask(t4);
		assertEquals(t2, tl.removeTask(1));
		assertEquals(3, tl.getTasks().size());
		assertEquals(t1, tl.getTask(0));
		assertEquals(t3, tl.getTask(1));
		assertEquals(t4, tl.getTask(2));
		assertEquals(t1, tl.removeTask(0));
		assertEquals(2, tl.getTasks().size());
		assertEquals(t3, tl.getTask(0));
		assertEquals(t4, tl.getTask(1));
		assertEquals(t4, tl.removeTask(1));
		assertEquals(1, tl.getTasks().size());
		assertEquals(t3, tl.getTask(0));
	}
	/**
	 * Tests that getTasksAsArray returns the correct array of Strings
	 */
	@Test
	public void testGetTasksAsArray() {
		TaskList tl = new TaskList("taskList", 0);
		Task t1 = new Task("name1", "description1", false, false);
		Task t2 = new Task("name2", "description2", false, false);
		Task t3 = new Task("name3", "description3", false, false);
		Task t4 = new Task("name4", "description4", false, false);
		tl.addTask(t1);
		tl.addTask(t2);
		tl.addTask(t3);
		tl.addTask(t4);
		assertEquals("1", tl.getTasksAsArray()[0][0]);
		assertEquals("name1", tl.getTasksAsArray()[0][1]);
		assertEquals("2", tl.getTasksAsArray()[1][0]);
		assertEquals("name2", tl.getTasksAsArray()[1][1]);
		assertEquals("3", tl.getTasksAsArray()[2][0]);
		assertEquals("name3", tl.getTasksAsArray()[2][1]);
		assertEquals("4", tl.getTasksAsArray()[3][0]);
		assertEquals("name4", tl.getTasksAsArray()[3][1]);
	}
	/**
	 * Tests that the compareTo method works correctly
	 */
	@Test
	public void testCompareTo() {
		TaskList alist = new TaskList("alist", 2);
		TaskList blist = new TaskList("blist", 2);
		TaskList alist2 = new TaskList("alist", 2);
		assertEquals(0, alist.compareTo(alist2));
		assertEquals(-1, alist.compareTo(blist));
		assertEquals(1, blist.compareTo(alist));
	}
}
