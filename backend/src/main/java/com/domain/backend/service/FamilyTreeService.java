package com.domain.backend.service;

import com.domain.backend.model.FamilyTree;

import java.util.List;
import java.util.Optional;

public interface FamilyTreeService {
    FamilyTree createFamilyTree(FamilyTree tree);

    Optional<FamilyTree> getFamilyTreeById(String treeId);

    List<FamilyTree> getFamilyTreesByOwnerId(String ownerId);

    List<FamilyTree> getFamilyTreesSharedWith(String userId);

    FamilyTree updateFamilyTree(String treeId, FamilyTree updatedTree);

    void deleteFamilyTree(String treeId);

    List<FamilyTree> getAllFamilyTrees();
}
