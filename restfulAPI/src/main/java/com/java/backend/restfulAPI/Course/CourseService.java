package com.java.backend.restfulAPI.Course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Course addCourse(Course course);
    Course getCourseById(Long courseId);
    void updateCourse(Course course);
    void deleteCourseById(Long courseId);
    List<Course> getAllCourse();
}
