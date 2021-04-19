package com.example.attendanceSystem.domain.repository;

import com.example.attendanceSystem.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {

    Optional<Teacher> findAllById(String id);

    Optional<Teacher>  findAllByTeacherIdAndPassword(String id,String password);
}
