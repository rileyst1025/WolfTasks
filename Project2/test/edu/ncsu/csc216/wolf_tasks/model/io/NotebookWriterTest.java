package edu.ncsu.csc216.wolf_tasks.model.io;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * The NotebookWriterTest class tests that the NotebookWriter class can correctly write a Notebook's information to a file
 * @author rsthoma5
 *
 */
public class NotebookWriterTest {
	/**
	 * Tests that writeNotebookFile correctly writes a Notebook to the correct file
	 */
	@Test
	public void testWriteNotebookFile() {
		File outputFile = new File("test-files/actual_output.txt");
		Notebook n = new Notebook("Notebook");
		TaskList aTaskList = new TaskList("ATaskList", 0);
		n.addTaskList(aTaskList);
		TaskList tasks1 = new TaskList("Tasks1", 0);
		Task task1 = new Task("Task1", "Task1Description", true, false);
		tasks1.addTask(task1);
		Task task2 = new Task("Task2", "Task2Description", true, true);
		tasks1.addTask(task2);
		n.addTaskList(tasks1);
		TaskList tasks2 = new TaskList("Tasks2", 0);
		Task task3 = new Task("Task3", "Task3Description", false, false);
		tasks2.addTask(task3);
		Task task4 = new Task("Task4", "Task4Description", false, true);
		tasks2.addTask(task4);
		Task task5 = new Task("Task5", "Task5Description", true, false);
		tasks2.addTask(task5);
		n.addTaskList(tasks2);
		n.saveNotebook(outputFile);
		checkFiles("test-files/expected_out.txt", "test-files/actual_output.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
