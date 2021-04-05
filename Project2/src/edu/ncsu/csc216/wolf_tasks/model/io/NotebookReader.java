package edu.ncsu.csc216.wolf_tasks.model.io;
import java.io.File;
import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * The NotebookReader class holds the functionality for creating a Notebook out of the information in a given file
 * @author rsthoma5
 *
 */
public class NotebookReader {
	/**
	 * Gets a notebook from the given file
	 * @param filename the file to get the notebook from
	 * @return the Notebook created from the file information
	 */
	public static Notebook readNodebookFile(File filename) {
		return null;
	}
	/**
	 * Gets a TaskList from the information in the given String
	 * @param line the line of text with the TaskList information
	 * @return the TaskList created from the line information
	 */
	private static TaskList processTaskList(String line) {
		return null;
	}
	/**
	 * Gets a Task from the given String and adds it to the given TaskList
	 * @param list the list to add the Task to
	 * @param line the line of information to get the Task from
	 * @return the Task created from the given line
	 */
	private static Task processTask(AbstractTaskList list, String line) {
		return null;
	}
}
