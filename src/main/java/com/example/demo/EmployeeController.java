package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin //without it react port can't connect with spring port
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@PostMapping("/addEmp")
	public Employee addEmp(@RequestBody Employee emp)
	{
		dao.save(emp);
		return emp;
	}
	
	@GetMapping("/employees")
	public List<Employee> getList()
	{
		return dao.findAll();
	}
	
	@RequestMapping("/employee/{eid}")
	public Optional<Employee> getEmp(@PathVariable("eid") int eid)
	{
		return dao.findById(eid);
	}
	
	@PutMapping("/employee")
	public Employee put(@RequestBody Employee emp)
	{
		dao.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employee/{eid}")
	public String del(@PathVariable int eid)
	{
		Employee emp = dao.getOne(eid);
		dao.delete(emp);
		return "Deleted";
	}
}