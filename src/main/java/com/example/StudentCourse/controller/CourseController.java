package com.example.StudentCourse.controller;

import com.example.StudentCourse.entity.Course;
import com.example.StudentCourse.repository.Courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/sc")
public class CourseController {
    @Autowired
    private Courserepo courserepo;
    @PostMapping("/hd")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course course1= courserepo.save(course);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Optional<Course> course=courserepo.findById(id);
        if(course.isPresent()){
            return ResponseEntity.ok().body(course.get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        courserepo.save(course);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        courserepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
