package sn.isep.dbe.service;

import sn.isep.dbe.dao.CoursDAO;
import sn.isep.dbe.model.Cours;
import java.util.List;

public class CoursService {
    private CoursDAO coursDAO = new CoursDAO();

    // Récupérer tous les cours
    public List<Cours> getAllCours() {
        return coursDAO.findAll();
    }

    // Ajouter un nouveau cours
    public boolean ajouterCours(Cours cours) {
        try {
            Cours result = coursDAO.save(cours);
            return result != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Récupérer un cours par son ID
    public Cours getCoursById(int id) {
        return coursDAO.findById(id);
    }

    // Modifier un cours existant
    public boolean modifierCours(Cours cours) {
        try {
            Cours result = coursDAO.update(cours);
            return result != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer un cours
    public boolean supprimerCours(int id) {
        try {
            return coursDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Rechercher des cours par département
    public List<Cours> getCoursParDepartement(String departement) {
        return coursDAO.findByDepartement(departement);
    }
}