package org.example.api.model.request;

import lombok.Data;

@Data
public class IdeaRequestDto {

    private String owner;
    private String title;
    private String shortDescription;
    private String details;

}
