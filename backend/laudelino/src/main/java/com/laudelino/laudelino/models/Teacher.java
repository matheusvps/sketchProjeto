package com.laudelino.laudelino.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long age;

    private String email;

    private String subject;

    

    @ElementCollection  
    private List<Integer> yearsTeached;


    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
     public Long getAge() {
      return age;
    }

    public void setAge(Long age) {
      this.age = age;
    }
    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
    public String getSubject() {
      return subject;
    }

    public void setSubject(String subject) {
      this.subject = subject;
    }
}