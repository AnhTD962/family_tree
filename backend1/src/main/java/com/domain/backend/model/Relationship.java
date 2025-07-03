package com.domain.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "relationships")
public class Relationship {
    @Id
    private String id;
    private String treeId;
    private String memberId1;
    private String memberId2;
    private String type; // e.g. "parent", "spouse", "sibling"
    private Instant createdAt;
}
