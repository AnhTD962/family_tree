package com.domain.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "media")
public class Media {
    @Id
    private String id;
    private String memberId;
    private String treeId;
    private String url;
    private String type; // photo, document, etc.
    private Instant uploadedAt;
}
