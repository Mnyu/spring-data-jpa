package com.learnjava.springdatajpa.repository;

import com.learnjava.springdatajpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByCourseTitleContaining(String title, Pageable pageable);
}
