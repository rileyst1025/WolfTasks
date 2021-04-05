package edu.ncsu.csc216.wolf_tasks.model.notebook;
import java.io.File;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * The Notebook class has a notebookName, a list of taskLists, an active task list, a current task list, and a method for adding,
 * removing, and editing Tasks and TaskLists
 * @author rsthoma5
 *
 */
public class Notebook {
	/** The list of TaskLists in the notebook */
	private ISortedList<TaskList> taskLists;
	/** The activeTaskList in the notebook */
	private ActiveTaskList activeTaskList;
	/** The current TaskList of the notebook */
	private AbstractTaskList currentTaskList;
	/** The name of the notebook */
	private String notebookName;
	/** Keeps track of if the notebook has been changed since its been saved */
	private boolean isChanged;
	
	/**
	 * Creates a new Notebook with the given notebookName, empty tasks and tasklists, and a true isChanged
	 * @param name the notebookName to set
	 */
	public Notebook(String name) {
		
	}
	/**
	 * Saves the Notebook to the given file
	 * @param notebookFile the file to save to
	 */
	public void saveNotebook(File notebookFile) {
		
	}
	/**
	 * Gets the notebookName of the Notebook
	 * @return the Notebook's notebookName
	 */
	public String getNotebookName() {
		return notebookName;
	}
	/**
	 * Sets the notebookName to the given String
	 * @param notebookName the notebookName to set
	 */
	private void setNotebookName(String notebookName) {
		
	}
	/**
	 * Gets whether or not the Notebook has been changed since its been last saved
	 * @return true if the notebook has been changed, false if it hasn't
	 */
	public boolean isChanged() {
		return isChanged;
	}
	/**
	 * Sets the changed status to the given boolean variable
	 * @param isChanged the changed status to set
	 */
	public void setChanged(boolean isChanged) {
		
	}
	/**
	 * Adds the given TaskList to the Notebook
	 * @param taskList the TaskList to add
	 */
	public void addTaskList(TaskList taskList) {
		
	}
	/**
	 * Gets the names of all the TaskLists in the Notebook in a array
	 * @return an array of all the names of all the TaskLists in the Notebook
	 */
	public String[] getTaskListsNames() {
		return null;
	}
	/**
	 * Makes the order of the ActiveTaskList correct
	 */
	private void getActiveTaskList() {
		
	}
	/**
	 * Sets the currentTaskList to the TaskList in the Notebook with the given name
	 * @param taskListName the name of the TaskList to set as the currentTaskList
	 */
	public void setCurrentTaskList(String taskListName) {
		
	}
	/**
	 * Gets the currentTaskList of the Notebook
	 * @return the Notebook's currentTaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	/**
	 * Sets the currentTaskList's name to the given String
	 * @param taskListName the taskListName to set for the currentTaskList
	 */
	public void editTaskList(String taskListName) {
		
	}
	/**
	 * Removes the currentTaskList from the Notebook
	 */
	public void removeTaskList() {
		
	}
	/**
	 * Adds the given Task to the currentTaskList of the Notebook
	 * @param task the Task to add to the currentTaskList
	 */
	public void addTask(Task task) {
		
	}
	/**
	 * Updates the info of the Task at the given index of the currentTaskList with the given name, description, recurring status, and active status
	 * @param idx the index of the Task to change
	 * @param taskName the taskName to give the Task
	 * @param taskDescription the taskDescription to give the Task
	 * @param recurring the recurring status to give the Task
	 * @param active the active status to give the Task
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		
	}
}
