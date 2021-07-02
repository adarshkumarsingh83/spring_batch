package com.adarsh.spring.batch.schedular;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeBatchScheduler {

    private static final Logger LOGGER = Logger.getLogger(EmployeeBatchScheduler.class);

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    public void execute() {
        try {
            final String dateParam = new Date().toString();
            final JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            LOGGER.info(dateParam);
            final JobExecution execution = jobLauncher.run(job, param);
            LOGGER.info("Exit Status : " + execution.getStatus());
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}