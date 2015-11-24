package com.adarsh.spring.batch.listener;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeItemReaderListener implements ItemReadListener<Employee> {


    private final static Logger LOGGER = Logger.getLogger(EmployeeItemReaderListener.class);

	@Override
	public void beforeRead() {
        LOGGER.info("EmployeeItemReaderListener - beforeRead");
	}

	@Override
	public void afterRead(Employee item) {
        LOGGER.info("EmployeeItemReaderListener - afterRead");
	}

	@Override
	public void onReadError(Exception ex) {
        LOGGER.info("EmployeeItemReaderListener - onReadError");
	}

}
