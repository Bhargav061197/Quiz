package com.udaan.machine.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udaan.machine.model.Question;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class QuizDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("questions")
    private List<UUID> ids;
}
