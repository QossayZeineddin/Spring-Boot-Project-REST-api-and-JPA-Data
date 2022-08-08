package com.example.demo.services;

import com.example.demo.models.TeacherSalary;
import com.example.demo.repositories.TeacherRepository;
import com.example.demo.repositories.TeacherSalaryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherSalaryService {

    @Autowired
    TeacherSalaryRepositories teacherSalaryRepositories;

    public List<TeacherSalary> getAllTeacherSalary(){
        return teacherSalaryRepositories.findAll();
    }

    public TeacherSalary addNew(TeacherSalary teacherSalary){
        return teacherSalaryRepositories.save(teacherSalary);
    }

    public TeacherSalary findById(Integer id){
        return  teacherSalaryRepositories.findById(id).get();
    }

    public String deleteById(Integer id){
        teacherSalaryRepositories.deleteById(id);
        return "delete this salary done";
    }

}
