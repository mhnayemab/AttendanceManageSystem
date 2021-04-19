package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.dto.request.StudentRequest;
import com.example.attendanceSystem.dto.response.IdentityResponse;
import com.example.attendanceSystem.services.StudentServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentServices studentServices;

    @PostMapping("/create/student")
    public ResponseEntity<IdentityResponse> createStudent(@RequestBody StudentRequest studentRequest) {

        return new ResponseEntity(studentServices.createStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getAll/teacher")
    public ResponseEntity<String> getAllTeachers() {

        return new ResponseEntity(studentServices.getAllTeacher(), HttpStatus.OK);
    }
}
