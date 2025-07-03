package com.domain.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private String treeId;
    private String memberId; // nullable
    private String authorId;
    private String content;
    private Instant createdAt;
}
