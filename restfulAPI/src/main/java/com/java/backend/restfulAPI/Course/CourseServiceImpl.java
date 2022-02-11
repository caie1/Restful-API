package com.java.backend.restfulAPI.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }


    @Override
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return repository.findById(courseId).get();
    }

    @Override
    public void updateCourse(Course course) {
        Course c = repository.findById(course.getId()).orElseThrow();
        repository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        try{
            repository.deleteById(courseId);
        }catch (DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourse() {
        return repository.findAll();
    }
}
