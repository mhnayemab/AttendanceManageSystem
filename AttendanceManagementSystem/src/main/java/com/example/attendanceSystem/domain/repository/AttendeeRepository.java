package com.example.attendanceSystem.domain.repository;

import com.example.attendanceSystem.domain.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee,String> {


//    @Query("select from attendee_table where ")
    Optional<List<Attendee>> findAllByCourseIdAndStudentId(String courseId, String studentId);

}
