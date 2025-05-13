package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Etudiants;
import sn.isep.dbe.service.EtudiantService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/etudiants/lister")
public class ListeEtudiantsControleur extends HttpServlet {

    private EtudiantService etudiantService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.etudiantService = new EtudiantService();
        initialiserDonneesExemple();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Etudiants> etudiants = etudiantService.getAllEtudiants();
        req.setAttribute("etudiants", etudiants);
        req.getRequestDispatcher("/WEB-INF/views/liste-etudiants.jsp").forward(req, resp);
    }

    private void initialiserDonneesExemple() {
        if (etudiantService.getAllEtudiants().isEmpty()) {
            List<Etudiants> etudiantsExemple = new ArrayList<>();
            etudiantsExemple.add(new Etudiants(1 ,"Dieng","Bineta", "TIC"));
            etudiantsExemple.add(new Etudiants(1, "Diop", "Aliou", "TIC"));
            etudiantsExemple.add(new Etudiants(1, "Boye", "Kany", "TIC"));
            etudiantsExemple.add(new Etudiants(1, "keita", "Omar", "TIC"));

            for (Etudiants etudiant : etudiantsExemple) {
                etudiantService.creerEtudiant(etudiant);
            }
        }
    }

    // Le doPost peut être supprimé si non utilisé
}