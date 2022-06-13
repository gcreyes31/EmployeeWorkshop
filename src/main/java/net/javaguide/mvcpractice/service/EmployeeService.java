package net.javaguide.mvcpractice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import net.javaguide.mvcpractice.model.*;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(UUID id);
	
	void deleteEmployeeById(UUID id);
	
	List<Employee> returnEmployeeByName(String name);
}
