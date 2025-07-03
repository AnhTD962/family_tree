package com.domain.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "family_members")
public class FamilyMember {
    @Id
    private String id;
    private String treeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String dateOfDeath;
    private String photoUrl;
    private String notes;
    private List<String> parentIds;
    private List<String> spouseIds;
    private List<String> childIds;
    private Instant createdAt;
    private Instant updatedAt;
}
