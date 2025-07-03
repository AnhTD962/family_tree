package com.domain.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "family_trees")
public class FamilyTree {
    @Id
    private String id;
    private String name;
    private String description;
    private String ownerId;
    private List<String> memberIds; // Optional, can be queried instead
    private Instant createdAt;
    private Instant updatedAt;
    // key: userId, value: permission ("read", "write", "owner")
    private Map<String, String> sharedWith;
}
