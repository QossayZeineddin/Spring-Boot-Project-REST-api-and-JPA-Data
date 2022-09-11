package com.example.demo.services;

import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired

    private StudentRepository studentRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public String addNewCourse(Course course) {
        if (courseRepository.save(course) != null) {
            return "The Course add done :" + course.toString();
        } else {
            return "there was error.jsp in add";
        }
    }

    public Optional<Course> findById(Integer id) {
        return courseRepository.findById(id);
    }

    public String deletById(Integer id) {
        System.out.println("\n\n\n\n"+id+"\n\n\n");
        courseRepository.deleteById(id);
        return "delete Course with id " + id + "  Done";
    }

    public String updateCourse(Integer id, String name, String section, String time) {
        //System.out.print("  "+name+"  "+section+ "  " + time + " \n");
        if (courseRepository.findById(id).equals(Optional.empty())) {
            return "The id is not found";
        } else {
            Course c1 = courseRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("student with id " + id + " dose not exist"));

            if (name != null && name.length() > 0 && c1.getCourse_name().equals(name) == false) {
                c1.setCourse_name(name);
            }
            if (section != null && section.length() > 0 && c1.getCourse_secation().equals(section) == false) {
                c1.setCourse_secation(section);
            }
            if (time != null && time.length() > 0 && c1.getCourse_time().equals(time) == false) {
                c1.setCourse_time(time);
            }

            //courseRepository.save(c1);
            return "Done hehe";
        }
    }

    public Course enroallStudentToCourse(Integer studentId, Integer courseId) {

        Student s1 = studentRepository.findById(studentId).get();
        Course c1 = courseRepository.findById(courseId).get();
        c1.addToStudentList(s1);
        return courseRepository.save(c1);
        //getReferenceById


    }
}
