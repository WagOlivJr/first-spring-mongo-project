package com.mongo.service;

import com.mongo.entity.Student;
import com.mongo.repository.DepartmentRepository;
import com.mongo.repository.StudentRepository;
import com.mongo.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    SubjectRepository subjectRepository;
    DepartmentRepository departmentRepository;

    @Override
    public Student createStudent(Student student) {
        if(student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects() != null && !student.getSubjects().isEmpty()) {
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("Inside getAllStudents() method of StudentServiceImpl");
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.delete(getStudentById(id));
    }

    @Override
    public Student getStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentByNameContaining(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Student updateStudent(Student student, String id) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllWithSorting() {
//        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Sort sort = Sort.by("name");
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> byDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Student> bySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    @Override
    public List<Student> byEmailIsLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    @Override
    public List<Student> byEmailContaining(String email) {
        return studentRepository.findByEmailContaining(email);
    }

    @Override
    public List<Student> byNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Student> byDepartmentId(String departmentId) {
        return studentRepository.findByDepartmentId(departmentId);
    }

//    public Student getStudentById(String id) {
//        return studentRepository.findById(id).get();
//    }
}
