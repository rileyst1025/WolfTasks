package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * The ActiveTaskList class is a subclass of AbstractTaskList that holds tasks marks as active with the taskListName "Active Tasks"
 * @author rsthoma5
 *
 */
public class ActiveTaskList extends AbstractTaskList {
	/** The name for ActiveTaskList */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
	
	/**
	 * Creates an ActiveTaskList with the name Active Tasks and the given completedCount
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}
	/**
	 * Adds the given task to the AbstractTaskList's tasks
	 * @param task the task to add
	 */
	@Override
	public void addTask(Task task) {
		
	}
	/**
	 * Sets the ActiveTaskList's name to the given String if it is "Active Tasks"
	 * @param name the taskListName to set
	 */
	public void setTaskListName(String name) {
		
	}
	/**
	 * Gets the ActiveTaskList's tasks as a 2D array
	 * @return the ActiveTaskList's tasks as a 2D array
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Clears the ActiveTaskList
	 */
	public void clearTasks() {
		
	}
}
