package com.example.demo.repositories;

import com.example.demo.models.CourseBooks;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseBooksRepository extends JpaRepository<CourseBooks , Integer> {
   // CourseBooks findByName(String userName);

}
