/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

// Your code here
public class Priority implements Algorithm{
	List<Task> schedule;
  List<Task> check = new ArrayList<Task>();
	CPU cpu;
	int time;
	int pri;
	Task task;
	Task task2;
	
	public Priority(List<Task> queue){
			schedule = queue;
	}
	
	public void schedule(){
		//calling all of the task and keeps repeating till the schedule list is empty. Does this because it gets a task, then the displays it, then removes it so it cant be called again
    for(int i =0; i < schedule.size();i++){
				task = pickNextTask();
				time = task.getBurst();
				cpu.run(task,time);
			}
	}
	
	public Task pickNextTask(){
		//getting the priority of the task by finding which one is the least
		pri=100000;
		for(Task t: schedule){
			if(t.getPriority()<pri && !check.contains(t)){
				pri = t.getPriority();
				task2 = t;
			}
		}
    check.add(task2);
		return task2;
	}
}//end of the class