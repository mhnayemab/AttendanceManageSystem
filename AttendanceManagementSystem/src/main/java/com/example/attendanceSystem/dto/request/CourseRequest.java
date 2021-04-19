package com.example.attendanceSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String id;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private String courseCredit;
}
