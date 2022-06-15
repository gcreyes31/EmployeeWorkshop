package net.javaguide.mvcpractice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguide.mvcpractice.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	//The employee repository is usually empty, since this is a layer of abstraction between the
	//service and the database itself. all methods that will perform CRUD on the DB
	//are in the service class
	
	//using the @Query annotation lets us use JPQL queries when the method is called.
	// %?1% = 
	// - %<String>% is SQL syntax for "search for any string that contains whatever
	// 	is inside the two % symbols"
	// - ?1 is the parameter in the method. since we only have 1 parameter (String name), 
	// 	we use ?1. If there are 3 parameters, you can include them in the query with ?1, ?2 and ?3
	@Query("select e from Employee e where e.firstName like %?1% or e.lastName like %?1%")
	List<Employee> searchEmployeeByName(String name);
}
