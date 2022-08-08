package com.example.demo.services;


import com.example.demo.models.CourseBooks;
import com.example.demo.repositories.CourseBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseBooksService {
    
    @Autowired
    private CourseBooksRepository courseBooksRepository;
    @Autowired
    private CourseService courseService;

    public List<CourseBooks> getAllCourseBook(){
        
        return  courseBooksRepository.findAll();
    }
    public Optional<CourseBooks> findById(Integer id){
        return courseBooksRepository.findById(id);
    }

    public CourseBooks addNewCourseBook(CourseBooks courseBooks){
        return courseBooksRepository.save(courseBooks);
    }

    public  String deletById(Integer id){
         courseBooksRepository.deleteById(id);
        return "delete CourseBook with id " + id + "  Done";
    }

    public String update(Integer id, String book_name, String editiom, Integer course_id) {
        if(courseBooksRepository.findById(id).equals(Optional.empty())){
            return "The Course book with this id ["+id+"] not found";
        }
        else {
            CourseBooks cb1 = courseBooksRepository.findById(id).orElseThrow(
                    () -> new IllegalStateException("student with id " + id + " dose not exist"));
            if (book_name != null && book_name.length() > 0 &&   cb1.getBook_name().equals(book_name)== false) {
                cb1.setBook_name(book_name);
            }
            if(editiom != null && editiom.length() > 0 && cb1.getEdition().equals(editiom) == false){
                cb1.setEdition(editiom);
            }
            if(course_id > 0 && course_id != null ){
                if (courseService.findById(id).equals(Optional.empty())){
                }else {

                }
            }
            return "Update Done";
        }
    }
}
