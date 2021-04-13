package edu.ncsu.csc216.wolf_tasks.model.io;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;

/**
 * The NotebookReaderTest class tests the NotebookReader class's ability to correctly read in Notebook information from a file
 * @author rsthoma5
 *
 */
public class NotebookReaderTest {
	/**
	 * Tests that readNotebookFile correctly reads a Notebook from a file
	 */
	@Test
	public void testReadNotebookFile() {
		File nameonlyFile = new File("test-files/notebook0.txt");
		File threelistFile = new File("test-files/notebook1.txt");
		File missingitemsFile = new File("test-files/notebook2.txt");
		File errorFile = new File("test-files/notebook3.txt");
		File nocountlistFile = new File("test-files/notebook4.txt");
		File nonamelistFile = new File("test-files/notebook5.txt");
		File noneglistFile = new File("test-files/notebook6.txt");
		File invalidtaskFile = new File("test-files/notebook7.txt");
		Notebook n = NotebookReader.readNodebookFile(nameonlyFile);
		assertEquals("Summer Plans", n.getNotebookName());
		n = NotebookReader.readNodebookFile(threelistFile);
		assertEquals("School", n.getNotebookName());
		assertEquals("CSC 216", n.getTaskListsNames()[1]);
		assertEquals("CSC 226", n.getTaskListsNames()[2]);
		assertEquals("Habits", n.getTaskListsNames()[3]);
		n.setCurrentTaskList("CSC 216");
		assertEquals(35, n.getCurrentTaskList().getCompletedCount());
		assertEquals(9, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("CSC 226");
		assertEquals(23, n.getCurrentTaskList().getCompletedCount());
		assertEquals(5, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("Habits");
		assertEquals(0, n.getCurrentTaskList().getCompletedCount());
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
		n = NotebookReader.readNodebookFile(missingitemsFile);
		assertEquals("School", n.getNotebookName());
		assertEquals("CSC 216", n.getTaskListsNames()[1]);
		assertEquals("CSC 226", n.getTaskListsNames()[2]);
		assertEquals("Habits", n.getTaskListsNames()[3]);
		n.setCurrentTaskList("CSC 216");
		assertEquals(35, n.getCurrentTaskList().getCompletedCount());
		assertEquals(0, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("CSC 226");
		assertEquals(23, n.getCurrentTaskList().getCompletedCount());
		assertEquals(4, n.getCurrentTaskList().getTasks().size());
		n.setCurrentTaskList("Habits");
		assertEquals(0, n.getCurrentTaskList().getCompletedCount());
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
		try {
			n = NotebookReader.readNodebookFile(errorFile);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		n = NotebookReader.readNodebookFile(nocountlistFile);
		assertEquals("Personal", n.getNotebookName());
		assertEquals(1, n.getTaskListsNames().length);
		n = NotebookReader.readNodebookFile(nonamelistFile);
		assertEquals("Personal", n.getNotebookName());
		assertEquals(1, n.getTaskListsNames().length);
		n = NotebookReader.readNodebookFile(noneglistFile);
		assertEquals("Personal", n.getNotebookName());
		assertEquals(1, n.getTaskListsNames().length);
		n = NotebookReader.readNodebookFile(invalidtaskFile);
		assertEquals("Personal", n.getNotebookName());
		assertEquals("Habits", n.getTaskListsNames()[1]);
		n.setCurrentTaskList("Habits");
		assertEquals(3, n.getCurrentTaskList().getCompletedCount());
		assertEquals(1, n.getCurrentTaskList().getTasks().size());
	}
}
