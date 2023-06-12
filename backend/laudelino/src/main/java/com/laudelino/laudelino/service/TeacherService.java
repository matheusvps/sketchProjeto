package com.laudelino.laudelino.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laudelino.laudelino.models.Teacher;
import com.laudelino.laudelino.repositories.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new EntityNotFoundException("Professor não encontrado com ID " + id);
        }

        Teacher currentTeacher = teacher.get();
        currentTeacher.setName(updatedTeacher.getName());
        currentTeacher.setSubject(updatedTeacher.getSubject());
        return teacherRepository.save(currentTeacher);
    }

    public void deleteTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new EntityNotFoundException("Professor não encontrado com ID " + id);
        }

        teacherRepository.delete(teacher.get());
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new EntityNotFoundException("Professor não encontrado com ID " + id);
        }
        return teacher.get();
    }
    
    

    
    

    

    

}