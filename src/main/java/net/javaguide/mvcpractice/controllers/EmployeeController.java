package net.javaguide.mvcpractice.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.javaguide.mvcpractice.model.Employee;
import net.javaguide.mvcpractice.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	//Since all our database access will be carried out by the service,
	//we use @AutoWired to carry out dependency injection, injecting the service
	//into the controller
	@Autowired
	private EmployeeService empserv;
	
	//display list of employees
	//request mapping - general mapping from view to controller
	//change the string inside to navigate across the different templates
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", empserv.getAllEmployees());
		return "index";
	}
	
	//redirects to page where you can add a new employee
	//GetMapping is used when fetching read-only data (in this case, 
	// we do not need to save a new employee yet, we will just pass an empty
	// employee object w/o any attributes to the model)
	@GetMapping("/newEmployeeForm")
	public String newEmployee(Model model) {
		
		//create empty employee object
		Employee employee = new Employee();
		
		//pass empty employee object to the view
		model.addAttribute("employee", employee);
		
		
		//redirect to newEmployee.html
		return "newEmployee";
	}
	
	
	//PostMapping is saving items into the database, so use when the method adds/updates
	//an entry to the database.
	//@ModelAttribute maps the "employee" variable in the view that called this method
	//to the "employee" parameter of this method
	//This method is used to (1) add a new employee object to the database and
	//(2) save the new details of the queried employee object to the database
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//saving the employee object into the database
		empserv.saveEmployee(employee);
		
		//redirect: -> sends user to another page (in this case, the home page)
		return "redirect:/";
	}
	
	//GetMapping is used here because it will just send the user to the page where the update
	//will happen. The {id} parameter will be dependent on the view that called this method.
	//@PathVariable maps the value to the mapping. Since @PathVariable(value = "id"), it
	//will look for the id value inside the @GetMapping annotation. It will then treat it as the
	//id parameter.
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
		
		//fetch employee
		Employee employee = empserv.getEmployeeById(id);
		
		//after finding the employee object, it will be passed to the
		//view where it will be updated
		model.addAttribute("employee", employee);
		
		return "updateEmployee";
	}
	
	
	//GetMapping is used here since it is not putting/updating any new value in the database.
	//Similar to the update method, we find the employee first in the database, then
	//we delete it with methods in the service class
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id, Model model) {
		
		//delete from database
		empserv.deleteEmployeeById(id);
		
		//redirect to home page
		return "redirect:/";
	}
	
	
	@PostMapping("/searchEmployee")
	
	//the @Param annotation was used here and it fetches whatever element had the
	//name attribute "name" in the form that called this method
	public String searchEmployee(@Param("name") String name, Model model) {
		
		//called the method which searches for names that contains the string
		List<Employee> listEmployees = empserv.returnEmployeeByName(name);
		
		//add to model
		model.addAttribute("listEmployees", listEmployees);
		
		//redirect to home page
		return "index";
	}
}
