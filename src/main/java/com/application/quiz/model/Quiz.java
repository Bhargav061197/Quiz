package com.udaan.machine.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue
    @Column(name = "id" , updatable = false, unique = true)
    private UUID id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "quiz" , fetch = FetchType.EAGER)
    List<Question> questions;

}
