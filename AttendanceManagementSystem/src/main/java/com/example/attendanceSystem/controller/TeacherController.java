package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.dto.request.TeacherRequest;
import com.example.attendanceSystem.dto.response.IdentityResponse;
import com.example.attendanceSystem.dto.response.TeacherResponse;
import com.example.attendanceSystem.services.TeacherService;
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
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/create/teacher")
    public ResponseEntity<IdentityResponse> createTeacher(@RequestBody TeacherRequest teacherRequest) {

        return new ResponseEntity(teacherService.createTeacher(teacherRequest), HttpStatus.CREATED);
    }


    @GetMapping("/getAll/teacher/course/{id}")
    public ResponseEntity<List<TeacherResponse>> getCourseByTeachers(@PathVariable String id) {

        return new ResponseEntity(teacherService.getAllTeacherInformation(id), HttpStatus.CREATED);
    }

    @PutMapping("/update/teacher/profile/{id}")
    public ResponseEntity<String> updateTeacherProfile(@PathVariable String id,
                                                          @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacherProfile( id, teacherRequest);
    }

    @DeleteMapping("/delete/teacher/profile/{id}")
    public ResponseEntity<String> deleteTeacherProfile(@PathVariable String id) {
        return teacherService.deleteTeacherProfile(id);
    }
}
