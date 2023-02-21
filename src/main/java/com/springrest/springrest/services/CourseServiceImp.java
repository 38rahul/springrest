package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements  CourseService{

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;


    public CourseServiceImp(){

//        list = new ArrayList<>();
//        list.add(new Course(123,"Spring Boot", "Creating rest api using Spring boot"));
//        list.add(new Course(145 , "Core java","This course contains basics of java"));
//        list.add(new Course(12,"Spring Boot", "Creating rest api using Spring boot"));
//        list.add(new Course(1,"Spring Boot", "Creating rest api using Spring boot"));
        }
    @Override
    public List<Course> getCourses() {

        return courseDao.findAll();

    }

    @Override
    public Optional<Course> getCourse(long courseId) {
//        Course c=  null;
//        for(Course course : list ){
//            //System.out.println(courseId);
//            //System.out.println( course.getId());
//                    if(course.getId() == courseId) {
//                        c = course;
//                        break;
//                    }
//        }
        return  courseDao.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

//        list.forEach(e ->{
//            if(e.getId()==course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);
        return course;
    }

//    @Override
//    public Optional<> deleteCourse(long parseLong) {
////        list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//        return courseDao.findById(parseLong);
//

   // }
    public String deleteCourse (long parseLong) {
        courseDao.deleteById(parseLong);
        return "Request has been Deleted";
    }
}

