package net.javaguide.mvcpractice.service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguide.mvcpractice.model.Employee;
import net.javaguide.mvcpractice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	//Since the Service interacts with the database, the service will use dependency injection,
	//injecting the repository class into this service class
	@Autowired
	private EmployeeRepository emprepo;
	
	//JPA syntax to find all items in the table
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}
	
	//JPA syntax to save the object into the database
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.emprepo.save(employee);
	}

	//JPA syntax to find the object in the database using the id parameter
	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = emprepo.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()){
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee " + " not found.");
		}
			
		return employee;
	}

	//JPA syntax to remove the object from the database
	@Override
	public void deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		this.emprepo.deleteById(id);
	}
	
	@Override
	//user-defined method to look for the employees by name provided in the search bar
	public List<Employee> returnEmployeeByName(String name) {
		// TODO Auto-generated method stub

		return this.emprepo.searchEmployeeByName(name);
	}

	


}
