package com.adarsh.spring.batch.listener;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeItemWriterListener implements ItemWriteListener<Employee> {

    private final static Logger LOGGER = Logger.getLogger(EmployeeItemWriterListener.class);

	@Override
	public void beforeWrite(List<? extends Employee> items) {
		LOGGER.info("EmployeeItemWriterListener - beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Employee> items) {
		LOGGER.info("EmployeeItemWriterListener - afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Employee> items) {
		LOGGER.info("EmployeeItemWriterListener - onWriteError");
	}

}
