package com.example.attendanceSystem.domain.repository;

import com.example.attendanceSystem.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    Optional<Student> findAllById(String id);
    Optional<Student> findAllByStudentIdAndPassword(String id,String password);

    List<Student> findAllByStudentId(String id);
}
