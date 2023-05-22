/**
 * PriorityRR scheduling algorithm.
 */
import java.util.*;

//Your code here
public class PriorityRR implements Algorithm{
	List<Task> schedule;
	CPU cpu;
	int p;
	Task task;
	Task task2;
	int tq = 10;
	public PriorityRR(List<Task> queue){
		 schedule = queue;
	}
	public void schedule(){
		//getting the task and then displaying it
		while(schedule.size()>0){
			task = pickNextTask();
			cpu.run(task,task.getBurst());
		}
	}//end of scheudle
	public Task pickNextTask(){
		//getting the priority task so we start of with
		//that one first 
		p=100000;
		for(Task t: schedule){
			if(t.getPriority()<p){
				p = t.getPriority();
				task2 = t;
			}
		}
		//after getting the priority task, we then perfrom RR
		//which allows us to subtract the cpu burst by 10 and check if
		//we need to keep repeating it
		if(task2.getBurst() <= tq){//removing task if burst is <= to the time quantum
			task2.setBurst(0);
		 schedule.remove(task2);
		}
		else{//if not then subtract the burst time by time quantum
			task2.setBurst(task2.getBurst() - tq);
		}
		// schedule.remove(nt);
		return task2;
	}//end of pickNextTask
}//end of the class
// Order: T6,T2,T3,T7,T1,T4,T5,T8,T2,T3,T7,T1,T4,T5,T8,T2,T3,T7,T8