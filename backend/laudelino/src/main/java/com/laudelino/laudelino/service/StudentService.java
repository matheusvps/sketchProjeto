package com.laudelino.laudelino.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laudelino.laudelino.models.Student;
import com.laudelino.laudelino.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        Student currentStudent = student.get();
        currentStudent.setName(updatedStudent.getName());
        currentStudent.setMarks(updatedStudent.getMarks());
        return studentRepository.save(currentStudent);
    }

    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        studentRepository.delete(student.get());
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new EntityNotFoundException("Estudante não encontrado com ID " + id);
        }

        return student.get();
    }
    
    public Student getStudentsWithMarks(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado"));
        student.setBiggestMark(getHighestMark(id));
        student.setLowestMark(getLowestMark(id));
        student.setAverage(calculateAverage(id));
        return student;
    }

    public List<Student> getAllStudentsWithMarks() {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            student.setBiggestMark(getHighestMark(student.getId()));
            student.setLowestMark(getLowestMark(student.getId()));
            student.setAverage(calculateAverage(student.getId()));
        }
        return students;
    }
    public double calculateAverage(Long id) {
        Student student = getStudentById(id);
        List<Integer> marks = student.getMarks();

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
        Student student = getStudentById(id);
        student.addMark(mark);
        studentRepository.save(student);
    }

    public int getHighestMark(Long id) {
        Student student = getStudentById(id);
        List<Integer> marks = student.getMarks();
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
        Student estudante = getStudentById(id);
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
        Student student = getStudentById(id);
        List<Integer> marks = student.getMarks();
        if(!marks.isEmpty()){
            return marks.size();
        }

        else{
            int size=0;
            return size;   
        }
    }
}