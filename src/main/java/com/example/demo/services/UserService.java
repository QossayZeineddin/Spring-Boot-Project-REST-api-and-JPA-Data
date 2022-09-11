package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean addNewUser(Users users) {

        if (userRepository.save(users) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Users findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void DeleteUserById(Integer id) {
        userRepository.deleteById(id);
    }


    public Users updateUser(Integer id, String name, String email, String phoneNumber,
                              String gender, Date dateOfBrith, Integer userType, String password) {

        System.out.print("\n " +name+" "+ email +" " + phoneNumber +"\n\n" );
        if (userRepository.findById(id).equals(Optional.empty())) {
            return null;
        } else {
            Users u1 = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id " + id + " dose not exist"));
            System.out.print("\n here11 name \n " + name + "emmil" + email + " phonemuber "+ phoneNumber + " \n\n"  );


            if (name != null && name.length() > 0 && u1.getName().equals(name) == false) {
                u1.setName(name);
                System.out.print("\n here name \n " );
            }
            if (email != null && email.length() > 0 && u1.getEmail().equals(email) == false) {
                u1.setEmail(email);
                System.out.print("\n here email \n " );
            }
            if (userType != null && userType == 1 && u1.getUserType() != userType) {
                u1.setUserType(userType);
                System.out.print("\n here usre type \n " );
            }
            if (phoneNumber != null && phoneNumber.length() == 9 && u1.getPhonenum().equals(phoneNumber) == false) {
                u1.setPhonenum(phoneNumber);
                System.out.print("\n here phone numer \n " );
            }
            if (gender != null && gender.length() > 0 && u1.getGender().equals(gender) == false) {
                u1.setGender(gender);
                System.out.print("\n here gender \n " );
            }
            if (password != null && password.length() > 0 && u1.getPassword().equals(password) == false) {
                u1.setPassword(password);
                System.out.print("\n here password \n " );
            }
            if (dateOfBrith != null && u1.getUserDateOfBrith().equals(dateOfBrith) == false) {
                u1.setUserDateOfBrith(dateOfBrith);
                System.out.print("\n here date of brith \n " );
            }
            Users ww =  userRepository.save(u1);
            //Boolean x = addNewUser(u1);
            //if (x == false) {
              //  return null;
            //} else {
                return ww;
            //}

        }
    }

}
