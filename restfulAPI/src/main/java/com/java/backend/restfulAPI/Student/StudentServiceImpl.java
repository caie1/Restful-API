package com.java.backend.restfulAPI.Student;

import com.java.backend.restfulAPI.Course.Course;
import com.java.backend.restfulAPI.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    @Autowired
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

    @Override
    public Student addCourse(Long studentId, Course course) {
        Student stu = repository.findById(studentId).get();
        stu.getEnrolledCourses().add(course);
       // course.getEnrolls().add(stu);
        repository.save(stu);
        return stu;
    }
}
