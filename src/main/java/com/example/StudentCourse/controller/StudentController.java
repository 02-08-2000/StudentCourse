package com.example.StudentCourse.controller;

import com.example.StudentCourse.entity.Course;
import com.example.StudentCourse.entity.Student;
import com.example.StudentCourse.repository.Courserepo;
import com.example.StudentCourse.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/s")
public class StudentController{
    @Autowired
    private Studentrepo studentrepo;
    @Autowired
    private Courserepo courserepo;
    @PostMapping("/sd")
        public ResponseEntity<Student> addStudent(@RequestBody Student  student){
        return ResponseEntity.ok(studentrepo.save(student));
        }
        @GetMapping("/s")
    public void getById(@PathVariable Long id){
        studentrepo.findById(id);
        }
        @GetMapping("/n")
    public void getStudent(@PathVariable String name){
        studentrepo.findAll();
        }
        @PutMapping("jkx")
    public void update(@RequestBody Student student,@PathVariable Long sid){
            Optional<Student> student1=studentrepo.findById(sid);
        Student st=student1.get();
        st.setName(student.getName());
        st.setSid(student.getSid());
        studentrepo.save(student);
        }
        @DeleteMapping("/")
    public void delete(@PathVariable Long sid){
        Optional<Student> studentOptional=studentrepo.findById(sid);
        Student student=studentOptional.get();
        studentrepo.delete(student);
        }

    }
