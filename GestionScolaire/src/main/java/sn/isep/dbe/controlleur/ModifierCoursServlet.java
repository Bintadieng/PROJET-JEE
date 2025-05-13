package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Cours;
import sn.isep.dbe.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/modifier")
public class ModifierCoursServlet extends HttpServlet {
    private CoursService coursService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer l'ID du cours à modifier
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Cours cours = coursService.getCoursById(id);

            if (cours == null) {
                resp.sendRedirect(req.getContextPath() + "/cours/lister");
                return;
            }

            req.setAttribute("cours", cours);
            req.getRequestDispatcher("/WEB-INF/views/modifier-cours.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String idParam = req.getParameter("id");
        String departement = req.getParameter("departement");
        String nomCours = req.getParameter("cours");
        String salle = req.getParameter("salle");
        String professeur = req.getParameter("professeur");
        String heures = req.getParameter("heures");

        // Valider les données
        if (!validateInputs(idParam, departement, nomCours, salle, professeur, heures)) {
            req.setAttribute("errorMessage", "Tous les champs sont obligatoires");
            Cours cours = new Cours();
            cours.setId(Integer.parseInt(idParam));
            cours.setDepartement(departement);
            cours.setCours(nomCours);
            cours.setSalle(salle);
            cours.setProfesseur(professeur);
            cours.setHeures(heures);
            req.setAttribute("cours", cours);
            req.getRequestDispatcher("/WEB-INF/views/modifier-cours.jsp").forward(req, resp);
            return;
        }

        try {
            // Créer l'objet Cours
            Cours cours = new Cours();
            cours.setId(Integer.parseInt(idParam));
            cours.setDepartement(departement.trim());
            cours.setCours(nomCours.trim());
            cours.setSalle(salle.trim());
            cours.setProfesseur(professeur.trim());
            cours.setHeures(heures.trim());

            // Mettre à jour le cours
            boolean success = coursService.modifierCours(cours);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/cours/lister?success=Le cours a été modifié avec succès");
            } else {
                req.setAttribute("errorMessage", "Erreur lors de la modification du cours");
                req.setAttribute("cours", cours);
                req.getRequestDispatcher("/WEB-INF/views/modifier-cours.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister?error=ID invalide");
        }
    }

    private boolean validateInputs(String idParam, String departement, String nomCours,
                                   String salle, String professeur, String heures) {
        return idParam != null && !idParam.trim().isEmpty() &&
                departement != null && !departement.trim().isEmpty() &&
                nomCours != null && !nomCours.trim().isEmpty() &&
                salle != null && !salle.trim().isEmpty() &&
                professeur != null && !professeur.trim().isEmpty() &&
                heures != null && !heures.trim().isEmpty();
    }
}