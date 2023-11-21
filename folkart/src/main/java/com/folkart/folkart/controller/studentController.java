package com.folkart.folkart.controller;

import com.folkart.folkart.model.students;
import com.folkart.folkart.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("api/v1")
public class studentController {
    @Autowired
    private studentRepository studentRepository;
    @GetMapping("/students")
        public List<students> getAllStudents(){
         return studentRepository.findAll();
        }
}
