package com.example.demo.repositories;

import com.example.demo.models.TeacherSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSalaryRepositories extends JpaRepository<TeacherSalary , Integer> {

}
