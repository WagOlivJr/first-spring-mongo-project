package com.mongo.repository;

import com.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository //Não precisa dessa anotação pelo fato da interface estender uma classe/interface do Spring Data
public interface StudentRepository extends MongoRepository<Student, String> { // A interface implementada é uma raw class e deve receber a classe da entidade e do ID da entidade

    Student findByNameAndEmail(String name, String email); //Neste caso, é criado facilmente um novo metodo indicando em seu nome atributos da entidade.
    // os nomes tem que bater, inclsuvie camelCase, assim como a ordem em que aparecem nos parametors do metodo.
    Student findByName(String name); // mesma lógca acima mas com apenas um atributo
    List<Student> findByNameContainingIgnoreCase(String name); // agora considera a busca por nome mas checando se a string informada é igual ou pertence à string no banco, e ainda é case Insensitive.
    List<Student> findByDepartmentDepartmentName(String departmentName); // indica busca por atributos fora da raiz do doc no banco.
    // mesmas regras acima de nomenclatura. voltado para entidades cuja lógica no banco é NOSQL
    List<Student> findBySubjectsSubjectName(String subjectName); // Mesma lógica do metodo acima
    List<Student> findByEmailIsLike(String email); // Mesma coisa que Containing
    List<Student> findByEmailContaining(String email); // Mesma coisa que IsLike
    List<Student> findByNameStartsWith(String name); // busca por um atributo da entidade mas agora com StartsWith
    List<Student> findByDepartmentId(String departmentId); // aqui o metodo busca a entidade em questão, mas pelo id de outra entidade a ela relacionada no banco, com lógica relacional.
    // se não fosse com lógica relacional, não seria permitido um mesmo doc que ter Id de duas entidades.
}
