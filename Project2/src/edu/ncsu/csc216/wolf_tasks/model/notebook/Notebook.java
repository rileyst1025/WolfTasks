package edu.ncsu.csc216.wolf_tasks.model.notebook;
import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

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
	 * @throws IllegalArgumentException if the given name is null or "Active Tasks"
	 */
	public Notebook(String name) {
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		setChanged(true);
		if(name == null || "".equals(name) || name.equals(activeTaskList.getTaskListName())) {
			throw new IllegalArgumentException();
		}
		setNotebookName(name);
	}
	/**
	 * Saves the Notebook to the given file
	 * @param notebookFile the file to save to
	 */
	public void saveNotebook(File notebookFile) {
		NotebookWriter.writeNotebookFile(notebookFile, notebookName, taskLists);
		setChanged(false);
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
		this.notebookName = notebookName;
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
		this.isChanged = isChanged;
	}
	/**
	 * Adds the given TaskList to the Notebook
	 * @param taskList the TaskList to add
	 * @throws IllegalArgumentException if given taskList's name already exists or is "Active Tasks"
	 */
	public void addTaskList(TaskList taskList) {
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskList.getTaskListName().toLowerCase().equals(taskLists.get(i).getTaskListName().toLowerCase())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		if(taskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		taskLists.add(taskList);
		currentTaskList = taskList;
		getActiveTaskList();
		setChanged(true);
	}
	/**
	 * Gets the names of all the TaskLists in the Notebook in a array
	 * @return an array of all the names of all the TaskLists in the Notebook
	 */
	public String[] getTaskListsNames() {
		String[] rtn = new String[taskLists.size() + 1];
		rtn[0] = activeTaskList.getTaskListName();
		for(int i = 0; i < taskLists.size(); i++) {
			rtn[i + 1] = taskLists.get(i).getTaskListName();
		}
		return rtn;
	}
	/**
	 * Makes the order of the ActiveTaskList correct
	 */
	private void getActiveTaskList() {
		activeTaskList.clearTasks();
		for(int i = 0; i < taskLists.size(); i++) {
			for(int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if(taskLists.get(i).getTasks().get(j).isActive()) {
					activeTaskList.addTask(taskLists.get(i).getTasks().get(j));
				}
			}
		}
	}
	/**
	 * Sets the currentTaskList to the TaskList in the Notebook with the given name
	 * @param taskListName the name of the TaskList to set as the currentTaskList
	 */
	public void setCurrentTaskList(String taskListName) {
		boolean notSet = true;
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskListName.equals(taskLists.get(i).getTaskListName())) {
				currentTaskList = taskLists.get(i);
				notSet = false;
			}
		}
		if(notSet) {
			currentTaskList = activeTaskList;
		}
	}
	/**
	 * Gets the currentTaskList of the Notebook
	 * @return the Notebook's currentTaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}
	/**
	 * Sets the currentTaskList's name to the given String
	 * @param taskListName the taskListName to set for the currentTaskList
	 */
	public void editTaskList(String taskListName) {
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskListName.toLowerCase().equals(taskLists.get(i).getTaskListName().toLowerCase())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		if(currentTaskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		TaskList temp = (TaskList) currentTaskList;
		removeTaskList();
		temp.setTaskListName(taskListName);
		addTaskList(temp);
	}
	/**
	 * Removes the currentTaskList from the Notebook
	 */
	public void removeTaskList() {
		if(currentTaskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		for(int i = 0; i < taskLists.size(); i++) {
			if(currentTaskList.getTaskListName().equals(taskLists.get(i).getTaskListName())) {
				taskLists.remove(i);
			}
		}
		currentTaskList = activeTaskList;
		getActiveTaskList();
		setChanged(true);
	}
	/**
	 * Adds the given Task to the currentTaskList of the Notebook
	 * @param task the Task to add to the currentTaskList
	 */
	public void addTask(Task task) {
		if(!currentTaskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			currentTaskList.addTask(task);
			if(task.isActive()) {
				getActiveTaskList();
			}
			setChanged(true);
		}
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
		if(!currentTaskList.getTaskListName().equals(activeTaskList.getTaskListName())) {
			currentTaskList.getTask(idx).setTaskName(taskName);
			currentTaskList.getTask(idx).setTaskDescription(taskDescription);
			currentTaskList.getTask(idx).setRecurring(recurring);
			currentTaskList.getTask(idx).setActive(active);
			getActiveTaskList();
			setChanged(true);
		}
	}
}
