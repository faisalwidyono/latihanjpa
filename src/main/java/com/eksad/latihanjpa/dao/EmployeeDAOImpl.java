package com.eksad.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eksad.latihanjpa.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public List<Employee> getAll() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	@Override
	public Employee getById(int Id) {
		return entityManager.find(Employee.class, Id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		entityManager.persist(employee);
		
		
	}

	@Transactional
	@Override
	public void update(Employee employee) {
		entityManager.merge(employee);
		
	}

	@Transactional
	@Override
	public void delete(int Id) {
		
		Employee employee = getById(Id);
		
		entityManager.remove(employee);
		
	}
	
	@Override
	public List<Employee> getByName(String name) {
		
		return entityManager.createNativeQuery("select * from employee  where name like ?0 ", Employee.class)
		//return entityManager.createQuery("select e from Employee e where e.name like ?0", Employee.class)
		.setParameter(0,"%"+ name +"%")
		.getResultList();
		
		
	}

	
}
