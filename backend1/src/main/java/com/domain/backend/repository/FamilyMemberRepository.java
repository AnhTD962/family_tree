package com.domain.backend.repository;

import com.domain.backend.model.FamilyMember;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FamilyMemberRepository extends MongoRepository<FamilyMember, String> {
    List<FamilyMember> findByTreeId(String treeId);

    List<FamilyMember> findByLastNameContainingIgnoreCase(String lastName);
}
