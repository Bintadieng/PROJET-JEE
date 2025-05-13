package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Notes;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/modifier")
public class ModifierNotesServlet extends HttpServlet {
    private NoteService notesService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.notesService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer l'ID de la note à modifier
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister?error=ID+non+valide");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Notes note = notesService.trouverNoteParId(id);

            if (note == null) {
                resp.sendRedirect(req.getContextPath() + "/notes/lister?error=Note+non+trouvée");
                return;
            }

            req.setAttribute("note", note);
            req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister?error=ID+invalide");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String idParam = req.getParameter("id");
        String prenom = req.getParameter("prenom");
        String nom = req.getParameter("nom");
        String departement = req.getParameter("departement");
        String matiere = req.getParameter("matiere");
        String noteStr = req.getParameter("note");

        // Validation des données
        if (!validateInputs(idParam, prenom, nom, departement, matiere, noteStr)) {
            req.setAttribute("errorMessage", "Tous les champs sont obligatoires");
            Notes note = new Notes();
            note.setId(Integer.parseInt(idParam));
            note.setPrenom(prenom);
            note.setNom(nom);
            note.setDepartement(departement);
            note.setMatiere(matiere);
            note.setNotes(Integer.parseInt(noteStr));
            req.setAttribute("note", note);
            req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);
            return;
        }

        try {
            // Créer l'objet Note
            Notes note = new Notes();
            note.setId(Integer.parseInt(idParam));
            note.setPrenom(prenom.trim());
            note.setNom(nom.trim());
            note.setDepartement(departement.trim());
            note.setMatiere(matiere.trim());
            note.setNotes(Integer.parseInt(noteStr));

            // Mettre à jour la note
            boolean success = notesService.modifierNote(note);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/notes/lister?success=Note+modifiée+avec+succès");
            } else {
                req.setAttribute("errorMessage", "Erreur lors de la modification de la note");
                req.setAttribute("note", note);
                req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "La note doit être un nombre valide");
            Notes note = new Notes();
            note.setId(Integer.parseInt(idParam));
            note.setPrenom(prenom);
            note.setNom(nom);
            note.setDepartement(departement);
            note.setMatiere(matiere);
            req.setAttribute("note", note);
            req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);
        }
    }

    private boolean validateInputs(String idParam, String prenom, String nom,
                                   String departement, String matiere, String note) {
        return idParam != null && !idParam.trim().isEmpty() &&
                prenom != null && !prenom.trim().isEmpty() &&
                nom != null && !nom.trim().isEmpty() &&
                departement != null && !departement.trim().isEmpty() &&
                matiere != null && !matiere.trim().isEmpty() &&
                note != null && !note.trim().isEmpty();
    }
}