package fr.mossaab.gproduits.web.controller;

import fr.mossaab.gproduits.model.Produit;
import fr.mossaab.gproduits.service.CatalogueService;
import fr.mossaab.gproduits.service.CatalogueServiceImpl;
import fr.mossaab.gproduits.web.model.CatalogueModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "catalogue", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {
    private CatalogueService cs;

    @Override
    public void init() throws ServletException {
        cs = new CatalogueServiceImpl(); // attention au couplage fort !!
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("catalogue.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cs = new CatalogueServiceImpl();
        CatalogueModel model = new CatalogueModel();
        model.setMotCle(req.getParameter("motCle"));
        List<Produit> produits = cs.produitsParMC(model.getMotCle());
        model.setProduits(produits);
        req.setAttribute("model",model);
        req.getRequestDispatcher("catalogue.jsp").forward(req,resp);
    }
}
