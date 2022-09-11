package com.example.demo.models;


import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer userType;

    @NotNull
    @Size(min = 3, max = 70, message = "Name must be greater than 3 characters")
    private String name;

    @NotBlank(message = "Email must not be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message = "Invalid email pattern")
    @Email(message = "Email must be valid")
    @Size(min = 9, max = 70, message = "Emale must valed")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column( name = "gender")
    @Size(min = 4 , max = 6 , message = "enter valed gender")
    private String gender;
    @NotNull
    @Size(min = 9, max = 9, message = "Phone number must be 9 characters")
    private String phonenum;

    @NotNull
    @Column(updatable = false, name = "user_Date_of_brith" , nullable = false )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date userDateOfBrith;

    @Size(min = 8,max = 60, message = "Password must be greater than 8 characters")
    private String password;
    @Transient
    private String passwordConfirmation;


    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;


    public Users() {
        super();
    }

    public Users(Integer userType, String name, String email, String gender, String phonenum, java.sql.Date userDateOfBrith, String password, Date createdAt) {
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phonenum = phonenum;
        this.userDateOfBrith = userDateOfBrith;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.sql.Date getUserDateOfBrith() {
        return userDateOfBrith;
    }

    public void setUserDateOfBrith(java.sql.Date userDateOfBrith) {
        this.userDateOfBrith = userDateOfBrith;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userType=" + userType +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", userDateOfBrith=" + userDateOfBrith +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

