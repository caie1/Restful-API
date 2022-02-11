package com.java.backend.restfulAPI.Student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student addStudent(Student student);
    Student getStudentById(Long studentId);
    void updateStudent(Student student);
    void deleteStudentById(Long studentId);
    List<Student> getAllStudent();
}
