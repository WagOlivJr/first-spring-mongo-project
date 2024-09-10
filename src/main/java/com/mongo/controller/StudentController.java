package com.mongo.controller;

import com.mongo.entity.Student;
import com.mongo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping("/name/{name}/email/{email}")
    public ResponseEntity<Student> getStudentByNameAndEmail(@PathVariable String name, @PathVariable String email) {
        return new ResponseEntity<>(studentService.getStudentByNameAndEmail(name, email),HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getStudentByName(name),HttpStatus.OK);
    }
    @GetMapping("/namecontaining/{name}")
    public ResponseEntity<List<Student>> getStudentByNameContaining(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getStudentByNameContaining(name),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
        System.out.println("passou aqui");
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/update/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @GetMapping("/allWithPagination")
    public ResponseEntity<List<Student>>getAllWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        System.out.println("Controller");
        return new ResponseEntity<>(studentService.getAllWithPagination(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/allWithSorting")
    public List<Student>getAllWithSorting() {
//    public ResponseEntity<List<Student>>getAllWithSorting() {
        return studentService.getAllWithSorting();
//        return new ResponseEntity<>(studentService.getAllWithSorting(), HttpStatus.OK);
    }

}
