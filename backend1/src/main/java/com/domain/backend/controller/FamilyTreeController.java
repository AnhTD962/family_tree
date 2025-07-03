package com.domain.backend.controller;

import com.domain.backend.model.FamilyTree;
import com.domain.backend.service.FamilyTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family-trees")
public class FamilyTreeController {
    private final FamilyTreeService familyTreeService;

    @Autowired
    public FamilyTreeController(FamilyTreeService familyTreeService) {
        this.familyTreeService = familyTreeService;
    }

    @PostMapping
    public ResponseEntity<FamilyTree> createFamilyTree(@RequestBody FamilyTree tree) {
        FamilyTree created = familyTreeService.createFamilyTree(tree);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{treeId}")
    public ResponseEntity<FamilyTree> getFamilyTree(@PathVariable String treeId) {
        return familyTreeService.getFamilyTreeById(treeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{treeId}")
    public ResponseEntity<FamilyTree> updateFamilyTree(@PathVariable String treeId, @RequestBody FamilyTree updatedTree) {
        FamilyTree tree = familyTreeService.updateFamilyTree(treeId, updatedTree);
        return ResponseEntity.ok(tree);
    }

    @DeleteMapping("/{treeId}")
    public ResponseEntity<Void> deleteFamilyTree(@PathVariable String treeId) {
        familyTreeService.deleteFamilyTree(treeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<FamilyTree>> getFamilyTreesByOwner(@PathVariable String ownerId) {
        return ResponseEntity.ok(familyTreeService.getFamilyTreesByOwnerId(ownerId));
    }

    @GetMapping("/shared/{userId}")
    public ResponseEntity<List<FamilyTree>> getFamilyTreesSharedWith(@PathVariable String userId) {
        return ResponseEntity.ok(familyTreeService.getFamilyTreesSharedWith(userId));
    }

    @GetMapping
    public ResponseEntity<List<FamilyTree>> getAllFamilyTrees() {
        return ResponseEntity.ok(familyTreeService.getAllFamilyTrees());
    }
}
