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
	 * @throws IllegalArgumentException if given task is not active
	 */
	@Override
	public void addTask(Task task) {
		if(task.isActive()) {
			super.addTask(task);
		}
		else {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
	}
	/**
	 * Sets the ActiveTaskList's name to the given String if it is "Active Tasks"
	 * @param name the taskListName to set
	 * @throws IllegalArgumentException if the given name is not "Active Tasks"
	 */
	public void setTaskListName(String name) {
		if(ACTIVE_TASKS_NAME.equals(name)) {
			super.setTaskListName(name);
		}
		else {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
	}
	/**
	 * Gets the ActiveTaskList's tasks as a 2D array
	 * @return the ActiveTaskList's tasks as a 2D array
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] rtn = new String[getTasks().size()][2];
		for(int i = 0; i < getTasks().size(); i++) {
			rtn[i][0] = getTasks().get(i).getTaskListName();
			rtn[i][1] = getTasks().get(i).getTaskName();
		}
		return rtn;
	}
	/**
	 * Clears the ActiveTaskList
	 */
	public void clearTasks() {
		int size = getTasks().size();
		for(int i = 0; i < size; i++) {
			removeTask(0);
		}
	}
}
