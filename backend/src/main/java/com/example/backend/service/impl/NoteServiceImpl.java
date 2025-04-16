package com.example.backend.service.impl;

import com.example.backend.entity.Note;
import com.example.backend.repo.NoteRepository;
import com.example.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepo;
@Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }
    @Override
    public Note createNote(Note note) {
        return noteRepo.save(note);
    }
    @Override
    public Note updateNote(Long id, Note newNote) {
        return noteRepo.findById(id).map(note -> {
            note.setTitle(newNote.getTitle());
            note.setContent(newNote.getContent());
            return noteRepo.save(note);
        }).orElseThrow(() -> new RuntimeException("Note not found"));
    }
    @Override
    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }
}