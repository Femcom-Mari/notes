package com.test.test.note;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> creteNote(@RequestBody Note note) {

        return noteService.newNote(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNoteById(@PathVariable Integer id) {
        return this.noteService.deleteNote(id);
    }

}
