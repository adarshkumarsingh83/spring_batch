package com.adarsh.spring.batch.convertor;

import com.adarsh.spring.batch.model.Employee;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeConverter implements Converter {

    private final static Logger LOGGER = Logger.getLogger(EmployeeConverter.class);

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Employee.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        final Employee employee = new Employee();

        //get attribute
        employee.setEmpId(Integer.valueOf(reader.getAttribute("empId")));
        reader.moveDown();

        final String firstName = reader.getValue();
        employee.setFirstName(firstName);
        reader.moveUp();
        reader.moveDown();

        final String middleName = reader.getValue();
        employee.setMiddleName(middleName);
        reader.moveUp();
        reader.moveDown();

        final String lastName = reader.getValue();
        employee.setLastName(lastName);
        reader.moveUp();
        reader.moveDown();

        Date dob = null;
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(reader.getValue());
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        employee.setDob(dob);
        reader.moveUp();
        reader.moveDown();

        final String empEmail = reader.getValue();
        employee.setEmpEmail(empEmail);
        reader.moveUp();
        reader.moveDown();

        final String empPhone = reader.getValue();
        employee.setEmpPhone(empPhone);
        reader.moveUp();
        LOGGER.info(" :==> " + employee);
        return employee;

    }


}