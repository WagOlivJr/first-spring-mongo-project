package com.mongo.repository;

import com.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByNameAndEmail(String name, String email);
    Student findByName(String name);
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByDepartmentDepartmentName(String departmentName);
    List<Student> findBySubjectsSubjectName(String subjectName);
    List<Student> findByEmailIsLike(String email);
    List<Student> findByEmailContaining(String email);
    List<Student> findByNameStartsWith(String name);
    List<Student> findByDepartmentId(String departmentId);
}
