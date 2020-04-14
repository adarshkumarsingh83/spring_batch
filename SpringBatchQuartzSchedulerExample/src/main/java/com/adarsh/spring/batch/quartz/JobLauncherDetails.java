package com.adarsh.spring.batch.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class JobLauncherDetails extends QuartzJobBean {

    private static final Logger LOGGER=Logger.getLogger(JobLauncherDetails.class);

	private static final String JOB_NAME = "jobName";

	private JobLocator jobLocator;

	private JobLauncher jobLauncher;

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	@SuppressWarnings("unchecked")
	protected void executeInternal(JobExecutionContext context) {

        final Map<String, Object> jobDataMap = context.getMergedJobDataMap();
        final String jobName = (String) jobDataMap.get(JOB_NAME);
		final JobParameters jobParameters = getJobParametersFromJobMap(jobDataMap);
		try {
			jobLauncher.run(jobLocator.getJob(jobName), jobParameters);
		} catch (JobExecutionException e) {
            LOGGER.error(e);
		}
	}

	//get params from jobDataAsMap property, job-quartz.xml
	private JobParameters getJobParametersFromJobMap(Map<String, Object> jobDataMap) {
		final JobParametersBuilder builder = new JobParametersBuilder();
		for (Entry<String, Object> entry : jobDataMap.entrySet()) {
			final String key = entry.getKey();
			final Object value = entry.getValue();
			if (value instanceof String && !key.equals(JOB_NAME)) {
				builder.addString(key, (String) value);
			} else if (value instanceof Float || value instanceof Double) {
				builder.addDouble(key, ((Number) value).doubleValue());
			} else if (value instanceof Integer || value instanceof Long) {
				builder.addLong(key, ((Number) value).longValue());
			} else if (value instanceof Date) {
				builder.addDate(key, (Date) value);
			} else {
				// JobDataMap contains values which are not job parameters
				// (ignoring)
               LOGGER.info("JobDataMap contains values which are not job parameter");
			}
		}
		//need unique job parameter to rerun the same job
		builder.addDate("run date", new Date());
		return builder.toJobParameters();
	}

}