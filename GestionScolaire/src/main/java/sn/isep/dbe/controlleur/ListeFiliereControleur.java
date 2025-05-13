package sn.isep.dbe.controlleur;

import sn.isep.dbe.model.Filiere;
import sn.isep.dbe.service.FiliereService;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filieres/lister")
public class ListeFiliereControleur extends HttpServlet {
    FiliereService filiereService;

    @Override
    public void init() throws ServletException {
        super.init();
        filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Filiere> filieres = filiereService.getAllFilieres();
        req.setAttribute("filieres", filieres);
        req.getRequestDispatcher("/WEB-INF/views/liste-filieres.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
