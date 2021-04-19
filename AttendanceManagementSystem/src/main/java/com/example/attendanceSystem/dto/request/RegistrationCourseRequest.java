package com.example.attendanceSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationCourseRequest {

 private String studentId;
 private String studentName;
 private String department;
 private String currentSemester;

}
