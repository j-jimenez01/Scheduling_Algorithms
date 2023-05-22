/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

// Your code here
public class RR implements Algorithm{
	List<Task> schedule;
	int tq = 10;
	int pos = 0;
	CPU cpu;
	Task task;
	Task task2;
	
	public RR(List<Task> queue){
		schedule = queue;
	}
	public void schedule(){
		//keeps grabbing the task until the list is empty and displaying the task once it grabs the list
		while(schedule.size()>0){
			task = pickNextTask();
			cpu.run(task,task.getBurst());
			if(task.getBurst()==0){
				System.out.println("Task "+task.getName()+" Finished\n");
			}
		}
	}
	public Task pickNextTask(){
		//getting the current position cpu burst time and checking if the cpu burst time is <= to the time quantum. If so, we set it equal to 0 and remove it from the schedule and if not then we subtract the cpu burst time by the time quantum and if we are at the end of the schedule, we reset it back to 0 so it starts at the begining of the schedule with the task that are left
		task2 = schedule.get(pos);
		if(task2.getBurst() <= tq){
			task2.setBurst(0);
			schedule.remove(task2);
		}
		else{
			task2.setBurst(task2.getBurst() - tq);
			pos += 1;
			if (pos > schedule.size() - 1){
				pos = 0;
			}
		}
		return task2;
	}



		
}//end of the class