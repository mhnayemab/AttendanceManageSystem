package com.example.attendanceSystem.domain.repository;

import com.example.attendanceSystem.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    List<Course> findAllByTeacherId(String id);
    List<Course> findAllByCourseCode(String id);
    Optional<Course> findAllById(String id);
}
