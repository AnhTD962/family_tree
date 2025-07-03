package com.domain.backend.service.impl;

import com.domain.backend.model.FamilyMember;
import com.domain.backend.repository.FamilyMemberRepository;
import com.domain.backend.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    public FamilyMemberServiceImpl(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    @Override
    public FamilyMember addFamilyMember(FamilyMember member) {
        return familyMemberRepository.save(member);
    }

    @Override
    public Optional<FamilyMember> getFamilyMemberById(String memberId) {
        return familyMemberRepository.findById(memberId);
    }

    @Override
    public List<FamilyMember> getFamilyMembersByTreeId(String treeId) {
        return familyMemberRepository.findByTreeId(treeId);
    }

    @Override
    public List<FamilyMember> searchFamilyMembersByLastName(String lastName) {
        return familyMemberRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public FamilyMember updateFamilyMember(String memberId, FamilyMember updatedMember) {
        updatedMember.setId(memberId);
        return familyMemberRepository.save(updatedMember);
    }

    @Override
    public void deleteFamilyMember(String memberId) {
        familyMemberRepository.deleteById(memberId);
    }

    @Override
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }
}
