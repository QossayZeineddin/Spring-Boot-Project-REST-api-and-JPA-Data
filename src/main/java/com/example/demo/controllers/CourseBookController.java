package com.example.demo.controllers;

import com.example.demo.models.CourseBooks;
import com.example.demo.services.CourseBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("CourseBook")
public class CourseBookController {

    @Autowired
    private CourseBooksService courseBooksService;

    @GetMapping("getAll")
    public List<CourseBooks> getAllCourseBook() {
        return courseBooksService.getAllCourseBook();
    }

    @GetMapping("find/{id}")
    public Optional<CourseBooks> findById(@PathVariable Integer id) {
        return courseBooksService.findById(id);
    }

    @PostMapping("add")
    public CourseBooks addNewCoursebook(@RequestBody CourseBooks courseBooks) {
        return courseBooksService.addNewCourseBook(courseBooks);
    }

    @DeleteMapping("delete/{id}")
    public String deletById(@PathVariable Integer id) {
        return courseBooksService.deletById(id);
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable Integer id,
                         @RequestParam String book_name,
                         @RequestParam String editiom,
                         @RequestParam Integer course_id) {
        return courseBooksService.update(id, book_name, editiom, course_id);

    }
}
