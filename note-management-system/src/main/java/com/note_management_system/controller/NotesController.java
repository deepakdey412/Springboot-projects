package com.note_management_system.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.note_management_system.entity.Notes;
import com.note_management_system.service.INotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private final INotesService notesService;

    public NotesController(INotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes notes) {
        Notes newNotes = notesService.createNotes(notes);
        return new ResponseEntity<>(newNotes, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return ResponseEntity.ok(notesService.findAllNotes());
    }

    @PutMapping
    public ResponseEntity<Notes> updateNotes(@RequestBody Notes notes) {
        return ResponseEntity.ok(notesService.updateNotes(notes));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNotes(@RequestParam String title) {
        notesService.deleteNotes(title);
        return ResponseEntity.ok("Note Deleted!");
    }
}
