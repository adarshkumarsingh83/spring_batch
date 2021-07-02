package com.adarsh.spring.batch.processor;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Adarsh on 4/13/15.
 */
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {


    private final static Logger LOGGER = Logger.getLogger(EmployeeItemProcessor.class);
    @Override
    public Employee process(Employee employee) throws Exception {
        LOGGER.info("EmployeeItemProcessor..." + employee);
        return employee;
    }

}