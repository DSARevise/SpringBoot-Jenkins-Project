package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Service.IEmployeeService;
import com.example.demo.entities.Employees;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@PostMapping("/insert")
	public ResponseEntity<Employees> insertEmployees(@RequestBody EmployeeDTO dto) {

		System.out.println("DTO Name: " + dto.getEmpName());
		System.out.println("DTO City: " + dto.getEmpCity());
		System.out.println("DTO Salary: " + dto.getEmpSalary());

		Employees emp = service.insertNewEmployees(dto);

		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}

	@PutMapping("/update/employee/{empId}")
	public ResponseEntity<Employees> updateEmployees(@RequestBody EmployeeDTO dto, @PathVariable long empId) {
		Employees emp = service.updateEmployee(dto, empId);
		return ResponseEntity.ok(emp);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployees(@PathVariable long empId) {
		service.deleteEmployeeById(empId);
		return ResponseEntity.ok("EmployeeDeleted Successfully");
	}

	@GetMapping("/getEmployees/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long empId) {
		EmployeeDTO emp = service.getEmployeeById(empId);
		return ResponseEntity.ok(emp);
	}

	@GetMapping("/getAllEmployees")
	public List<Employees> getAllEmployees() {
		return service.getAllEmployeeList();

	}

	@GetMapping("/getEmpBySalary/{empSalary}")
	public List<Employees> getEmpBySalary(double empSalary) {
		 return service.findByEmpSalary(empSalary);
		
	}

}
