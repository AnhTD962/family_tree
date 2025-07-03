package com.domain.backend.service;

import com.domain.backend.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    Note addNote(Note note);

    Optional<Note> getNoteById(String noteId);

    List<Note> getNotesByTreeId(String treeId);

    List<Note> getNotesByMemberId(String memberId);

    List<Note> getNotesByAuthorId(String authorId);

    void deleteNote(String noteId);

    List<Note> getAllNotes();
}
