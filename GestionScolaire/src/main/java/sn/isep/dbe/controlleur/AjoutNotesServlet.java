package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Notes;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/ajouter")
public class AjoutNotesServlet extends HttpServlet {
    private NoteService notesService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.notesService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Afficher le formulaire d'ajout
        req.getRequestDispatcher("/WEB-INF/views/ajout-notes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des paramètres
        String prenom = req.getParameter("prenom");
        String nom = req.getParameter("nom");
        String departement = req.getParameter("departement");
        String matiere = req.getParameter("matiere");
        String noteStr = req.getParameter("note");

        // Validation des données
        if (!validateInputs(prenom, nom, departement, matiere, noteStr)) {
            req.setAttribute("errorMessage", "Veuillez remplir tous les champs correctement");
            // Réinjecter les données dans le formulaire
            req.setAttribute("prenom", prenom);
            req.setAttribute("nom", nom);
            req.setAttribute("departement", departement);
            req.setAttribute("matiere", matiere);
            req.setAttribute("note", noteStr);
            req.getRequestDispatcher("/WEB-INF/views/ajout-notes.jsp").forward(req, resp);
            return;
        }

        try {
            // Conversion de la note
            int note = Integer.parseInt(noteStr);

            // Création de l'objet Note
            Notes nouvelleNote = new Notes();
            nouvelleNote.setPrenom(prenom.trim());
            nouvelleNote.setNom(nom.trim());
            nouvelleNote.setDepartement(departement.trim());
            nouvelleNote.setMatiere(matiere.trim());
            nouvelleNote.setNotes(note);

            // Ajout de la note
            boolean success = notesService.ajouterNote(nouvelleNote);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/notes/lister?success=Note+ajoutée+avec+succès");
            } else {
                req.setAttribute("errorMessage", "Erreur lors de l'ajout de la note");
                req.setAttribute("prenom", prenom);
                req.setAttribute("nom", nom);
                req.setAttribute("departement", departement);
                req.setAttribute("matiere", matiere);
                req.setAttribute("note", noteStr);
                req.getRequestDispatcher("/WEB-INF/views/ajout-notes.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "La note doit être un nombre valide");
            req.setAttribute("prenom", prenom);
            req.setAttribute("nom", nom);
            req.setAttribute("departement", departement);
            req.setAttribute("matiere", matiere);
            req.setAttribute("note", noteStr);
            req.getRequestDispatcher("/WEB-INF/views/ajout-notes.jsp").forward(req, resp);
        }
    }

    private boolean validateInputs(String prenom, String nom, String departement, String matiere, String note) {
        return prenom != null && !prenom.trim().isEmpty() &&
                nom != null && !nom.trim().isEmpty() &&
                departement != null && !departement.trim().isEmpty() &&
                matiere != null && !matiere.trim().isEmpty() &&
                note != null && !note.trim().isEmpty();
    }
}