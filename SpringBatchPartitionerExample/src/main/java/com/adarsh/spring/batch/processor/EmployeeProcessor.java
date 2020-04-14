package com.adarsh.spring.batch.processor;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemProcessor")
@Scope(value = "step")
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

    private final static Logger LOGGER = Logger.getLogger(EmployeeProcessor.class);

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	@Override
	public Employee process(Employee employee) throws Exception {
        LOGGER.info(threadName + " processing :====>  " +employee );
		return employee;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
