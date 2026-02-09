package com.example.demo.Service;

import java.util.List;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entities.Employees;

public interface IEmployeeService {
	public Employees insertNewEmployees(EmployeeDTO dto);
	public Employees updateEmployee(EmployeeDTO dto, long empId);
	public void deleteEmployeeById(long empId);
	public EmployeeDTO getEmployeeById(long empId);
	public List<Employees> getAllEmployeeList();
	public List<Employees> findByEmpSalary(double empSalary);

	public Employees getEmployeeByName(String empName);
}
