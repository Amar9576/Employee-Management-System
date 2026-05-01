package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.EmployeeEntity;
import com.ems.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
	public EmployeeEntity addEmployee(EmployeeEntity emp) {
		return repo.save(emp);
	}
	 public List<EmployeeEntity> getAllEmployees() {
	        return repo.findAll();
	    }

	    public EmployeeEntity getEmployeeById(long id) {
	        return repo.findById(id).orElse(null);
	    }

	    public EmployeeEntity updateEmployee(long id, EmployeeEntity newEmp) {
	        EmployeeEntity emp = repo.findById(id).orElse(null);

	        if(emp != null) {
	            emp.setName(newEmp.getName());
	            emp.setSallary(newEmp.getSallary());
	            emp.setDept(newEmp.getDept());
	            return repo.save(emp);
	        }
	        return null;
	    }

	    public void deleteEmployee(long id) {
	        repo.deleteById(id);
	    }
//		public EmployeeEntity updateEmployeePartially(long id, EmployeeEntity emp) {
//			// TODO Auto-generated method stub
//			return null;
//		}
		public EmployeeEntity updateEmployeePartially(long id, EmployeeEntity emp) {
			// TODO Auto-generated method stub
			return repo.findById(id).map(existingEmp -> {
	            if(emp.getName() != null) existingEmp.setName(emp.getName());
	            if(emp.getSallary() != 0) existingEmp.setSallary(emp.getSallary());
	            if(emp.getDept() != null) existingEmp.setDept(emp.getDept());
	            return repo.save(existingEmp);
	        }).orElse(null);
		}
}
