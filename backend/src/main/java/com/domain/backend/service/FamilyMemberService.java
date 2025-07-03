package com.domain.backend.service;

import com.domain.backend.model.FamilyMember;

import java.util.List;
import java.util.Optional;

public interface FamilyMemberService {
    FamilyMember addFamilyMember(FamilyMember member);

    Optional<FamilyMember> getFamilyMemberById(String memberId);

    List<FamilyMember> getFamilyMembersByTreeId(String treeId);

    List<FamilyMember> searchFamilyMembersByLastName(String lastName);

    FamilyMember updateFamilyMember(String memberId, FamilyMember updatedMember);

    void deleteFamilyMember(String memberId);

    List<FamilyMember> getAllFamilyMembers();
}
