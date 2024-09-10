package com.mongo.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Subject {
//    @Id // não há id para este objeto pelo fato de pertencer ao object student no mongoDB
//    private String id;

    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private Long marksObtained;
    

}
