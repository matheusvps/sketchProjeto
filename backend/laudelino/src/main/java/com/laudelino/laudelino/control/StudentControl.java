package com.laudelino.laudelino.control;

import java.util.List;

import com.laudelino.laudelino.models.Student;
import com.laudelino.laudelino.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentControl {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student estudante) {
        return studentService.createStudent(estudante);
    }

    @PostMapping("/{id}/{nota}")
    public void addMark(@PathVariable Long id, @PathVariable int nota) {
        studentService.addMark(id, nota);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student estudanteAtualizado) {
        return studentService.updateStudent(id, estudanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudentsWithMarks();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentsWithMarks(id);
    }

    @GetMapping("/{id}/media")
    public double calculateAverage(@PathVariable Long id) {
        return studentService.calculateAverage(id);
    }

    @GetMapping("/{id}/maior")
    public int getBiggestMark(@PathVariable Long id) {
        return studentService.getHighestMark(id);
    }

    @GetMapping("/{id}/menor")
    public int getLowestMark(@PathVariable Long id) {
        return studentService.getLowestMark(id);
    }

    @GetMapping("/{id}/numero-notas")
    public int getMarks(@PathVariable Long id) {
        return studentService.marksAmount(id);
    }
}