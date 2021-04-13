package edu.ncsu.csc216.wolf_tasks.model.notebook;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * The NotebookTest class tests that all of Notebook's methods work correctly
 * @author rsthoma5
 *
 */
public class NotebookTest {
	/**
	 * Tests that the Notebook constructor works correctly
	 */
	@Test
	public void testNotebook() {
		Notebook n = new Notebook("name");
		assertEquals("name", n.getNotebookName());
		assertEquals(1, n.getTaskListsNames().length);
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		assertTrue(n.isChanged());
		try {
			n = new Notebook(null);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("name", n.getNotebookName());
		}
		try {
			n = new Notebook("");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("name", n.getNotebookName());
		}
		try {
			n = new Notebook("Active Tasks");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("name", n.getNotebookName());
		}
	}
	/**
	 * Tests that addTaskList correctly adds the given TaskList
	 */
	@Test
	public void testAddTaskList() {
		Notebook n = new Notebook("name");
		assertEquals(1, n.getTaskListsNames().length);
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		try {
			n.removeTaskList();
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		}
		TaskList t1 = new TaskList("list1", 3);
		n.addTaskList(t1);
		assertEquals("list1", n.getCurrentTaskList().getTaskListName());
		assertEquals(2, n.getTaskListsNames().length);
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		assertEquals("list1", n.getTaskListsNames()[1]);
		TaskList t2 = new TaskList("alist1", 3);
		n.addTaskList(t2);
		assertEquals("alist1", n.getCurrentTaskList().getTaskListName());
		assertEquals(3, n.getTaskListsNames().length);
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		assertEquals("alist1", n.getTaskListsNames()[1]);
		assertEquals("list1", n.getTaskListsNames()[2]);
		n.removeTaskList();
		assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		assertEquals(2, n.getTaskListsNames().length);
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		assertEquals("list1", n.getTaskListsNames()[1]);
		TaskList t3 = new TaskList("list1", 3);
		try {
			n.addTaskList(t3);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		t3 = new TaskList("Active Tasks", 3);
		try {
			n.addTaskList(t3);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
	}
	/**
	 * Tests that editTaskList correctly edits the currentTaskList
	 */
	@Test
	public void testEditTaskList() {
		Notebook n = new Notebook("name");
		try {
			n.editTaskList("newName");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		}
		TaskList t1 = new TaskList("oname", 2);
		n.addTaskList(t1);
		assertEquals("oname", n.getCurrentTaskList().getTaskListName());
		n.editTaskList("newName");
		assertEquals("newName", n.getCurrentTaskList().getTaskListName());
		TaskList t2 = new TaskList("2name", 2);
		n.addTaskList(t2);
		try {
			n.editTaskList("NewName");
		} catch(IllegalArgumentException e) {
			assertEquals("2name", n.getCurrentTaskList().getTaskListName());
		}
	}
	/**
	 * Tests that addTask correctly adds a test to the currentTaskList
	 */
	@Test
	public void testAddTask() {
		Notebook n = new Notebook("name");
		Task t1 = new Task("name1", "description1", false, true);
		Task t2 = new Task("name2", "description2", false, false);
		n.addTask(t1);
		assertEquals(0, n.getCurrentTaskList().getTasks().size());
		TaskList tl1 = new TaskList("oname", 2);
		n.addTaskList(tl1);
		n.addTask(t1);
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("Active Tasks");
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("oname");
		n.addTask(t2);
		assertEquals(2, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("Active Tasks");
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
	}
	/**
	 * Tests that editTask correctly edits the correct task in the currentTaskList
	 */
	@Test
	public void testEditTask() {
		Notebook n = new Notebook("name");
		Task t1 = new Task("name1", "description1", false, true);
		Task t2 = new Task("name2", "description2", false, false);
		TaskList tl1 = new TaskList("oname", 2);
		n.addTaskList(tl1);
		n.addTask(t1);
		n.editTask(0, "name1", "dsecription1", false, false);
		n.setCurrentTaskList("Active Tasks");
		assertEquals(0, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("oname");
		n.addTask(t2);
		n.editTask(1, "name1", "dsecription1", false, true);
		n.setCurrentTaskList("Active Tasks");
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
	}
}