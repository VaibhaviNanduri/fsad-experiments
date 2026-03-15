
package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.exception.InvalidInputException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        if(studentId != 1){
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return new Student(1,"Karthik","Computer Science");
    }
}
