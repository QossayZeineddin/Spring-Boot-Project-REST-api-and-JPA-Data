package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.CourseBooks;
import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.services.CourseService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")

public class CourseController {

    @Autowired
    CourseService courseService;
    @GetMapping("/getAll")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping("/add")
    public String addNewCourse(@RequestBody Course course){
        return  courseService.addNewCourse(course);
    }

    @GetMapping("/find/{id}")
    public Optional<Course> findById(@PathVariable Integer id){
        if (courseService.findById(id).equals(Optional.empty())){
            Student s1 = new Student();
            List<Student> listOfStudent = new ArrayList<>();
            CourseBooks cb1 = new CourseBooks();
            List<CourseBooks> courseBooksList= new ArrayList<>();
            listOfStudent.add(s1);
            courseBooksList.add(cb1);
            Course c = new Course("ENCS00","non","2" ,"n",listOfStudent,courseBooksList);
            courseService.addNewCourse(c);
            return Optional.of(c);
        } else {
            return  courseService.findById(id);
        }
    }

    @DeleteMapping("delete/course")
    public String DeleteCourse(Model model, @RequestBody String id) {
        courseService.deletById(Integer.parseInt(id));
        return "done";
    }

    @GetMapping(value = {"find" , "find/" , "delete/" , "delete" , "update/", "update"})
    public String getNull(){
        return "plz Write a id";
    }

    @PutMapping("update/{id}")
    public String updateById(@PathVariable Integer id ,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String section,
                             @RequestParam(required = false) String time) {
        //System.out.print("\n  "+name+"  "+section+ "  " + time + " \n\n");

        return courseService.updateCourse(id, name, section, time);
    }

    @JsonIgnore
    @PutMapping("enroall/{studentId}/{courseId}")
    public Course nroallStudentToCourse(@PathVariable Integer studentId,@PathVariable Integer courseId){
        return  courseService.enroallStudentToCourse(studentId,courseId);
    }

}
