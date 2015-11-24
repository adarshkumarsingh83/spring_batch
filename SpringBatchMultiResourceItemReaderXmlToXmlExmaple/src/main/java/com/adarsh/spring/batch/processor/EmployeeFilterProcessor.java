package com.adarsh.spring.batch.processor;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeFilterProcessor implements ItemProcessor<Employee, Employee> {

    private final static Logger LOGGER = Logger.getLogger(EmployeeFilterProcessor.class);

	@Override
	public Employee process(Employee employee) throws Exception {
        LOGGER.info(":==> "+employee.toString());
        return employee;
	}

}