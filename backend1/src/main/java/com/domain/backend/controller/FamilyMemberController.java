package com.domain.backend.controller;

import com.domain.backend.model.FamilyMember;
import com.domain.backend.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family-members")
public class FamilyMemberController {
    private final FamilyMemberService familyMemberService;

    @Autowired
    public FamilyMemberController(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @PostMapping
    public ResponseEntity<FamilyMember> addFamilyMember(@RequestBody FamilyMember member) {
        FamilyMember created = familyMemberService.addFamilyMember(member);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<FamilyMember> getFamilyMember(@PathVariable String memberId) {
        return familyMemberService.getFamilyMemberById(memberId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<FamilyMember> updateFamilyMember(@PathVariable String memberId, @RequestBody FamilyMember updatedMember) {
        FamilyMember member = familyMemberService.updateFamilyMember(memberId, updatedMember);
        return ResponseEntity.ok(member);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteFamilyMember(@PathVariable String memberId) {
        familyMemberService.deleteFamilyMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tree/{treeId}")
    public ResponseEntity<List<FamilyMember>> getFamilyMembersByTree(@PathVariable String treeId) {
        return ResponseEntity.ok(familyMemberService.getFamilyMembersByTreeId(treeId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<FamilyMember>> searchFamilyMembersByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(familyMemberService.searchFamilyMembersByLastName(lastName));
    }

    @GetMapping
    public ResponseEntity<List<FamilyMember>> getAllFamilyMembers() {
        return ResponseEntity.ok(familyMemberService.getAllFamilyMembers());
    }
}
