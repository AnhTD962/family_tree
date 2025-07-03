package com.domain.backend.controller;

import com.domain.backend.model.Relationship;
import com.domain.backend.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipController {
    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public ResponseEntity<Relationship> addRelationship(@RequestBody Relationship relationship) {
        Relationship created = relationshipService.addRelationship(relationship);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{relationshipId}")
    public ResponseEntity<Relationship> getRelationship(@PathVariable String relationshipId) {
        return relationshipService.getRelationshipById(relationshipId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tree/{treeId}")
    public ResponseEntity<List<Relationship>> getRelationshipsByTree(@PathVariable String treeId) {
        return ResponseEntity.ok(relationshipService.getRelationshipsByTreeId(treeId));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Relationship>> getRelationshipsByMember(@PathVariable String memberId) {
        return ResponseEntity.ok(relationshipService.getRelationshipsByMemberId(memberId));
    }

    @DeleteMapping("/{relationshipId}")
    public ResponseEntity<Void> deleteRelationship(@PathVariable String relationshipId) {
        relationshipService.deleteRelationship(relationshipId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Relationship>> getAllRelationships() {
        return ResponseEntity.ok(relationshipService.getAllRelationships());
    }
}