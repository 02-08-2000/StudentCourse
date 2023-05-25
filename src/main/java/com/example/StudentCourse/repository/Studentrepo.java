package com.example.StudentCourse.repository;

import com.example.StudentCourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {

    Object deleteStudentById(Long sid);
}
