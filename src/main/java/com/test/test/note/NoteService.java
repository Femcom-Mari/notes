package com.test.test.note;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;


    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public ResponseEntity<Object> newNote(Note note) {
        noteRepository.save(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }


    public List<Note> getNotes() {
        return this.noteRepository.findAll();
    }

    public ResponseEntity<Object> deleteNote(Integer id){
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (!noteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
