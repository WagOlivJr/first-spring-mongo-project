package com.mongo.service;

import com.mongo.entity.Student;
import com.mongo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
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

//    public Student getStudentById(String id) {
//        return studentRepository.findById(id).get();
//    }
}
