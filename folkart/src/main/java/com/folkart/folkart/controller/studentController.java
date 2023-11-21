package com.folkart.folkart.controller;

import com.folkart.folkart.model.students;
import com.folkart.folkart.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1")
public class studentController {
    @Autowired
    private studentRepository studentRepository;
    @GetMapping("/students")
        public List<students> getAllStudents(){
         return studentRepository.findAll();
        }

    //get student by id
    @GetMapping("students/{id}")
        public ResponseEntity<students>getStudentsById(@PathVariable Long id){
        Optional<students>optionalStudents = studentRepository.findById(id);
        return optionalStudents.map(students -> new ResponseEntity<>(students, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    //create student
    @PostMapping("/students")
        public ResponseEntity<students>createStudent(@RequestBody  students student){
        students saveStudent = studentRepository.save(student);
        return new ResponseEntity<>(saveStudent,HttpStatus.CREATED);
    }
    //update an existing student
    @PutMapping("students/{id}")
    public ResponseEntity<students>updateStudent(@PathVariable Long id,@RequestBody students updateStudent){
        Optional<students>optionalStudents = studentRepository.findById(id);
        if(optionalStudents.isPresent()){
            students existingStudent = optionalStudents.get();
            existingStudent.setFullName(updateStudent.getFullName());
            existingStudent.setNameIni(updateStudent.getNameIni());
            existingStudent.setEmail(updateStudent.getEmail());
            studentRepository.save(existingStudent);
            return new ResponseEntity<>(existingStudent,HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //delete student
    @DeleteMapping("students/{id}")
    public ResponseEntity<Void>deleteStudent(@PathVariable long id){
        Optional<students>optionalStudents= studentRepository.findById(id);
        if(optionalStudents.isPresent()) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    }

