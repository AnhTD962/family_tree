package com.domain.backend.service.impl;

import com.domain.backend.model.FamilyTree;
import com.domain.backend.repository.FamilyTreeRepository;
import com.domain.backend.service.FamilyTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyTreeServiceImpl implements FamilyTreeService {

    @Autowired
    private FamilyTreeRepository familyTreeRepository;

    @Override
    public FamilyTree createFamilyTree(FamilyTree tree) {
        return familyTreeRepository.save(tree);
    }

    @Override
    public Optional<FamilyTree> getFamilyTreeById(String treeId) {
        return familyTreeRepository.findById(treeId);
    }

    @Override
    public List<FamilyTree> getFamilyTreesByOwnerId(String ownerId) {
        return familyTreeRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<FamilyTree> getFamilyTreesSharedWith(String userId) {
        return familyTreeRepository.findBySharedWithContaining(userId);
    }

    @Override
    public FamilyTree updateFamilyTree(String treeId, FamilyTree updatedTree) {
        updatedTree.setId(treeId);
        return familyTreeRepository.save(updatedTree);
    }

    @Override
    public void deleteFamilyTree(String treeId) {
        familyTreeRepository.deleteById(treeId);
    }

    @Override
    public List<FamilyTree> getAllFamilyTrees() {
        return familyTreeRepository.findAll();
    }
}
