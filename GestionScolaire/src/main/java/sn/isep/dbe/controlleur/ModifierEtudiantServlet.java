package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Etudiants;
import sn.isep.dbe.service.EtudiantService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/modifier")
public class ModifierEtudiantServlet extends HttpServlet {
    EtudiantService etudiantService;


    @Override
    public void init() throws ServletException {
        this.etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        //recupere la filiere ayant l id donne en parametre
        String idParam= req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }
        int id  =Integer.parseInt(idParam);
        Etudiants etudiants = etudiantService.getEtudiants(id);

        req.setAttribute("item", etudiants);
        req.getRequestDispatcher("/WEB-INF/views/modifier-etudiants.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifie si l element existe
        String idParam = req.getParameter("id");
        System.out.println("########## " + idParam);

        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }

        int id = Integer.parseInt(idParam);

        // si oui recuperer les donnees
        Etudiants etudiantExistant = etudiantService.getEtudiants(id);
        if (etudiantExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }

        // recuperer les nouvelles donnees
        String code = req.getParameter("nom");
        String nom = req.getParameter("prenom");
        String departement = req.getParameter("departement");


        // modfier les donnees

        etudiantExistant.setNom(nom);
        etudiantExistant.setPrenom("prenom");
        etudiantExistant.setDepartement(departement);



        // effectuer les changement dans la bd
        etudiantService.modifierEtudiants(etudiantExistant);

        // retourner vers la liste
        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }

}
