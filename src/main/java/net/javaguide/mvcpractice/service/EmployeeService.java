package net.javaguide.mvcpractice.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import net.javaguide.mvcpractice.model.*;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
	
	List<Employee> returnEmployeeByName(String name);
}
