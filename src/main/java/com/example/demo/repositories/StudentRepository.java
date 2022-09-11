package com.example.demo.repositories;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {
//
//    @Query(value = "select U.userType from Users U where U.name= :userName and U.password= :password")
//    Users findByNameAndPassword(String userName , String password);

//    @Query(value = "select U from Student U where U.student_name like %:userName%")
//    List<Student> findByName(String userName );

    @Query(value = "select count(U.student_id) from Student U where U.student_Date_of_brith  = :userName")
    Integer findByNameCount(Date userName );

    //Student findByName(String userName);


}
