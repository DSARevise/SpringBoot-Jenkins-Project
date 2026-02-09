package com.example.demo.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entities.Employees;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	// for logging
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employees insertNewEmployees(EmployeeDTO dto) {
		Employees emp = new Employees();
		System.out.println("DTO Name: " + dto.getEmpName());
	    System.out.println("DTO City: " + dto.getEmpCity());
	    System.out.println("DTO Salary: " + dto.getEmpSalary());

		emp.setEmpName(dto.getEmpName());
		emp.setEmpCity(dto.getEmpCity());
		emp.setEmpDesignation(dto.getEmpDesignation());
		emp.setEmpSalary(dto.getEmpSalary());
		emp.setEmpExp(dto.getEmpExp());
		logger.info("New Employee has been inserted successfully");
		return repo.save(emp);
	}

	@Override
	public Employees updateEmployee(EmployeeDTO dto, long empId) {
		Employees emp = repo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		emp.setEmpName(dto.getEmpName());
		emp.setEmpCity(dto.getEmpCity());
		emp.setEmpDesignation(dto.getEmpDesignation());
		emp.setEmpSalary(dto.getEmpSalary());
		emp.setEmpExp(dto.getEmpExp());
		logger.info("Employee Data has been updated successfully");
		Employees updateEmp = repo.save(emp);
		return updateEmp;
	}

	@Override
	public void deleteEmployeeById(long empId) {
		Employees emp = repo.findById(empId).orElseThrow(() -> new RuntimeException("Id Not Found"));

		if (emp != null) {
			logger.warn("Are you sure want to delete the employee");
			repo.deleteById(empId);
		}
	}

	@Override
	public EmployeeDTO getEmployeeById(long empId) {
		Employees emp = repo.findById(empId).orElseThrow();

		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		return dto;
	}

	@Override
	public List<Employees> getAllEmployeeList() {
		List<Employees> list = repo.findAll();
		return list;
	}

	@Override
	public List<Employees>	 findByEmpSalary(double empSalary) {
		
		return repo.findByEmpSalaryGreaterThan(empSalary);
	}

}
