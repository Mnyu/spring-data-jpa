package com.learnjava.springdatajpa.repository;

import com.learnjava.springdatajpa.entity.Course;
import com.learnjava.springdatajpa.entity.Guardian;
import com.learnjava.springdatajpa.entity.Student;
import com.learnjava.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        Pageable firstPageWith3Records = PageRequest.of(0, 3);
        Pageable secondPageWith2Records = PageRequest.of(0, 2);

        List<Course> courses = courseRepository.findAll(secondPageWith2Records).getContent();
        long totalElements = courseRepository.findAll(secondPageWith2Records).getTotalElements();
        int totalPages = courseRepository.findAll(secondPageWith2Records).getTotalPages();
        System.out.println("Total Pages : " + totalPages);
        System.out.println("Total Elements : " + totalElements);
        System.out.println(courses);
    }

    @Test
    public void findAllPaginationAndSort() {
        Pageable page = PageRequest.of(0, 2, Sort.by("courseTitle"));
        List<Course> courses = courseRepository.findAll(page).getContent();
        System.out.println(courses);

        Pageable page2 = PageRequest.of(0, 2, Sort.by("credit").descending());
        courses = courseRepository.findAll(page2).getContent();
        System.out.println(courses);

        Pageable page3 = PageRequest.of(0, 2, Sort.by("courseTitle").descending().and(Sort.by("credit")));
        courses = courseRepository.findAll(page3).getContent();
        System.out.println(courses);
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageWith10Records = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByCourseTitleContaining("D", firstPageWith10Records).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Rakesh")
                .lastName("Sharma")
                .build();
        Student student = Student.builder()
                .emailId("abhi@gmail.com")
                .firstName("Abhishek")
                .lastName("Sharma")
                .build();

        Course course = Course.builder()
                .courseTitle("AI")
                .credit(7)
                .teacher(teacher)
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }

}