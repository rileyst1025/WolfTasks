package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class TaskList extends AbstractTaskList implements Comparable<TaskList>{
	
	/**
	 * Creates a new TaskList with the given taskListName and completedCount
	 * @param taskListName the taskListName to set
	 * @param completedCount the completedCount to set
	 */
	public TaskList(String taskListName, int completedCount) {
		super(taskListName, completedCount);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Gets the TaskList's tasks as a 2D array
	 * @return the TaskList's tasks as a 2D array
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Compares the names of the TaskLists
	 * @param the TaskList to compare the TaskList to
	 * @return 1 if the given TaskList's name if more than the TaskList, -1 if the opposite is true, and 0 if they are the same name
	 */
	@Override
	public int compareTo(TaskList list) {
		// TODO Auto-generated method stub
		return 0;
	}
}
