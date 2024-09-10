package com.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "department")
public class Department {
    @Id
    private String id;
    @Field(name = "department_name")
    private String departmentName;

//    @Field(name = "location") // Não precisa desta anotação pelo nome ser igual. Checar demais campos, inclusive correspondencia camelCase e snake_case
    private String location;

}
