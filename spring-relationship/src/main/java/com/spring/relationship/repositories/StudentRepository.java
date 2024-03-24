package com.spring.relationship.repositories;

import com.spring.relationship.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
