package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Etudiants;
import sn.isep.dbe.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/ajouter")
public class AjoutEtudiantServlet extends HttpServlet {
    EtudiantService etudiantService;



    @Override
    public void init() throws ServletException {
        super.init();
        etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-etudiant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String departement = req.getParameter("departement");
        String prenom = req.getParameter("prenom");
        Etudiants etudiants = new Etudiants(1, "Dieng", "Bineta", "TIC");

        etudiants.setNom(nom);
        etudiants.setDepartement(departement);
        etudiants.setPrenom(prenom);


        etudiantService.ajoutEtudiant(etudiants);

        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }

}
