package com.domain.backend.repository;

import com.domain.backend.model.FamilyTree;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FamilyTreeRepository extends MongoRepository<FamilyTree, String> {
    List<FamilyTree> findByOwnerId(String ownerId);
    List<FamilyTree> findBySharedWithContaining(String userId);
}
