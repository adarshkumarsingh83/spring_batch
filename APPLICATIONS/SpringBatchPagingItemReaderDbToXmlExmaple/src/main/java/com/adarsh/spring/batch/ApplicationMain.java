package com.adarsh.spring.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    private final static Logger LOGGER = Logger.getLogger(ApplicationMain.class);

    public static void main(String[] args) {

        final String[] springConfig = {"configuration/applicationContext.xml"};
        final ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
        final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        final Job job = (Job) context.getBean("employeeJob");
        try {
            final JobParameters param = new JobParametersBuilder().addString("MIDDLENAME", "KUMAR").toJobParameters();
            final JobExecution execution = jobLauncher.run(job, param);
            LOGGER.info("Exit Status : " + execution.getStatus());
            LOGGER.info("Exit Status : " + execution.getAllFailureExceptions());
        } catch (Exception e) {
            LOGGER.error(e);
        }
        LOGGER.info("Done");
    }
}
