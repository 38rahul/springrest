package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/RestTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;


    @GetMapping("/getAllCourse")
    public ResponseEntity<String> getAllCourse(){
        return restTemplateService.allCourses();
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return restTemplateService.addCourse(course);
    }

    @GetMapping("/getCourse/{courseId}")
    public Course createCourse(@PathVariable Long courseId){
        System.out.println("Hit create Course Api");
        return restTemplateService.getCourseById(courseId);
    }

    @PutMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course){
        System.out.println("Hit create Update Course Api");
         restTemplateService.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        restTemplateService.deleteCourse(courseId);
    }
}
