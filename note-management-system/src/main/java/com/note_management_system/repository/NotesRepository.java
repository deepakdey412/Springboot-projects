package com.note_management_system.repository;

import com.note_management_system.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    Notes findByTitle(String title);
}
