//package com.ITAcademy.OwlSpring.entity;
//
//import com.ITAcademy.OwlSpring.model.User;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "users")
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String username;
//    private String password;
//    private String role;
//    public UserEntity(String username, String password, String role) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
//    public UserEntity(User user){
//
//        this.id = user.getId();
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.role = user.getRole();
//    }
//}
