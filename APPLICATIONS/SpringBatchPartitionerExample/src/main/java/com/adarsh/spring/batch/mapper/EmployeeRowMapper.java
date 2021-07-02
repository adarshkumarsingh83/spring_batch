package com.adarsh.spring.batch.mapper;

import com.adarsh.spring.batch.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Adarsh on 4/17/15.
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    private final static Logger LOGGER = Logger.getLogger(EmployeeRowMapper.class);

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Employee employee = new Employee();
        employee.setEmpId(resultSet.getInt("empId"));
        employee.setFirstName(resultSet.getNString("firstName"));
        employee.setMiddleName(resultSet.getString("middleName"));
        employee.setLastName(resultSet.getString("lastName"));
        employee.setEmpEmail(resultSet.getString("empEmail"));
        employee.setEmpPhone(resultSet.getString("empPhone"));
        employee.setDob(resultSet.getDate("dob"));
        LOGGER.info(":==> " + employee);
        return employee;
    }
}
