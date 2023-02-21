package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateService {
    RestTemplate restTemplate = new RestTemplate();

    private static final String getAllCourseUrl = "http://localhost:9090/courses";
    private static final String addEmployeeUrl = "http://localhost:9090/courses";
    private static final String getEmpByIdUrl = "http://localhost:9090/courses/{courseId}";
    private static final String updateCourseUrl = "http://localhost:9090/courses/";
    private static final String deleteCourseUrl = "http://localhost:9090/courses/{courseId}";


    // method to get All Employees
    public ResponseEntity<String> allCourses(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(getAllCourseUrl, HttpMethod.GET,entity,String.class);
        return response;
    }

    public ResponseEntity<Course> addCourse(Course course){
       return  restTemplate.postForEntity(addEmployeeUrl,course,Course.class);

    }

    public Course getCourseById(long courseId){
        Map<String,Long> param = new HashMap<String,Long>();
        param.put("courseId",courseId);
       return  restTemplate.getForObject(getEmpByIdUrl,Course.class,param);
    }

    public void updateCourse(Course course){
         restTemplate.put(updateCourseUrl, course);
    }

    public void deleteCourse(long courseId){
        Map<String, Long> param = new HashMap<String,Long>();
        param.put("courseId",courseId);
        restTemplate.delete(deleteCourseUrl,param);
    }

}
