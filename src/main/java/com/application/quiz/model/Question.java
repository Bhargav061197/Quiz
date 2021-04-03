package com.udaan.machine.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="question")
@Data
@TypeDef(
    name = "string-array",
    typeClass = StringArrayType.class
)
public class Question {

    @Id
    @GeneratedValue
    @Column(name="id" , updatable = false , unique = true)
    private UUID id;

    @Column(name="description")
    private String description;

    @ManyToMany
    List<Quiz> quiz;

    @Type(type = "string-array")
    @Column(
        name = "options",
        columnDefinition = "text[]"
    )
    private String[] options;

    @Column(name="answer")
    private String answer;

}
