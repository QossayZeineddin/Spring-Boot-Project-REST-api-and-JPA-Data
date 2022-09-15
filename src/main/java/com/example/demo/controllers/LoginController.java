package com.example.demo.controllers;

import com.example.demo.models.UserSecurity;
import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.Calendar;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseBooksService courseBooksService;
    @Autowired
    private TeacherSalaryService teacherSalaryService;
    UserSecurity userSecurity;



    @GetMapping(value = {"login","/"})
    public String loginPage() {
        return "newLogin";
    }


    @GetMapping(value = "index")
    public String addUser(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("student", studentService.getAllStudent());
        model.addAttribute("teacher", teacherService.getAllTeacher());
        model.addAttribute("course", courseService.getAllCourse());
        model.addAttribute("coursesBook", courseBooksService.getAllCourseBook());
        model.addAttribute("teacherSalary", teacherSalaryService.getAllTeacherSalary());
        return "add-new-user";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logOut() {
        return "newLogin";
    }

    //************ ======= Delete Methodes ===== ***********************

    @DeleteMapping("delete/user")
    public String DeleteUser(Model model, @RequestBody String id) {
        userService.DeleteUserById(Integer.parseInt(id));
        model.addAttribute("user", userService.getAllUsers());
        return "add-new-user";
    }

    @DeleteMapping("delete/student")
    public String DeleteStudent(Model model, @RequestBody String id) {
        studentService.deletById(Integer.parseInt(id));
        model.addAttribute("user", studentService.getAllStudent());
        return "add-new-user";
    }
    @DeleteMapping("delete/teacher")
    public String DeleteTeacher(Model model, @RequestBody String id) {
        teacherService.deleteById(Integer.parseInt(id));
        model.addAttribute("user", teacherService.getAllTeacher());
        return "add-new-user";
    }
    @DeleteMapping("delete/teacherSalary")
    public String DeleteTeacherSalary(Model model, @RequestBody String id) {
        teacherSalaryService.deleteById(Integer.parseInt(id));
        model.addAttribute("user", studentService.getAllStudent());
        return "add-new-user";
    }
    @DeleteMapping("delete/course")
    public String DeleteCourse(Model model, @RequestBody String id) {
        courseService.deletById(Integer.parseInt(id));
        model.addAttribute("user", courseService.getAllCourse());
        return "add-new-user";
    }
    @DeleteMapping("delete/courseBook")
    public String DeleteCourseBook(Model model, @RequestBody String id) {
        courseBooksService.deletById(Integer.parseInt(id));
        model.addAttribute("user", courseBooksService.getAllCourseBook());
        return "add-new-user";
    }


    @PostMapping("insert")
    public String done(Model model, String names, String numbers, String emails, String data_of_brith,
                       String password1, String password2, String gender, Integer user_type) {
        model.addAttribute("names", names);
        model.addAttribute("numbers", numbers);
        model.addAttribute("emails", emails);
        model.addAttribute("date_of_brith", data_of_brith);
        model.addAttribute("password1", password1);
        model.addAttribute("password2", password2);
        model.addAttribute("gender", gender);
        model.addAttribute("user_type", user_type);

        if (model.addAttribute("password1", password1) != model.addAttribute("password2", password2)) {
            model.addAttribute("errorMassage1", "Sorry the tow password not macked again");
            return "newLogin";

        } else {
            Date date1 = Date.valueOf(data_of_brith);  //converting string into sql date
            java.sql.Date date2 = new java.sql.Date(Calendar.getInstance().getTime().getTime()); // current date sql format
            // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //String encoderPassword = encoder.encode(password1);
            Users u1 = new Users(user_type, names, emails, gender, numbers, date1, password1, date2);
            System.out.println("New New" + u1.toString());
            userService.addNewUser(u1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            model.addAttribute("user", userService.getAllUsers());
            return "add-new-user";
        }
    }


    @PostMapping("user/update")
    public String update(Model model, @RequestBody Users users) {
        System.out.print("\n\nUpdate user to: " + users.toString() + "\n");
        Users u1 = userRepository.findById(users.getId()).get();
        System.out.print("\nuser Befor update: " + u1.toString() + "\n");
        Users u11 = userService.updateUser(users.getId(), users.getName(), users.getEmail(),users.getPhonenum(),
                users.getGender(), users.getUserDateOfBrith(),users.getUserType(), users.getPassword());
        System.out.print("\nuser After update: " + u11.toString() + "\n");
        model.addAttribute("user", userService.getAllUsers());
        return "add-new-user";


    }

}

//
//    @RequestMapping(value = "user/update",method = RequestMethod.POST )
//    @ResponseBody
//    public String updateById(@RequestBody Users  users) {
//        System.out.println(users.toString() );
//        System.out.print("\n\n hi "+users.getEmail()+"  "+users.getName()+ "  " + users.getName() );
//
//        //  Users u1 = userRepository.findById(users.getId()).get();
////    u1.setEmail(email);
////    u1.setGender(gender);
////    u1.setName(name);
////    u1.setPhonenum(phoneNumber);
////    u1.setUserType(type);
////    u1.setUserDateOfBrith(dateOfBrath);
//        return "Update Done";
//    }
//    @PutMapping("/update")
//    @ResponseBody
//    public String updateById(@RequestBody String id ,
//                             @RequestBody String name,
//                             @RequestBody String phoneNumber,
//                             @RequestBody String email,
//                             @RequestBody String dateOfBrath,
//                             @RequestBody String gender,
//                             @RequestBody String type,
//                             @RequestBody String password,
//                             @RequestBody String createDate ) {
//        System.out.print("\n hi "+name+"  "+phoneNumber+ "  " + email + " \n\n"+dateOfBrath+"  "+gender+ "  " + type);
//
//      //  Users u1 = userRepository.findById(id).get();
////        u1.setEmail(email);
////        u1.setGender(gender);
////        u1.setName(name);
////        u1.setPhonenum(phoneNumber);
////        u1.setUserType(type);
////        u1.setUserDateOfBrith(dateOfBrath);
//          return "Update Done";
//              }


//          *************   Tesing login without security
//    @RequestMapping(value = "loginCheck", method = RequestMethod.POST)
//    public String userInput(Model model, String userName, String password) {
//        model.addAttribute("userName", userName);
//        model.addAttribute("password", password);
//        System.out.println(userName);
//        System.out.println(password);
//        if (userRepository.findByNameAndPassword(userName, password) != null) {
//            Users u1 = userRepository.findByNameAndPassword(userName, password);
//            if (u1.getUserType() == 1) {
//                List<Users> users = userRepository.findAll();
//                System.out.println(users);
//                model.addAttribute("user", users);
//
//                return "add-new-user";
//            } else {
//                return "normalUser";
//            }
//        } else {
//            model.addAttribute("errorMassage", "Sorry the id or password wroing trey again");
//            return "newLogin";
//        }
//    }