package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.domain.model.Student;
import com.example.attendanceSystem.dto.response.IdentityResponse;
import com.example.attendanceSystem.services.StudentRegistrationCourseServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationCourseController {

    private final StudentRegistrationCourseServices studentRegistrationCourseServices;

    @PostMapping("/student/registration/by/{studentId}/teacher/{teacherId}/course/{courseId}")
    public ResponseEntity<IdentityResponse> registrationCourse(@PathVariable("studentId") String studentId,@PathVariable("teacherId") String teacherId, @PathVariable("courseId") String courseId) {

        return new ResponseEntity(studentRegistrationCourseServices.registrationOnCourseByTeacherAndCourseId(studentId,teacherId,courseId), HttpStatus.CREATED);
    }

    @GetMapping("/getAll/registration/course/{id}")
    public ResponseEntity<List<Student>> getAllRegistrationCourse(@PathVariable String id) {

        return new ResponseEntity(studentRegistrationCourseServices.getAllStudentRegistrationCoursesByCourseId(id), HttpStatus.OK);
    }
    @GetMapping("/getAll/registration/students/{id}")
    public ResponseEntity<List<Student>> getAllRegistrationCourseByStudentId(@PathVariable String id) {

        return new ResponseEntity(studentRegistrationCourseServices.getAllStudentRegistrationCoursesByStudentId(id), HttpStatus.OK);
    }
}
