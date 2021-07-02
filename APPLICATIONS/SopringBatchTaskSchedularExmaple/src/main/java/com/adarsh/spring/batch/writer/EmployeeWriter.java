package com.adarsh.spring.batch.writer;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adarsh on 4/18/15.
 */
@Service
public class EmployeeWriter implements ItemWriter<Employee> {

    private static final Logger LOGGER = Logger.getLogger(EmployeeWriter.class);

    @Override
    public void write(List<? extends Employee> employees) throws Exception {
        LOGGER.info(employees.size());
        for(Employee employee : employees){
            LOGGER.info("==>  " + employee);
        }
    }
}