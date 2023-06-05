package com.laudelino.laudelino.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laudelino.laudelino.models.Student;

@Repository
public interface TeacherRepository extends JpaRepository<Student, Long> {

}