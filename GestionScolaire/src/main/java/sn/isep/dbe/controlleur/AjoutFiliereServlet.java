package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Filiere;
import sn.isep.dbe.service.FiliereService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/filieres/ajouter")


public class AjoutFiliereServlet extends HttpServlet {
    FiliereService filiereService;
    @Override
    public void init() throws ServletException {
        super.init();
        filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-filiere.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String departement = req.getParameter("departement");
        String nomResponsable = req.getParameter("nomResponsable");
        String prenomResponsable = req.getParameter("prenomResponsable");
        String capacite = req.getParameter("capacite");

        Filiere filiere = new Filiere();
        filiere.setCode(code);
        filiere.setNom(nom);
        filiere.setDepartement(departement);
        filiere.setNomResponsable(nomResponsable);
        filiere.setPrenomResponsable(prenomResponsable);
        filiere.setCapacite(Integer.parseInt(capacite));

        filiereService.ajoutFiliere(filiere);

        resp.sendRedirect(req.getContextPath() + "/filieres/lister");
    }
}
