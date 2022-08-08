package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
//@Table(name = "Course")
public class Course {


    @Id
    @Column(name = "course_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(name = " course_code", nullable = false)
    private String course_code;

    @Column(name = " course_name", nullable = false)
    private String course_name;

    @Column(name = " course_secation", nullable = false)
    private String course_secation;

    @Column(name = " course_time", nullable = false)
    private String course_time;

    @ManyToMany()
    @JoinTable(name = "Stu_Enroall_Cou", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    List<Student> studentList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<CourseBooks> courseBooksList = new ArrayList<>();

    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Course(String course_code, String course_name, String course_secation, String course_time, List<Student> studentList,List<CourseBooks> courseBooksList) {
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_secation = course_secation;
        this.course_time = course_time;
        this.studentList = studentList;
        this.courseBooksList = courseBooksList;

    }

    public void addToStudentList(Student student) {
        studentList.add(student);
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }


    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_secation() {
        return course_secation;
    }

    public void setCourse_secation(String course_secation) {
        this.course_secation = course_secation;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<CourseBooks> getCourseList() {
        return courseBooksList;
    }

    public void setCourseList(List<CourseBooks> courseBooksList) {
        this.courseBooksList = courseBooksList;
    }

    public void  addToCourseBooksList(CourseBooks courseBooksList){
        this.courseBooksList.add(courseBooksList);
    }


    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_code='" + course_code + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_secation='" + course_secation + '\'' +
                ", course_time='" + course_time + '\'' +
                ", studentList=" + studentList +
                ", courseBooksList=" + courseBooksList +
                '}';
    }
}
