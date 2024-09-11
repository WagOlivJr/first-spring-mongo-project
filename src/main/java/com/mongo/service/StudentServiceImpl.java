package com.mongo.service;

import com.mongo.entity.Student;
import com.mongo.repository.DepartmentRepository;
import com.mongo.repository.StudentRepository;
//import com.mongo.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ANotação de componente service, indica que é uma camada de lógica de negócios da aplicação, a ser gerenciada pelo Spring
@AllArgsConstructor // Lombok
public class StudentServiceImpl implements StudentService { // Implementa a interface que está associada à camada do controlador, respeitando o princípio SOLID
    StudentRepository studentRepository; // Cria uma instancia da interface StudentRepository para herdar os metodos Spring.
    // nao precisa da anotação @Autowired porque spring entende que que uma classe dentro do constructor que compõe o contexto da aplicação (Service, no caso) deve ser gerenciada por ele também,
//    Com lombok, o constructor é criado automaticamente, então apenas especificar que a classe possui uma instância de outra classe já é suficiente para que Spring entenda que deve gerencia a classe instanciada também.

    //
//    SubjectRepository subjectRepository; // não existe repository para essa entidade, que pertence à entidade student no banco, por isso não precisa dessa linha.
    DepartmentRepository departmentRepository; // Mesma lógica da instância de StudentRepository, com o adendo de que isso é necessário apenas porque temos uma lógica relacional no mongo.
    // temos uma classe/collection para este item e precisamos dele aqui para buscar Student pelos atributos dessa classe.

    @Override // Anotação indica que o metodo a seguir sobrescreve o metodo da classe/interface que essa classe estende/implementa
    public Student createStudent(Student student) {
        if(student.getDepartment() != null) { //checa se o atributo existe para evitar exceptions
            departmentRepository.save(student.getDepartment()); // salva o atributo em sua collection no banco. necessário para a lógica relacional no mongo
        }
//        if(student.getSubjects() != null && !student.getSubjects().isEmpty()) {
//            subjectRepository.saveAll(student.getSubjects()); // mesma coisa do primeiro bloco if, não é necessário pois o essa entidade já pertence à entidade Student no banco.
//        }
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get(); // precisa do get pois retorna Optional.
        // O ideal é tratar com isPresent, If ou try catch para gerenciar exceções.
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
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize); // Cria uma instancia de Pageable para setar paginação da busca. precisa ser pageNumber - 1 porque é zerobased
        return studentRepository.findAll(pageable).getContent(); // Precisa de getContent para converter o retorno Page<Student> em List<Student>
    }

    @Override
    public List<Student> getAllWithSorting() {
//        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Sort sort = Sort.by("name"); //Cria uma instancia de Sort para definir regra de ordenação da lista encontrada. Pode receber mais de um atributo de ordenação e pode ser combinado com Pageable pelo metodo findAll()
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

}
