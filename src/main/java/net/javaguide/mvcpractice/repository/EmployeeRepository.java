package net.javaguide.mvcpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguide.mvcpractice.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//The employee repository is empty, since this is a layer of abstraction between the
	//service and the database itself. all methods that will perform CRUD on the DB
	//are in the service class
}
