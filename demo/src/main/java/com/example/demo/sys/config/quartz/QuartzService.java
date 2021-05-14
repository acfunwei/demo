package com.example.demo.sys.config.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QuartzService implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private Scheduler scheduler;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
//		UrlJob urlJob = applicationContext.getBean(UrlJob.class);
		JobDetail jobDetail = JobBuilder.newJob().withIdentity("job1", "group1").ofType(UrlJob.class).build();
		Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("tirgger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?")).build();
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
