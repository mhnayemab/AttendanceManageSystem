package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.dto.request.CourseRequest;
import com.example.attendanceSystem.dto.response.IdentityResponse;
import com.example.attendanceSystem.dto.response.TeacherResponse;
import com.example.attendanceSystem.services.CourseService;
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
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create/course/teacher/{id}")
    public ResponseEntity<IdentityResponse> createCalendar(@PathVariable String id, @RequestBody CourseRequest courseRequest) {

        return new ResponseEntity(courseService.createCourseByTeacher(id,courseRequest), HttpStatus.CREATED);
    }


    @GetMapping("/courses")
    public ResponseEntity<List<TeacherResponse>> getAllCourse() {

        return new ResponseEntity(courseService.getAllCourse(), HttpStatus.CREATED);
    }
}
