package com.example.demo.controllers;

import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

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

    @GetMapping(value = {"login", "/"})
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