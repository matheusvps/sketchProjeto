package com.laudelino.laudelino.control;

import java.util.List;

import com.laudelino.laudelino.models.Teacher;
import com.laudelino.laudelino.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherControl {

    @Autowired
    private TeacherService studentService;

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher estudante) {
        return studentService.createTeacher(estudante);
    }

    @PostMapping("/{id}/{nota}")
    public void addMark(@PathVariable Long id, @PathVariable int nota) {
        studentService.addMark(id, nota);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher estudanteAtualizado) {
        return studentService.updateTeacher(id, estudanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        studentService.deleteTeacher(id);
    }

}