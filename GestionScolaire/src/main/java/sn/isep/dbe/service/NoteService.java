package sn.isep.dbe.service;

import sn.isep.dbe.dao.NotesDAO;
import sn.isep.dbe.model.Notes;
import java.util.List;

public class NoteService {
    private final NotesDAO notesDao;

    public NoteService() {
        this.notesDao = new NotesDAO();
    }

    public boolean ajouterNote(Notes note) {
        return notesDao.ajouterNote(note) != null;
    }

    public List<Notes> listerToutesNotes() {
        return notesDao.listerToutesNotes();
    }

    public boolean modifierNote(Notes note) {
        return notesDao.mettreAJourNote(note);
    }

    public Notes trouverNoteParId(int id) {
        Notes[] listeNotes = new Notes[0];
        for (Notes note : listeNotes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
}