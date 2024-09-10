package com.mongo.service;

import com.mongo.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id);
    void deleteStudentById(String id);
    Student getStudentByNameAndEmail(String name, String email);
    Student getStudentByName(String name);
    List<Student> getStudentByNameContaining(String name);
    Student updateStudent(Student student, String id);
    List<Student> getAllWithPagination(int pageNumber, int pageSize);
    List<Student> getAllWithSorting();
    List<Student> byDepartmentName(String departmentName);
    List<Student> bySubjectName(String subjectName);
    List<Student> byEmailIsLike(String email);
    List<Student> byEmailContaining(String email);
    List<Student> byNameStartsWith(String name);
    List<Student> byDepartmentId(String departmentId);
}
