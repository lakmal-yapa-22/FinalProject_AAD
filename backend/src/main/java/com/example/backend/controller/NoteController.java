package com.example.backend.controller;

import com.example.backend.entity.Note;
import com.example.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
@CrossOrigin(origins = "*") // if you are connecting with frontend
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping(path="getAll")
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping(path="save")
    public Note addNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Note editNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
