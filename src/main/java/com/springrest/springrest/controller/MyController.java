package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;



    @GetMapping("/home")
    public String home(){
        return "Welcome to Courese Application";
    }
    // get the courses
    @GetMapping("/courses")
    public List<Course> getCourses (){
            return this.courseService.getCourses();
    }

    @GetMapping ("/courses/{courseId}")
    public  Course getCourse(@PathVariable String courseId){
        Optional<Course> optionalCourse  = this.courseService.getCourse(Long.parseLong(courseId));
        return optionalCourse.get();
    }

    // Add the course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody  Course course){
        return this.courseService.addCourse(course);
    }

    // update the course using put request
    @PutMapping ("/courses")
    public  Course updateCourse(@RequestBody  Course course){
        return this.courseService.updateCourse(course);
    }

    // Delete the course
//    @DeleteMapping("/courses/{courseId}")
//    public ResponseEntity<HttpStatus> deleteCOurse(@PathVariable String courseId){
//        try{
//            this.courseService.deleteCourse(Long.parseLong(courseId));
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
///   }


@DeleteMapping("/courses/{courseId}")
public String deleteCOurse(@PathVariable String courseId){
      return this.courseService.deleteCourse(Long.parseLong(courseId));
}



}
