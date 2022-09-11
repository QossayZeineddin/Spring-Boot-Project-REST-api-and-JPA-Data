package com.example.demo.repositories;

import com.example.demo.models.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users , Integer> {

//    @Query(value = "select U.userType from Users U where U.name= :userName and U.password= :password")
    Users findByNameAndPassword(String userName , String password);

    Users findByName(String userName);
//
//    @Query("select u from  Users  u where u.name =?1")
//    Users findUsersByName(String name);
}
