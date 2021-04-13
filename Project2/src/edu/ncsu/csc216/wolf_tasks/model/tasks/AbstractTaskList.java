package edu.ncsu.csc216.wolf_tasks.model.tasks;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * The AbstractTaskList class holds a taskListName, a completedCountm and a SwapList of Tasks along with
 * methods to manage the Tasks in the list
 * @author rsthoma5
 *
 */
public abstract class AbstractTaskList {
	/** The name of the TaskList */
	private String taskListName;
	/** The number of completed tasks in the list */
	private int completedCount;
	/** The list of Tasks */
	private ISwapList<Task> tasks;
	
	/**
	 * Creates a new AbstractTaskList with the given name and completedCount
	 * @param taskListName the name to set for the AbstractTaskList
	 * @param completedCount the completedCount to set for the AbstactTaskList
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		setTaskListName(taskListName);
		if(completedCount < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
		this.completedCount = completedCount;
		tasks = new SwapList<Task>();
	}
	/**
	 * Gets the name of the AbstactTaskList
	 * @return the AbstractTaskList's name
	 */
	public String getTaskListName() {
		return taskListName;
	}
	/**
	 * Sets the AbstactTaskList's name to the given String
	 * @param name the taskListName to set
	 */
	public void setTaskListName(String name) {
		if(name == null || "".equals(name.trim())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		taskListName = name;
	}
	/**
	 * Gets the ISwapList of Tasks for the AbstractTaskList
	 * @return the AbstactTaskList's Name
	 */
	public ISwapList<Task> getTasks(){
		return tasks;
	}
	/**
	 * Gets the completedCount of the AbstractTaskList
	 * @return the AbstactTaskList's completedCount
	 */
	public int getCompletedCount() {
		return completedCount;
	}
	/**
	 * Adds the given task to the AbstractTaskList's tasks
	 * @param task the task to add
	 */
	public void addTask(Task task) {
		tasks.add(task);
		task.addTaskList(this);
	}
	/**
	 * Removes and returns the task at the given index from the AbstractTaskList's tasks
	 * @param idx the index of the task to remove
	 * @return the task that was removed
	 */
	public Task removeTask(int idx) {
		return tasks.remove(idx);
	}
	/**
	 * Gets the task at the given index in the AbstractTaskList's tasks
	 * @param index the index of the Task to get
	 * @return the Task at the index in the AbstractTaskList's tasks
	 */
	public Task getTask(int index) {
		return tasks.get(index);
	}
	/**
	 * Completes the given Task in the AbstractTaskList
	 * @param task the Task to complete
	 */
	public void completeTask(Task task) {
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i) == task) {
				tasks.remove(i);
				completedCount++;
			}
		}
	}
	/**
	 * Gets the AbstractTaskList's tasks as a 2D array
	 * @return the AbstactTaskList's tasks as a 2D array
	 */
	public abstract String[][] getTasksAsArray();
}
