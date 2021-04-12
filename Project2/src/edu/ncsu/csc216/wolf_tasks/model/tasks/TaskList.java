package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * The TaskList class is a subclass of AbstractTaskList and has added functionality to display the tasks in the list as well for comparing TaskLists
 * @author rsthoma5
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {
	
	/**
	 * Creates a new TaskList with the given taskListName and completedCount
	 * @param taskListName the taskListName to set
	 * @param completedCount the completedCount to set
	 */
	public TaskList(String taskListName, int completedCount) {
		super(taskListName, completedCount);
	}
	/**
	 * Gets the TaskList's tasks as a 2D array
	 * @return the TaskList's tasks as a 2D array
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] rtn = new String[getTasks().size()][2];
		for(int i = 0; i < getTasks().size(); i++) {
			rtn[i][0] = String.valueOf(i + 1);
			rtn[i][1] = getTasks().get(i).getTaskName();
		}
		return rtn;
	}
	/**
	 * Compares the names of the TaskLists
	 * @param list the TaskList to compare the TaskList to
	 * @return -1 if the given TaskList's name if more than the TaskList, 1 if the opposite is true, and 0 if they are the same name
	 */
	@Override
	public int compareTo(TaskList list) {
		return this.getTaskListName().compareTo(list.getTaskListName());
	}
}
