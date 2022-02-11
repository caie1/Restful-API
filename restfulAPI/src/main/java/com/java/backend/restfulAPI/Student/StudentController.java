package com.java.backend.restfulAPI.Student;

import com.java.backend.restfulAPI.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService ss;

    @Autowired
    public StudentController(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping("/testing")
    public String testing(){
        return "!@#$$%%^^&&*(";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student){
        return ss.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return ss.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return ss.getStudentById(studentId);
    }


    @PutMapping("/updatestudent")
    public ResponseEntity<Long> updateStudent(@RequestBody Student student){
        System.out.println(student);
        try {
            ss.updateStudent(student);
            return new ResponseEntity<Long>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteStudent(@PathVariable("id") Long studentId){
        try{
            ss.deleteStudentById(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
    }


}
