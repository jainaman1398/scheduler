package com.wingify.scheduler;


import com.wingify.scheduler.job.ByeJob;
import com.wingify.scheduler.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyApp {

	public static void main(String[] args) {
		/*try {
			JobDetail job1 = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
					.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build();   
			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
			scheduler1.start(); 
			scheduler1.scheduleJob(job1, trigger1); 
			
			JobDetail job2 = JobBuilder.newJob(ByeJob.class).withIdentity("byeJob", "group2").build();
			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
			scheduler2.start(); 
			scheduler2.scheduleJob(job2, trigger2); 
			}
		catch(Exception e){ 
			e.printStackTrace();
		}*/

		try {
			JobDetail job1 = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1")
					.usingJobData("jobSays", "Hello World!")
					.usingJobData("myFloatValue", 3.141f).build();

			JobDetail job2 = JobBuilder.newJob(ByeJob.class).withIdentity("ByeJob", "group2")
					.build();

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
					.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(1)).build();

			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group2")
					.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(1)).build();



			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();

			scheduler1.scheduleJob( job1,trigger1);
			scheduler1.scheduleJob( job2,trigger2);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
