package com.valtech.training.springemployeemanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.training.springemployeemanager.entities.Department;
import com.valtech.training.springemployeemanager.services.DepartmentEmployeeService;

@Controller
@RequestMapping(path = "/department")
public class DepartmentWithEmployeeController {
	
	@Autowired
	private DepartmentEmployeeService departmentEmployeeService;
	
	@GetMapping("/list")
	public String listDepartmentWithEmployees(Model model) {
		Department department;
		model.addAttribute("departmentWithEmployees", departmentEmployeeService.getDepartmentWithEmployees(1));
		return "department/list";
	}
}
