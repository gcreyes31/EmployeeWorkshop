package net.javaguide.mvcpractice.model;

import lombok.*;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.*;

import javax.persistence.*;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
}
