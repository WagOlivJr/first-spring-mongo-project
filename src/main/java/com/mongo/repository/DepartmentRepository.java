package com.mongo.repository;

import com.mongo.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> { // Interface precisa implementar MongoRepository para herdar metodos padrão
    // e pelo fato da entidade existir de fato no mongo separadamente
    // recebe metodos aqui caso os metodos padrão não sejam suficientes.
}
