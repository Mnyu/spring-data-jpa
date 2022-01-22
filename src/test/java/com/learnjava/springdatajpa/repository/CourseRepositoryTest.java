package com.learnjava.springdatajpa.repository;

import com.learnjava.springdatajpa.entity.Course;
import com.learnjava.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // This is not ideal
// @DataJpaTest // This is ideal
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void savCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course = Course.builder()
                .courseTitle("Python")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

}