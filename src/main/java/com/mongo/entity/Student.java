package com.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "mail")
    private String email;
    @DBRef
    private Department department;
    @DBRef
    private List<Subject> subjects;

    @Transient
    private double percentage;

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
