package com.domain.backend.service.impl;

import com.domain.backend.model.Note;
import com.domain.backend.repository.NoteRepository;
import com.domain.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getNoteById(String noteId) {
        return noteRepository.findById(noteId);
    }

    @Override
    public List<Note> getNotesByTreeId(String treeId) {
        return noteRepository.findByTreeId(treeId);
    }

    @Override
    public List<Note> getNotesByMemberId(String memberId) {
        return noteRepository.findByMemberId(memberId);
    }

    @Override
    public List<Note> getNotesByAuthorId(String authorId) {
        return noteRepository.findByAuthorId(authorId);
    }

    @Override
    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
