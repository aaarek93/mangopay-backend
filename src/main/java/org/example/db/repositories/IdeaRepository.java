package org.example.db.repositories;

import org.example.db.entities.IdeaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IdeaRepository extends CrudRepository<IdeaEntity, Long> {
}
