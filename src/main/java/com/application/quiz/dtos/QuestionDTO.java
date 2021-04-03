package com.udaan.machine.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionDTO {

    @JsonProperty("description")
    private String description;

    @JsonProperty("options")
    private String[] options;

    @JsonProperty("answer")
    private String answer;
}
