package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeesTable")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;

	private String empName;

	private String empCity;
	private String empDesignation;

	private double empSalary;
	private float empExp;

	public Employees(long empId, String empName, String empCity, String empDesignation, double empSalary,
			float empExp) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empCity = empCity;
		this.empDesignation = empDesignation;
		this.empSalary = empSalary;
		this.empExp = empExp;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public float getEmpExp() {
		return empExp;
	}

	public void setEmpExp(float empExp) {
		this.empExp = empExp;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", empDesignation="
				+ empDesignation + ", empSalary=" + empSalary + ", empExp=" + empExp + "]";
	}

}
