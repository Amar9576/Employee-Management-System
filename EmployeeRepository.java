package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.EmployeeEntity;
@Repository

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long >{
	
	

}
