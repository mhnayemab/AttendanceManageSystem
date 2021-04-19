package com.example.attendanceSystem.domain.repository;

import com.example.attendanceSystem.domain.model.RegistrationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationCourseRepository extends JpaRepository<RegistrationCourse, String> {

    List<RegistrationCourse> findAllByStudentId(String id);
    List<RegistrationCourse> findAllByCourseId(String id);

}
