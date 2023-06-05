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
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        Employee currentEmployee = employee.get();
        currentEmployee.setName(updatedEmployee.getName());
        currentEmployee.setMarks(updatedEmployee.getMarks());
        return employeeRepository.save(currentEmployee);
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        employeeRepository.delete(employee.get());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        return employee.get();
    }
    
    public Employee getEmployeesWithMarks(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado"));
        employee.setBiggestMark(getHighestMark(id));
        employee.setLowestMark(getLowestMark(id));
        employee.setAverage(calculateAverage(id));
        return employee;
    }

    public List<Employee> getAllEmployeesWithMarks() {
        List<Employee> employees = getAllEmployees();
        for (Employee employee : employees) {
            employee.setBiggestMark(getHighestMark(employee.getId()));
            employee.setLowestMark(getLowestMark(employee.getId()));
            employee.setAverage(calculateAverage(employee.getId()));
        }
        return employees;
    }
    public double calculateAverage(Long id) {
        Employee employee = getEmployeeById(id);
        List<Integer> marks = employee.getMarks();

        double sum = 0.0;
        for (Integer mark : marks) {
            sum += mark;
        }
        if(!marks.isEmpty()){
            double average = sum / marks.size();
            return average;
        }

        else{
            double average = 0;
            return average;
        }
    }

    public void addMark(Long id, int mark) {
        Employee employee = getEmployeeById(id);
        employee.addMark(mark);
        employeeRepository.save(employee);
    }

    public int getHighestMark(Long id) {
        Employee employee = getEmployeeById(id);
        List<Integer> marks = employee.getMarks();
        if ( !marks.isEmpty()) {
        int biggestMark = 0;
        for (Integer mark : marks) {
            if (mark > biggestMark) {
                biggestMark = mark;
            }
        }
        return biggestMark;
    }
        else{
            int biggestMark=0;
            return biggestMark;
        }
        
    }

    public int getLowestMark(Long id) {
        Employee estudante = getEmployeeById(id);
        List<Integer> marks = estudante.getMarks();

        if ( !marks.isEmpty()) {
            int lowestMark = marks.get(0);
        for (int i = 1; i < marks.size(); i++) {
            if (marks.get(i) < lowestMark) {
                lowestMark = marks.get(i);
            }
        }
        return lowestMark;
        }

        else{
            int lowestMark=0;
            return lowestMark;
        }
        }
    

    public int marksAmount(Long id) {
        Employee employee = getEmployeeById(id);
        List<Integer> marks = employee.getMarks();
        if(!marks.isEmpty()){
            return marks.size();
        }

        else{
            int size=0;
            return size;   
        }
    }
}