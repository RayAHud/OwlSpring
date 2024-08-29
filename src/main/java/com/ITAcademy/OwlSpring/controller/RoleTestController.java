//package com.ITAcademy.OwlSpring.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RoleTestController {
//    @GetMapping("/anybody")
//    public String home() {
//        return "Hello, World!";
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/user")
//    public String user() {
//        return "Hello, User!";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/admin")
//    public String admin() {
//        return "Hello, Admin!";
//    }
//}
