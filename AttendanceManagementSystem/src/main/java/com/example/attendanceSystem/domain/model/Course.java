package com.example.attendanceSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COURSE_BD")
public class Course {

    @Id
    private String id;

    private String courseCode;
    private String courseName;
    private String courseDescription;
    private String courseCredit;

    @ManyToOne
    private Teacher teacher;


}
