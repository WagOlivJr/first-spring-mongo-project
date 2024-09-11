package com.mongo.service;

import com.mongo.entity.Student;

import java.util.List;

public interface StudentService { // Interface para respeitar a lógica do Loose coupling.
    // ela não implementa os mestodos, apenas os norteia para que a classe implementadora o faça.
    // A grande vantagem aqui é que se por algum motivo for preciso mudar a implementação dos métodos, apenas a classe implementadora sofrerá alterações.
    // A interface a quem os metodos pertencem e que está referenciada na camada do controlador não sofrerá alteração.
    // Logo, o controlador está com acoplamento fraco com a implementação dos metodos que utiliza. Esse é um princípio SOLID
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
