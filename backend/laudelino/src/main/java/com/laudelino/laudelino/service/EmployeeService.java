package com.laudelino.laudelino.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laudelino.laudelino.models.Employee;
import com.laudelino.laudelino.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Empregado não encontrado com ID " + id);
        }

        Employee currentEmployee = employee.get();
        currentEmployee.setName(updatedEmployee.getName());
        currentEmployee.setFunction(updatedEmployee.getFunction());
        return employeeRepository.save(currentEmployee);
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Empregado não encontrado com ID " + id);
        }

        employeeRepository.delete(employee.get());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Empregado não encontrado com ID " + id);
        }

        return employee.get();
    }
}