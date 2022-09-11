package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String addNewStudent(Student student) {
        if (studentRepository.save(student) != null) {

            return "The student add done :" + student.toString();
        } else {
            return "there was error.jsp in add";
        }
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public String deletById(Integer id) {
        studentRepository.deleteById(id);
        return "delete student with id " + id + "  Done";
    }

    public String update(Integer id, String name, String address, Long number) {

        if (studentRepository.findById(id).equals(Optional.empty())) {
            return "The id is not found";
        } else {
            Student s1 = studentRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("student with id " + id + " dose not exist"));

            if (name != null && name.length() > 0 && s1.getStudent_name().equals(name) == false) {
                s1.setStudent_name(name);
            }
            if (address != null && address.length() > 0 && s1.getStudent_address().equals(address) == false) {
                s1.setStudent_address(address);
            }
            if (number != null && number > 8 && s1.getStudent_phone() != number) {
                s1.setStudent_phone(number);
            }

            // studentRepository.save(s1);
            return "Done ";
            /*
             *
             * @PutMapping("/employees/{id}") Employee replaceEmployee(@RequestBody Employee
             * newEmployee, @PathVariable Long id) {
             *
             * return repository.findById(id) .map(employee -> {
             * employee.setName(newEmployee.getName());
             * employee.setRole(newEmployee.getRole()); return repository.save(employee); })
             * .orElseGet(() -> { newEmployee.setId(id); return
             * repository.save(newEmployee); }); }
             */
        }
    }

//    public List<Student> gettest(String name) {
//        System.out.print("\n\n\n\n\nherer is testing\n\n");
//        //System.out.print( studentRepository.findByName(name));
//
//        return studentRepository.findByName(name);
//    }

    public Integer gettest2(Date name) {
        System.out.print("\n\n\n\n\nherer is testing\n\n");
        //System.out.print( studentRepository.findByName(name));
        return studentRepository.findByNameCount(name);


    }
}
