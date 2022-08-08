package com.example.demo.models;

import javax.persistence.*;

import com.example.demo.models.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Teacher")

public class Teacher {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "teacher_id" , nullable = false)
    private Integer teacher_id;

    @Column(name = "teacher_name" , nullable = false )
    private String teacher_name;

    @Column(name = "teacher_address" , nullable = false )
    private String teacher_address;

    @Column(name = "teacher_phone" , nullable = false )
    private Long teacher_phone;

    @Column(name = "teacher_major" , nullable = false )
    private String teacher_major;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name = "teacher_id" )
    private List<Course> course = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "teacher_salary_id" , referencedColumnName = "salary_id")
    private TeacherSalary teacherSalary;

    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Teacher(String teacher_name, String teacher_address, Long teacher_phone, String teacher_major, List<Course> course, TeacherSalary teacherSalary) {
        this.teacher_name = teacher_name;
        this.teacher_address = teacher_address;
        this.teacher_phone = teacher_phone;
        this.teacher_major = teacher_major;
        this.course = course;
        this.teacherSalary = teacherSalary;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_address() {
        return teacher_address;
    }

    public void setTeacher_address(String teacher_address) {
        this.teacher_address = teacher_address;
    }

    public Long getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(Long teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public String getTeacher_major() {
        return teacher_major;
    }

    public void setTeacher_major(String teacher_major) {
        this.teacher_major = teacher_major;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public TeacherSalary getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(TeacherSalary teacherSalary) {
        this.teacherSalary = teacherSalary;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_address='" + teacher_address + '\'' +
                ", teacher_phone=" + teacher_phone +
                ", teacher_major='" + teacher_major + '\'' +
                ", course=" + course +
                ", teacherSalary=" + teacherSalary +
                '}';
    }
}
