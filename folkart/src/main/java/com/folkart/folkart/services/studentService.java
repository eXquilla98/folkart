package com.folkart.folkart.services;

import com.folkart.folkart.model.students;
import com.folkart.folkart.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    private studentRepository studentRepository;

    public List<students> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<students> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public students createStudent(students student) {
        return studentRepository.save(student);
    }

    public Optional<students> updateStudent(Long id, students updateStudent) {
        Optional<students> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            students existingStudent = optionalStudent.get();
            existingStudent.setFullName(updateStudent.getFullName());
            existingStudent.setNameIni(updateStudent.getNameIni());
            existingStudent.setEmail(updateStudent.getEmail());
            return Optional.of(studentRepository.save(existingStudent));
        } else {
            return Optional.empty();
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}