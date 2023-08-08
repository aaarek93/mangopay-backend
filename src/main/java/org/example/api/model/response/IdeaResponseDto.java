package org.example.api.model.response;

import lombok.Data;

@Data
public class IdeaResponseDto {

    private String ideaId;
    private String owner;
    private String title;
    private String shortDescription;
    private String details;

}
