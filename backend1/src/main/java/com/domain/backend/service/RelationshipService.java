package com.domain.backend.service;

import com.domain.backend.model.Relationship;

import java.util.List;
import java.util.Optional;

public interface RelationshipService {
    Relationship addRelationship(Relationship relationship);

    Optional<Relationship> getRelationshipById(String relationshipId);

    List<Relationship> getRelationshipsByTreeId(String treeId);

    List<Relationship> getRelationshipsByMemberId(String memberId);

    void deleteRelationship(String relationshipId);

    List<Relationship> getAllRelationships();
}
