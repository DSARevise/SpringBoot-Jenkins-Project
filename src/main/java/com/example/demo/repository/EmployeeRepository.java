package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{

	public List<Employees> findByEmpSalaryGreaterThan(double empSalary);
	
	
	@Query("select e from Employees e where e.empName = ?1")
	public Employees getEmployeebyName(String empName);
}
