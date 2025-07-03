package com.domain.backend.service.impl;

import com.domain.backend.model.Relationship;
import com.domain.backend.repository.RelationshipRepository;
import com.domain.backend.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Override
    public Relationship addRelationship(Relationship relationship) {
        return relationshipRepository.save(relationship);
    }

    @Override
    public Optional<Relationship> getRelationshipById(String relationshipId) {
        return relationshipRepository.findById(relationshipId);
    }

    @Override
    public List<Relationship> getRelationshipsByTreeId(String treeId) {
        return relationshipRepository.findByTreeId(treeId);
    }

    @Override
    public List<Relationship> getRelationshipsByMemberId(String memberId) {
        return relationshipRepository.findByMemberId1OrMemberId2(memberId, memberId);
    }

    @Override
    public void deleteRelationship(String relationshipId) {
        relationshipRepository.deleteById(relationshipId);
    }

    @Override
    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }
}
