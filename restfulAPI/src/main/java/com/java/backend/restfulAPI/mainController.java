package com.java.backend.restfulAPI;

import com.java.backend.restfulAPI.Course.Course;
import com.java.backend.restfulAPI.Course.CourseService;
import com.java.backend.restfulAPI.Student.Student;
import com.java.backend.restfulAPI.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// This controller is for insert into join table "enrollment"
// It has both student and course services, not sure if it's ok
@RestController
@RequestMapping("/students")
public class mainController {
    private final StudentService ss;
    private final CourseService cs;

    @Autowired
    public mainController(StudentService ss, CourseService cs) {
        this.ss = ss;
        this.cs = cs;
    }

    @PostMapping("/{id_stu}/{id_c}")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addcourse(@PathVariable("id_stu") Long studentId, @PathVariable("id_c") Long courseId){
        Course c = cs.getCourseById(courseId);
        return ss.addCourse(studentId, c);
    }
}
