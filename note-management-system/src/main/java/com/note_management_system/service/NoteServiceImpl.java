package com.note_management_system.service;

import com.note_management_system.repository.NotesRepository;
import org.springframework.stereotype.Service;

import com.note_management_system.entity.Notes;

import java.util.List;

@Service
public class NoteServiceImpl implements INotesService {

    private final NotesRepository notesRepository;

    public NoteServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Notes createNotes(Notes notes) {

        Notes foundNote = notesRepository.findByTitle(notes.getTitle());

        if (foundNote != null) {
            throw new RuntimeException("Note already exists with this title");
        }

        return notesRepository.save(notes);
    }

    @Override
    public List<Notes> findAllNotes() {
        return notesRepository.findAll();
    }


    @Override
    public Notes updateNotes(Notes notes) {

        Notes foundNote = notesRepository.findByTitle(notes.getTitle());

        if (foundNote == null) {
            throw new RuntimeException("Note does not exist with this title");
        }

        foundNote.setContent(notes.getContent());

        return notesRepository.save(foundNote);
    }


    @Override
    public void deleteNotes(String title) {
        Notes foundNote = notesRepository.findByTitle(title);
        if (foundNote == null) {
            throw new RuntimeException("Note does not exist with this title");
        }
        notesRepository.delete(foundNote);
    }
}
