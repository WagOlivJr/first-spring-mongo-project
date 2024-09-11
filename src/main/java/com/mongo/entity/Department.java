package com.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data //Lombok
@Document // Aqui necessário para ilustrar lógica relacional em um banco NoSQL.
// não precisa indicar o nome porque é o mesmo do banco e não é composto.
public class Department {
    @Id // Precis
    private String id;
    @Field(name = "department_name")
    private String departmentName;

//    @Field(name = "location") // Não precisa desta anotação pelo nome ser igual. Checar demais campos
    private String location;

}
