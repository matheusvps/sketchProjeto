package com.laudelino.laudelino.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laudelino.laudelino.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}