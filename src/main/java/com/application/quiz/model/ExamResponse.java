package com.udaan.machine.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="exam_response")
public class ExamResponse {

    @Id
    @GeneratedValue
    @Column(name="id" , updatable = false , unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne
    @JoinColumn(name="question_id")
    private Question question;

    @Column(name="response")
    private String response;

}
