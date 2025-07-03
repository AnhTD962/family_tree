package com.domain.backend.repository;

import com.domain.backend.model.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {
    List<Relationship> findByTreeId(String treeId);

    List<Relationship> findByMemberId1OrMemberId2(String memberId1, String memberId2);
}
