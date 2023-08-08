package org.example.services;

import org.example.api.model.request.IdeaRequestDto;
import org.example.api.model.response.IdeaResponseDto;

public interface IdeaService {

    IdeaResponseDto create(IdeaRequestDto ideaRequestDto);

    Iterable<IdeaResponseDto> getAll();
}
