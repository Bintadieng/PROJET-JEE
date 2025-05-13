package sn.isep.dbe.service;

import sn.isep.dbe.dao.EtudiantDAO;
import sn.isep.dbe.model.Etudiants;
import sn.isep.dbe.model.Filiere;

import java.util.List;

public class EtudiantService {
    EtudiantDAO etudiantDAO = new EtudiantDAO();

    public List<Etudiants> getAllEtudiants() {
        return etudiantDAO.findAll();
    }

    public Etudiants ajoutEtudiant(Etudiants etudiants) {
        Etudiants result = etudiantDAO.save(etudiants);
        return result;
    }
    // ajouter une nouvelle filiere,
    // recuperer toutes les filieres,
    // recuperer une filiere via son id

    // recuperer une filiere via son code
    public Etudiants getEtudiants(int id) {
        Etudiants etudiants = etudiantDAO.findById(id);
        return etudiants;
    }

    // modifier une filiere
    public Etudiants modifierEtudiants(Etudiants etudiants) {
        Etudiants result = etudiantDAO.update(etudiants);
        return result;
    }


    public void creerEtudiant(Etudiants etudiant){
    // autres méthodes...
}
    // supprimer une filiere
    // etc
}
