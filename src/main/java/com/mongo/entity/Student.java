package com.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data // Lombok, gera tudo: getters, setters, constructors, etc
//@Document(collection = "student") // anotação indica que classe equivale a uma collection do mongo.
@Document // Como o nome da classe é o mesmo nome da collection, o nome da colletion não precisa ser informado.
// Se os nomes não baterem (inclusive sendo maiscula aqui e minuscula no banco), uma colletion é criada no banco.
public class Student {
    @Id //indica que é o ID do mongo e aparentemente não precisa informar o nome
    private String id;
    @Field  // indica que é um atributo do documento e faz a mesma verificação por nome e notações banco/java
    private String name;
    @Field(name = "mail") // anotação com name pois há diferença entre banco e app
    private String email;
    @DBRef //Indica relacionamento entre colletions do mongo. A classe relacionada precisa ser uma entidade, precisa ter anotação @Document e no banco apenas os ids fazem o relacionamento.
    private Department department;

//    @DBRef // Caso a entidade de fato possua outras subentidades no banco, não precisa dessa anotação,
//    respeita a lógica nosql e é tratada apenas como uma uma relação de entidade pai e filhos.
    private List<Subject> subjects;

    @Transient // Indica que o atributo não deve ser persistido no banco de dados.
    private double percentage; //Neste caso, é pelo simples faot de ser um atributo lógico, obtido com uma função que que itera sobre atributos que estão no banco

    public double getPercentage() {
        if(subjects != null && !subjects.isEmpty()) {
            int total = 0;
            for(Subject subject: subjects) {
                total += subject.getMarksObtained();
            }
//            return total / subjects.size(); // entender porque arredonda para integer antes do Cast Converting
            return (double) total /subjects.size();
        }
        return 0.00;
    }
}
