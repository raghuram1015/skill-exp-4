package klu.Hibernate_crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;   // ✅ missing import added

@Entity
// @Table(name = "emp_3")  // it is helping to create new TABLE
public class Employee {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE) // this is used for ID auto generation
	int id;
	String fn;
	String ln;
	double sal;

	// setter for id
	public void setID(int id) {
		this.id = id;
	}

	// getter for id
	public int getID() {
		return id;
	}

	// setter for first name
	public void setFn(String fn) {
		this.fn = fn;
	}

	// getter for first name
	public String getFn() {
		return fn;
	}

	// setter for last name
	public void setLn(String ln) {
		this.ln = ln;
	}

	// getter for last name
	public String getLn() {
		return ln;
	}

	// setter for salary
	public void setSal(double sal) {
		this.sal = sal;
	}

	// getter for salary
	public double getSal() {
		return sal;
	}
}
