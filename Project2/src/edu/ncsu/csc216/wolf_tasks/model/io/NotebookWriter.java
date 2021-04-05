package edu.ncsu.csc216.wolf_tasks.model.io;
import java.io.File;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * The NotebookWriter class holds the functionality for writing Notebook information to a given file
 * @author rsthoma5
 *
 */
public class NotebookWriter {
	/**
	 * Saves a Notebook with the given name and list of TaskLists to the given File
	 * @param filename the file to save the Notebook to
	 * @param notebookName the name of the Notebook that's being saved
	 * @param taskLists the list of taskLists to give the Notebook thats being saved
	 */
	public static void writeNotebookFile(File filename, String notebookName, ISortedList<TaskList> taskLists) {
		
	}
}
