package com.mongo.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data //Lombok, gerar tudo
//@Document(collection = "subject") // Utilizar apenas se existir a collection no banco.
public class Subject {
//    @Id // não há anotação de Id para este objeto pelo fato de pertencer ao object student no mongoDB
//    private String id; Não há ID para esse objeto

    @Field(name = "subject_name") // tem que especificar o nome do atributo nestes casos, ou o atributo receberá o mesmo nome com camelCase no banco.
    private String subjectName;
    @Field(name = "marks_obtained")
    private Long marksObtained;

//    public Long getMarksObtained() {
//        return marksObtained;
//    }
}
