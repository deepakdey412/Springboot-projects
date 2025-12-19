package com.note_management_system.service;

import com.note_management_system.entity.Notes;

import java.util.List;

public interface INotesService {
    Notes createNotes(Notes notes);
    List<Notes> findAllNotes();
    Notes updateNotes(Notes notes);
    void deleteNotes(String title);
}
