package com.adarsh.spring.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    final private static Logger LOGGER=Logger.getLogger(ApplicationMain.class);
	public static void main(String[] args) {
		final String[] springConfig  = {"configuration/applicationContext.xml"};
		final ApplicationContext context =
				new ClassPathXmlApplicationContext(springConfig);
		final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		final Job job = (Job) context.getBean("employeeJob");
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
            LOGGER.info("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
            LOGGER.error(e);
		}
        LOGGER.info("Done");
	}
}
