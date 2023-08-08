package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.api.model.request.IdeaRequestDto;
import org.example.api.model.response.IdeaResponseDto;
import org.example.db.entities.IdeaEntity;
import org.example.db.repositories.IdeaRepository;
import org.example.exceptions.CreateIdeaException;
import org.example.utils.IdeasUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;
    private final IdeasUtils ideasUtils;
    private static final int userIdLength = 20;

    @Override
    public IdeaResponseDto create(IdeaRequestDto ideaRequestDto) {
        IdeaEntity ideaEntityToSave = ideasUtils.makeInstanceFromObject(ideaRequestDto, IdeaEntity.class);
        ideaEntityToSave.setIdeaId(ideasUtils.generateStringOfLength(userIdLength));
        try {
            IdeaEntity savedUserEntity = ideaRepository.save(ideaEntityToSave);
            return ideasUtils.makeInstanceFromObject(savedUserEntity, IdeaResponseDto.class);
         } catch (Exception e) {
            throw new CreateIdeaException("Your request body is wrong");
        }
    }

    @Override
    public Iterable<IdeaResponseDto> getAll() {
        Iterable<IdeaEntity> allEntities = ideaRepository.findAll();
        return ideasUtils.makeInstancesFromObjects(allEntities, IdeaResponseDto.class);
    }
}
