package com.learnjava.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private long teacherId;

    private String firstName;

    private String lastName;

//    @OneToMany(
//            cascade = CascadeType.ALL // CascadeType.ALL defined here for simplicity.
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId")
//    private List<Course> courses;

    // Though the above is correct technically but having a ManyToOne relation at a course level is much more intuitive,
    // readable and that is also a guidance provided by JPA specification to go for ManyToOne relationship whenever
    // possible.
}
