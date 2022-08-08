package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import com.example.demo.models.TeacherSalary;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping("/getAll")
    public List<Teacher> getAllCourse(){
        return teacherService.getAllTeacher();
    }

    @PostMapping("/add")
    public String addNewCourse(@RequestBody Teacher teacher){
        return  teacherService.AddNewTeacher(teacher);
    }

    @GetMapping("/find/{id}")
    public Optional<Teacher> findById(@PathVariable Integer id){
        if (teacherService.findById(id).equals(Optional.empty())){
            List<Course> c= new ArrayList<>();
            Course ss = new Course();
            c.add(ss);
            TeacherSalary t1 = new TeacherSalary();
            Teacher t = new Teacher("wasel","ramallah", 565656565L,"CE",c,t1);
            teacherService.AddNewTeacher(t);
            return Optional.of(t);
        } else {
            return  teacherService.findById(id);
        }

    }

    @DeleteMapping("delete/{id}")
    public String deletOne(@PathVariable Integer id) {
        return teacherService.deletById(id);
    }

    @PutMapping("update/{id}")
    public String updateById(@PathVariable Integer id ,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) Long phoneNumber) {
        return teacherService.updateTeacher(id, name, address, phoneNumber);
    }


    @GetMapping(value = {"find" , "find/ ","delete/","delete"})
    public String getNull(){
        return "plz Write a id";
    }

}
