package com.laudelino.laudelino.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private Integer grade;

    @ElementCollection  
    private List<Integer> marks;

    private Integer biggestMark;

    private Integer lowestMark;

    private Double average;

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public String getEmail(){return email; }

    public void setEmail(String email){this.email = email; }

    public Integer getAge() {return age; }

    public void setAge(Integer age){this.age = age; }

    public Integer getGrade() {return grade; }

    public void setGrade(Integer grade){this.grade = grade; }

    public List<Integer> getMarks() {
      return marks;
    }
    
    public int getMarkAtIndex(int index){
      return marks.get(index);
    }

    public void addMark(int mark){
      marks.add(mark);
    }

    public void setMarks(List<Integer> marks) {
      this.marks = marks;
    }

    public Integer getBiggestMark() {
      return biggestMark;
    }

    public void setBiggestMark(Integer biggestMark) {
      this.biggestMark = biggestMark;
    }

    public Integer getLowestMark() {
      return lowestMark;
    }

    public void setLowestMark(Integer lowestMark) {
      this.lowestMark = lowestMark;
    }

    public Double getAverage() {
      return average;
    }

    public void setAverage(Double average) {
      this.average = average;
    }

    
}