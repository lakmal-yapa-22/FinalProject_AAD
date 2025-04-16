package com.example.backend.service;

import com.example.backend.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    Note createNote(Note note);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);
}
