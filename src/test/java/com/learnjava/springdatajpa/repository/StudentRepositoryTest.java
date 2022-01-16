package com.learnjava.springdatajpa.repository;

import com.learnjava.springdatajpa.entity.Guardian;
import com.learnjava.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest // This is not ideal
// @DataJpaTest // This is ideal
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .name("Suresh")
                .email("suresh@gmail.com")
                .mobile("9876543210")
                .build();
        Student student = Student.builder()
                .emailId("rohit@gmail.com")
                .firstName("Rohit")
                .lastName("Sharma")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void printStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Virat");
        System.out.println(students);
    }

    @Test
    public void printStudentsByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("i");
        System.out.println(students);
    }

    @Test
    public void printStudentsBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Suresh");
        System.out.println(students);
    }

    @Test
    public void getStudentByEmailAddressTest() {
        Student student = studentRepository.getStudentByEmailAddress("rohit@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByEmailAddressTest() {
        System.out.println(studentRepository.getStudentFirstNameByEmailAddress("rohit@gmail.com"));
    }

    @Test
    public void getStudentByEmailAddressNativeTest() {
        Student student = studentRepository.getStudentByEmailAddressNative("virat@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParamTest() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("virat@gmail.com");
        System.out.println(student);
    }
}