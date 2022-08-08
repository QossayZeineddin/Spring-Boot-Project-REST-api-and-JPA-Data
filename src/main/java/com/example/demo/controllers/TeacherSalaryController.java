package com.example.demo.controllers;

import com.example.demo.models.TeacherSalary;
import com.example.demo.services.TeacherSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacherSalary")
public class TeacherSalaryController {

    @Autowired
    TeacherSalaryService teacherSalaryService;

    @GetMapping("getAll")
    public List<TeacherSalary> getAllTeacherSalary(){
        return  teacherSalaryService.getAllTeacherSalary();
    }

    @GetMapping("find/{id}")
    public TeacherSalary findById(@PathVariable Integer id){
        return teacherSalaryService.findById(id);
    }

    @PostMapping("add")
    public  TeacherSalary addNew(@RequestBody TeacherSalary teacherSalary){
        return  teacherSalaryService.addNew(teacherSalary);
    }


    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id){
        return  teacherSalaryService.deleteById(id);
    }

}
