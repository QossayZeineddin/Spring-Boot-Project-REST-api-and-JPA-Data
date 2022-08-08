package com.example.demo.repositories;

import com.example.demo.models.CourseBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseBooksRepository extends JpaRepository<CourseBooks , Integer> {
}
