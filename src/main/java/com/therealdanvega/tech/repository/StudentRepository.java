package com.therealdanvega.tech.repository;

import com.therealdanvega.tech.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
