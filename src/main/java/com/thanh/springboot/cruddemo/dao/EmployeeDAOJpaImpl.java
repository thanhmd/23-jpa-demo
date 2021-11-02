package com.thanh.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.thanh.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
