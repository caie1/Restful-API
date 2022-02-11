package com.java.backend.restfulAPI.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private final CourseService cs;

    public CourseController(CourseService cs) {
        this.cs = cs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody Course course){
        return cs.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourse(){
        return cs.getAllCourse();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long courseId){
        return cs.getCourseById(courseId);
    }

    @PutMapping("/updatecourse")
    public ResponseEntity<Long> updateCourse(@RequestBody Course course){
        try{
            cs.updateCourse(course);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable("id") Long courseId){
        try{
            cs.deleteCourseById(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
    }
}
