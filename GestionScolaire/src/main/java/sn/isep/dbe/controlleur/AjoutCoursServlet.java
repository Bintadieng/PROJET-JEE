package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Cours;
import sn.isep.dbe.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/ajouter")
public class AjoutCoursServlet extends HttpServlet {
    private CoursService coursService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Afficher le formulaire d'ajout
        req.getRequestDispatcher("/WEB-INF/views/ajout-cours.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des paramètres
        String departement = req.getParameter("departement");
        String nomCours = req.getParameter("cours");
        String salle = req.getParameter("salle");
        String professeur = req.getParameter("professeur");
        String heures = req.getParameter("heures");

        // Validation des données
        if (!validateInputs(departement, nomCours, salle, professeur, heures)) {
            req.setAttribute("errorMessage", "Veuillez remplir tous les champs obligatoires");
            // Réinjecter les données dans le formulaire
            req.setAttribute("departement", departement);
            req.setAttribute("cours", nomCours);
            req.setAttribute("salle", salle);
            req.setAttribute("professeur", professeur);
            req.setAttribute("heures", heures);
            req.getRequestDispatcher("/WEB-INF/views/ajout-cours.jsp").forward(req, resp);
            return;
        }

        // Création de l'objet Cours
        Cours cours = new Cours();
        cours.setDepartement(departement.trim());
        cours.setCours(nomCours.trim());
        cours.setSalle(salle.trim());
        cours.setProfesseur(professeur.trim());
        cours.setHeures(heures.trim());

        // Ajout du cours
        boolean success = coursService.ajouterCours(cours);

        if (success) {
            // Redirection après succès
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
        } else {
            // Gestion d'erreur
            req.setAttribute("errorMessage", "Erreur lors de l'ajout du cours");
            req.setAttribute("departement", departement);
            req.setAttribute("cours", nomCours);
            req.setAttribute("salle", salle);
            req.setAttribute("professeur", professeur);
            req.setAttribute("heures", heures);
            req.getRequestDispatcher("/WEB-INF/views/ajout-cours.jsp").forward(req, resp);
        }
    }

    private boolean validateInputs(String departement, String cours, String salle,
                                   String professeur, String heures) {
        return departement != null && !departement.trim().isEmpty() &&
                cours != null && !cours.trim().isEmpty() &&
                salle != null && !salle.trim().isEmpty() &&
                professeur != null && !professeur.trim().isEmpty() &&
                heures != null && !heures.trim().isEmpty();
    }
}