package com.laudelino.laudelino.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String function;

    private Long age;
    
    private String email;

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
    public String getFunction() {
      return function;
    }
    
    public void setFunction(String function){
      this.function = function;
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

}