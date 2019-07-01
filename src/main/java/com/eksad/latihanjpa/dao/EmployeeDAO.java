package com.eksad.latihanjpa.dao;

import java.util.List;

import com.eksad.latihanjpa.model.Employee;

public interface EmployeeDAO {
	
	public List <Employee> getAll();
	
	public Employee getById(int Id);
	
	public void save (Employee employee);
	
	public void update (Employee employee);

	public void delete (int Id);

	public List<Employee> getByName(String name);
	

}
