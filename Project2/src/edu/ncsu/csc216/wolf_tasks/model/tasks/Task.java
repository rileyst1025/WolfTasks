package edu.ncsu.csc216.wolf_tasks.model.tasks;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * The Task class represents a task and holds a taskName, taskDescription, and checkers to if the task is recurring or not as well
 * as methods for editing, completing, and cloning a task
 * @author rsthoma5
 *
 */
public class Task implements Cloneable {
	/** The name of the task */
	private String taskName;
	/** The description of the task */
	private String taskDescription;
	/** Checker to see if task is recurring */
	private boolean recurring;
	/** Checker to see if task is active */
	private boolean active;
	/** The task list the task is a part of */
	private ISwapList<AbstractTaskList> taskLists;
	
	/**
	 * Creates a task with the given parameters and an empty SwapLists of AbstractTaskLists
	 * @param taskName the name of the task to set
	 * @param taskDetails the details of the task to set
	 * @param recurring checker for if the task is recurring or not
	 * @param active check for if the task is active or not
	 */
	public Task(String taskName, String taskDetails, boolean recurring, boolean active) {
		setTaskName(taskName);
		setTaskDescription(taskDetails);
		setRecurring(recurring);
		setActive(active);
		taskLists = new SwapList<AbstractTaskList>();
	}
	
	/**
	 * Gets the name of the task
	 * @return the task's name
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Sets the task name to the given string
	 * @param taskName the task name to set
	 * @throws IllegalArgumentException if given name is null or empty
	 */
	public void setTaskName(String taskName) {
		if(taskName == null || "".equals(taskName)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
	}
	
	/**
	 * Gets the description of the task
	 * @return the task's description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Sets the description of the task to the given string
	 * @param taskDescription the task description to set
	 */
	public void setTaskDescription(String taskDescription) {
		if(taskDescription == null || "".equals(taskDescription)) {
			throw new IllegalArgumentException("Incomplete task information");
		}
		this.taskDescription = taskDescription;
	}
	
	/**
	 * Gets the recursive status of the task
	 * @return true if task is recurring, false otherwise
	 */
	public boolean isRecurring() {
		return recurring;
	}
	
	/**
	 * Sets the recursive status of the task to the given boolean
	 * @param recurring the recursive status to set
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}
	
	/**
	 * Gets the active status of the task
	 * @return true if task is active, false otherwise
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Sets the active status to the given boolean
	 * @param active the active status to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Gets the name of the TaskList the Task belongs to
	 * @return the name of the task's TaskList
	 */
	public String getTaskListName() {
		if(taskLists.size() == 0 || taskLists.get(0) == null) {
			return "";
		}
		return taskLists.get(0).getTaskListName();
	}
	
	/**
	 * Adds a taskList to the Task's list of taskLists
	 * @param taskList the taskList to add
	 */
	public void addTaskList(AbstractTaskList taskList) {
		if(taskList == null) {
			throw new IllegalArgumentException("Invalid task information");
		}
		boolean notDuplicate = true;
		for(int i = 0; i < taskLists.size(); i++) {
			if (taskList.equals(taskLists.get(i))) {
				notDuplicate = false;
			}
		}
		if(notDuplicate) {
			taskLists.add(taskList);
		}
	}
	
	/**
	 * Completes the Task
	 */
	public void completeTask() {
		for(int i = 0; i < taskLists.size(); i++) {
			taskLists.get(i).completeTask(this);
			if(recurring) {
				try {
					taskLists.get(i).addTask(this.clone());
				} catch(CloneNotSupportedException e) {
					throw new IllegalArgumentException("Cannot clone.");
				}
			}
		}
	}
	
	/**
	 * Clones the task
	 * @return the cloned task
	 * @throws CloneNotSupportedException if there are no AbstractTaskLists registered with the task
	 */
	public Task clone() throws CloneNotSupportedException {
		if(taskLists.size() == 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		Task cloneTask = new Task(taskName, taskDescription, recurring, active);
		for(int i = 0; i < taskLists.size(); i++) {
			cloneTask.addTaskList(taskLists.get(i));
		}
		return cloneTask;
	}
	
	/**
	 * Returns comma seperated list of the Task information
	 * @return the Task's info 
	 */
	public String toString() {
		String rtn = "* " + taskName;
		if(recurring) {
			rtn += ",recurring";
		}
		if(active) {
			rtn += ",active";
		}
		rtn += "\n" + taskDescription;
		return rtn;
	}
}
