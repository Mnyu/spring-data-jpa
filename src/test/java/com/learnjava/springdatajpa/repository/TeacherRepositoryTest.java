package com.learnjava.springdatajpa.repository;


import com.learnjava.springdatajpa.entity.Course;
import com.learnjava.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest // This is not ideal
// @DataJpaTest // This is ideal
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course dbaCourse = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();
        Course javaCourse = Course.builder()
                .courseTitle("Java")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Santosh")
                .lastName("Kumar")
                //.courses(Arrays.asList(dbaCourse, javaCourse))
                .build();

        teacherRepository.save(teacher);
    }

}