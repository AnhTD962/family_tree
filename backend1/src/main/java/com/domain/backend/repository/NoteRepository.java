package com.domain.backend.repository;

import com.domain.backend.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByTreeId(String treeId);

    List<Note> findByMemberId(String memberId);

    List<Note> findByAuthorId(String authorId);
}
