/**
 * FCFS scheduling algorithm.
 */
import java.util.*;

//Your code here
public class FCFS implements Algorithm{
	
	List<Task> schedule;
	CPU cpu;
	int time;
	int i;
	Task task;
	
	public FCFS(List<Task> queue){
			schedule = queue;
	}
	public void schedule(){
		//getting the task, displaying it, and then incrementing the position so it doens't repeat. Then it will keep repeating till the current postion equals the size of the schedule
    for(i = 0; i < schedule.size();i++){
				task = pickNextTask();
				time = task.getBurst();
				cpu.run(task,time);
			}
	}
	public Task pickNextTask(){
		//gets the current task based off what position is sent to the schedule to show which was first, second, third and so on
			return schedule.get(i);
	}



		
}//end of the class