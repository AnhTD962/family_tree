package com.domain.backend.controller;

import com.domain.backend.model.Note;
import com.domain.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note created = noteService.addNote(note);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable String noteId) {
        return noteService.getNoteById(noteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tree/{treeId}")
    public ResponseEntity<List<Note>> getNotesByTree(@PathVariable String treeId) {
        return ResponseEntity.ok(noteService.getNotesByTreeId(treeId));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Note>> getNotesByMember(@PathVariable String memberId) {
        return ResponseEntity.ok(noteService.getNotesByMemberId(memberId));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Note>> getNotesByAuthor(@PathVariable String authorId) {
        return ResponseEntity.ok(noteService.getNotesByAuthorId(authorId));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable String noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }
}
