package com.adarsh.spring.batch.mapper;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Adarsh on 4/13/15.
 */
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

    private final static Logger LOGGER = Logger.getLogger(EmployeeFieldSetMapper.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
        final Employee employee = new Employee();
        employee.setEmpId(fieldSet.readInt(0));
        employee.setFirstName(fieldSet.readString(1));
        employee.setMiddleName(fieldSet.readString(2));
        employee.setLastName(fieldSet.readString(3));
        employee.setEmpEmail(fieldSet.readString(4));
        employee.setEmpPhone(fieldSet.readString(5));
        //default format yyyy-MM-dd
        final String date = fieldSet.readString(6);
        try {
            employee.setDob(dateFormat.parse(date));
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        LOGGER.info(" :==> "+employee);
        return employee;
    }
}