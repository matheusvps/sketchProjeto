package com.laudelino.laudelino.control;

import java.util.List;

import com.laudelino.laudelino.models.Employee;
import com.laudelino.laudelino.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeControl {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee estudante) {
        return employeeService.createEmployee(estudante);
    }

    @PostMapping("/{id}/{nota}")
    public void addMark(@PathVariable Long id, @PathVariable int nota) {
        employeeService.addMark(id, nota);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee estudanteAtualizado) {
        return employeeService.updateEmployee(id, estudanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployeesWithMarks();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeesWithMarks(id);
    }

    @GetMapping("/{id}/media")
    public double calculateAverage(@PathVariable Long id) {
        return employeeService.calculateAverage(id);
    }

    @GetMapping("/{id}/maior")
    public int getBiggestMark(@PathVariable Long id) {
        return employeeService.getHighestMark(id);
    }

    @GetMapping("/{id}/menor")
    public int getLowestMark(@PathVariable Long id) {
        return employeeService.getLowestMark(id);
    }

}