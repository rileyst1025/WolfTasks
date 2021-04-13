package edu.ncsu.csc216.wolf_tasks.model.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
		Notebook rtn;
		try {
			Scanner fileReader = new Scanner(filename);
			String fileinfo = "";
			while (fileReader.hasNextLine()) {
				fileinfo += fileReader.nextLine() + "\n";
			}
			fileinfo.trim();
			if(fileinfo.charAt(0) != '!') {
				fileReader.close();
				throw new IllegalArgumentException("Unable to load file.");
			}
			rtn = new Notebook(fileinfo.substring(1, fileinfo.indexOf("/n")));
			String[] taskListTokens = fileinfo.split("\\r?\\n[#]");
			String[] newTokens = new String[taskListTokens.length - 1];
			for(int i = 0; i < newTokens.length; i++) {
				newTokens[i] = taskListTokens[i + 1];
			}
			taskListTokens = newTokens;
			for(int i = 0; i < taskListTokens.length; i++) {
				String[] taskTokens = taskListTokens[i].split("\\r?\\n[*]");
				rtn.addTaskList(processTaskList(taskTokens[0]));
				for(int j = 1; j < taskTokens.length; j++) {
					processTask(rtn.getCurrentTaskList(), taskTokens[j]);
				}
			}
			fileReader.close();
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		} catch(IllegalArgumentException x) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		return rtn;
	}
	/**
	 * Gets a TaskList from the information in the given String
	 * @param line the line of text with the TaskList information
	 * @return the TaskList created from the line information
	 */
	private static TaskList processTaskList(String line) {
		String[] taskListParams = line.split(",");
		TaskList rtn = new TaskList(taskListParams[0].substring(1), Integer.parseInt(taskListParams[1]));
		return rtn;
	}
	/**
	 * Gets a Task from the given String and adds it to the given TaskList
	 * @param list the list to add the Task to
	 * @param line the line of information to get the Task from
	 * @return the Task created from the given line
	 * @throws IllegalArgumentException if the parameters for the task are invalid
	 */
	private static Task processTask(AbstractTaskList list, String line) {
		Task rtn;
		String[] taskDetails = line.split("/n");
		String[] taskParams = taskDetails[0].split(",");
		String taskDescription = "";
		for(int i = 1; i < taskDetails.length; i++) {
			taskDescription += taskDetails[i] + "/n";
		}
		if(taskParams.length == 1) {
			rtn = new Task(taskParams[0].substring(1), taskDescription, false, false);
		}
		else if(taskParams.length == 2 && "recurring".equals(taskParams[1])) {
			rtn = new Task(taskParams[0].substring(1), taskDescription, true, false);
		}
		else if(taskParams.length == 2 && "active".equals(taskParams[1])) {
			rtn = new Task(taskParams[0].substring(1), taskDescription, false, true);
		}
		else if(taskParams.length == 3 && "recurring".equals(taskParams[1]) && "active".equals(taskParams[2])) {
			rtn = new Task(taskParams[0].substring(1), taskDescription, true, true);
		}
		else {
			throw new IllegalArgumentException();
		}
		return rtn;
	}
}
