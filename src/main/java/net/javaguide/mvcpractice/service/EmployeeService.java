package net.javaguide.mvcpractice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import net.javaguide.mvcpractice.model.*;

@Service
public interface EmployeeService {
	//fetch all employees in the database
	List<Employee> getAllEmployees();
	
	//saving the employee object in the database
	void saveEmployee(Employee employee);
	
	//fetching one employee using the id
	Employee getEmployeeById(String id);
	
	//deleting the employee in the database
	void deleteEmployeeById(String id);
	
	//returns a list of employees that were searched by name
	List<Employee> returnEmployeeByName(String name);
}
