package com.example.attendanceSystem.services;


import com.example.attendanceSystem.domain.model.Course;
import com.example.attendanceSystem.domain.model.RegistrationCourse;
import com.example.attendanceSystem.domain.model.Student;
import com.example.attendanceSystem.domain.model.Teacher;
import com.example.attendanceSystem.domain.repository.CourseRepository;
import com.example.attendanceSystem.domain.repository.RegistrationCourseRepository;
import com.example.attendanceSystem.domain.repository.StudentRepository;
import com.example.attendanceSystem.domain.repository.TeacherRepository;
import com.example.attendanceSystem.dto.response.IdentityResponse;
import com.example.attendanceSystem.dto.response.TeacherResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentRegistrationCourseServices {

    private final RegistrationCourseRepository registrationCourseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public IdentityResponse registrationOnCourseByTeacherAndCourseId(String studentId, String teacherId, String courseId) {

        Optional<Teacher> teacherOptional = teacherRepository.findAllById(teacherId);
        Teacher teacher = teacherOptional.get();

        Optional<Course> courseOptional = courseRepository.findAllById(courseId);
        Course course = courseOptional.get();

        Optional<Student> studentOptional = studentRepository.findAllById(studentId);
        Student student = studentOptional.get();

        String uuid = UUID.randomUUID().toString();

        RegistrationCourse registrationCourse = new RegistrationCourse();


        registrationCourse.setId(uuid);
        registrationCourse.setTeacher(teacher);
        registrationCourse.setCourse(course);
        registrationCourse.setStudent(student);

        registrationCourseRepository.saveAndFlush(registrationCourse);

        return new IdentityResponse(uuid);
    }

    public List<Student> getAllStudentRegistrationCoursesByCourseId(String id) {


        List<Student> studentList = new ArrayList<>();

        List<RegistrationCourse> registrationCourseOptional = registrationCourseRepository.findAllByCourseId(id);

        for (RegistrationCourse registrationCourse : registrationCourseOptional) {
            studentList.add(registrationCourse.getStudent());
        }

        return studentList;

    }


    public List<TeacherResponse> getAllStudentRegistrationCoursesByStudentId(String id) {

        List<TeacherResponse> teacherResponseArrayList = new ArrayList<>();
        List<RegistrationCourse> registrationCourseOptional = registrationCourseRepository.findAllByStudentId(id);

        for (RegistrationCourse registrationCourse : registrationCourseOptional) {

            Course course = registrationCourse.getCourse();
            Teacher teacher = registrationCourse.getTeacher();

            TeacherResponse teacherResponse = new TeacherResponse();
            teacherResponse.setTeacherId(teacher.getTeacherId());
            teacherResponse.setFirstName(teacher.getFirstName());
            teacherResponse.setMobileNo(teacher.getMobileNo());
            teacherResponse.setDepartment(teacher.getDepartment());
            teacherResponse.setTeacherDesignation(teacher.getTeacherDesignation());
            teacherResponse.setTeacherExpertise(teacher.getTeacherExpertise());
            teacherResponse.setId(course.getId());
            teacherResponse.setCourseCode(course.getCourseCode());
            teacherResponse.setCourseName(course.getCourseName());
            teacherResponse.setCourseDescription(course.getCourseDescription());
            teacherResponse.setCourseCredit(course.getCourseCredit());
            teacherResponseArrayList.add(teacherResponse);
        }
        return teacherResponseArrayList;
    }
}
