package com.laudelino.laudelino.control;

import com.laudelino.laudelino.models.Teacher;
import com.laudelino.laudelino.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherControl {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher estudante) {
        return teacherService.createTeacher(estudante);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher estudanteAtualizado) {
        return teacherService.updateTeacher(id, estudanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher changeSubject(@PathVariable Long id, @RequestBody Teacher currentTeacher){
        return teacherService.updateTeacher(id,currentTeacher);
    }

}