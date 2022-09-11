package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity

//@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "student_id" , nullable = false )
    private Integer student_id;

    @Column(name = "student_name" , nullable = false )
    private String student_name;

    @Column(name = "student_address" , nullable = false )
    private String student_address;

    @NotBlank(message = "Email must not be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message = "Invalid email pattern")
    @Email(message = "Email must be valid")
    private String email;


    @NotBlank
    @Column(name = "gender")
    @Size(min = 4 , max = 6 , message = "enter valed gender")
    private String gender;

    @Column(name = "student_GPA" , nullable = false )
    private Integer student_GPA;

    @Column(name = "student_phone" , nullable = false )
    private Long student_phone;

    @Column(name = "student_Date_of_brith" , nullable = false )
    private Date student_Date_of_brith;

    @Column(name = "student_major" , nullable = false )
    private String student_major;

    @JsonIgnore
    @ManyToMany(mappedBy = "studentList" ,cascade = CascadeType.ALL)

    private List<Course> courseList = new ArrayList<>();

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String student_name, String student_address,String email ,String gender, Integer student_GPA, Long student_phone, Date student_Date_of_brith, String student_major, List<Course> courseList) {
        this.student_name = student_name;
        this.student_address = student_address;
        this.email = email;
        this.gender = gender;
        this.student_GPA = student_GPA;
        this.student_phone = student_phone;
        this.student_Date_of_brith = student_Date_of_brith;
        this.student_major = student_major;
        this.courseList = courseList;
    }

    public void  addToCourseList(Course course){
        courseList.add(course);
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public Integer getStudent_GPA() {
        return student_GPA;
    }

    public void setStudent_GPA(Integer student_GPA) {
        this.student_GPA = student_GPA;
    }

    public Long getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(Long student_phone) {
        this.student_phone = student_phone;
    }

    public Date getStudent_Date_of_brith() {
        return student_Date_of_brith;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStudent_Date_of_brith(Date student_Date_of_brith) {
        this.student_Date_of_brith = student_Date_of_brith;
    }

    public String getStudent_major() {
        return student_major;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_address='" + student_address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", student_GPA=" + student_GPA +
                ", student_phone=" + student_phone +
                ", student_Date_of_brith=" + student_Date_of_brith +
                ", student_major='" + student_major + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
