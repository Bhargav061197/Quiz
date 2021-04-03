package com.udaan.machine.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="exam")
public class Exam {

    @Id
    @GeneratedValue
    @Column(name="id" , updatable = false , unique = true)
    private UUID id;

    @OneToMany(mappedBy = "exam")
    private List<ExamResponse> examResponses;

}
