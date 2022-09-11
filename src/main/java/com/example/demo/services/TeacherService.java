package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.TeacherRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public String AddNewTeacher(Teacher teacher) {

        if (teacherRepository.save(teacher) != null) {
            return "The teacher add done :" + teacher.toString();
        } else {
            return "there was error.jsp in add";
        }
    }

    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);

    }

    public String deleteById(Integer id) {
        teacherRepository.deleteById(id);
        return "delet teacher with id " + id + "  Done";
    }

    public String updateTeacher(Integer id, String name, String address, Long phoneNumber) {

        if (teacherRepository.findById(id).equals(Optional.empty())) {
            return "The id is not found";
        } else {
            Teacher t1 = teacherRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Teacher with id " + id + " dose not exist"));

            if (name != null && name.length() > 0 && t1.getTeacher_name().equals(name) == false) {
                t1.setTeacher_name(name);
            }
            if (address != null && address.length() > 0 && t1.getTeacher_address().equals(address) == false) {
                t1.setTeacher_address(address);
            }
            if (phoneNumber != null && phoneNumber > 8 && t1.getTeacher_phone() != phoneNumber) {
                t1.getTeacher_phone();
            }
            teacherRepository.save(t1);
            return "Done hh";

        }
    }
}