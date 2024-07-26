package queue;

import java.util.PriorityQueue;
// Time Complexity
// PriortyQueue
// O(log(n)) - offer, poll, remove(), add
// O(n) - remove(Object) and contains(Object)
// O(1) - peek, element, size
// Space Complexity
// O(n) - only as long as the queue itself 

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Task> todoList = new PriorityQueue<>();
		todoList.add(new Task("Write report",3));
		todoList.add(new Task("Go to HOA meeting",9));
		todoList.add(new Task("Take daughter to cheer camp",5));
		todoList.add(new Task("Pay internet bill",1));
		
		while(!todoList.isEmpty()) {
			System.out.println(todoList.poll().getDetails());
		}
	}

}

class Task implements Comparable<Task> {
	private String description;
	private int priority;
	
	public Task() {	}
	
	public Task(String desc, int priority) {
		this.description = desc;
		this.priority = priority;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Task setDescription(String desc) {
		this.description = desc;
		return this;
	}
	
	public Task setPriority(int priority) {
		this.priority = priority;
		return this;
	}
	
	public String getDetails() {
		return this.priority + ". " + this.description + ". ";
	}
	
	@Override
	public int compareTo(Task o) {
		return Integer.compare(this.priority, o.priority);
	}
	
}
