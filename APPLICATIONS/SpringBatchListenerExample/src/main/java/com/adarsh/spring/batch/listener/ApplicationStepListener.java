package com.adarsh.spring.batch.listener;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStepListener implements StepExecutionListener {

    private final static Logger LOGGER = Logger.getLogger(ApplicationStepListener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("ApplicationStepListener - beforeStep");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("ApplicationStepListener - afterStep");
		return null;
	}

}