package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.EmployeeEntity;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService service ;
	
	@PostMapping("/add")
	public EmployeeEntity add(@RequestBody EmployeeEntity emp) {
		return service.addEmployee(emp);
	}
	
	@GetMapping("/getall")
	public List<EmployeeEntity>getAllEmployeeEntities(){
		return service.getAllEmployees();
	}
	 @GetMapping("/{id}")
	    public EmployeeEntity getEmployee(@PathVariable long id) {
	        return service.getEmployeeById(id);
	    }

	    @PutMapping("/{id}")
	    public EmployeeEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeEntity emp) {
	        return service.updateEmployee(id, emp);
	    }
	    @PatchMapping("/{id}")
	    public EmployeeEntity updateEmployeePartially(@PathVariable long id, @RequestBody EmployeeEntity emp) {
	        return service.updateEmployeePartially(id, emp);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable long id) {
	        service.deleteEmployee(id);
	        return "Employee Deleted Successfully!";

}
}
