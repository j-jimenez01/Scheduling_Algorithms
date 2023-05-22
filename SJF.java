/**
 * SJF scheduling algorithm.
 */
import java.util.*;

//Your code here
public class SJF implements Algorithm{
	
	List<Task> schedule;
  List<Task> check = new ArrayList<Task>();
	CPU cpu;
	int time;
	int burst;
	Task task;
	Task task2;
	
	public SJF(List<Task> queue){
			schedule = queue;
	}
	public void schedule(){
			for(int i =0; i < schedule.size();i++){
				task = pickNextTask();
				time = task.getBurst();
				cpu.run(task,time);
			}
	}
	
	public Task pickNextTask(){
    burst=100000;
		for(Task t: schedule){
			if(t.getBurst()<burst && !check.contains(t)){
				burst = t.getBurst();
				task2 = t;
			}
		}
    check.add(task2);
		return task2;
	}

}//end of the class