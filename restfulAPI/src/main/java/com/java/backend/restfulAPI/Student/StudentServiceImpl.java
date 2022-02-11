package com.java.backend.restfulAPI.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return repository.findById(studentId).get();
    }

    @Override
    public void updateStudent(Student student) {
            Student stu = repository.findById(student.getId()).orElseThrow();
            repository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        try{
            repository.deleteById(studentId);
        }catch (DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }
}
