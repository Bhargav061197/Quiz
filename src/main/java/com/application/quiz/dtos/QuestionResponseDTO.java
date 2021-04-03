package com.udaan.machine.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class QuestionResponseDTO {

    private UUID questionId;

    private String response;
}
