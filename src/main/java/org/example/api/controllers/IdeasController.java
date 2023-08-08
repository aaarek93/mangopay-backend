package org.example.api.controllers;

import lombok.RequiredArgsConstructor;
import org.example.api.model.request.IdeaRequestDto;
import org.example.api.model.response.IdeaResponseDto;
import org.example.services.IdeaService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("ideas")
public class IdeasController {

    private final IdeaService ideaService;

    @GetMapping
    public Iterable<IdeaResponseDto> getAll() {
        return ideaService.getAll();
    }

    @PostMapping
    public IdeaResponseDto create(@RequestBody IdeaRequestDto ideaRequestDto) {
        return ideaService.create(ideaRequestDto);
    }

}
