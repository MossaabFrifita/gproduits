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
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CatalogueModel model = new CatalogueModel();
        req.setAttribute("model",model);
        if (action!=null) {
            if (action.equals("find")) {
                model.setMotCle(req.getParameter("motCle"));
                List<Produit> produits = cs.produitsParMC(model.getMotCle());
                model.setProduits(produits);
            }else if(action.equals("delete")){
                String ref = req.getParameter("ref");
                cs.deleteProduit(ref);
                model.setProduits(cs.listeProduits());
            }else if(action.equals("save")){
                model.getProduit().setReference(req.getParameter("reference"));
                model.getProduit().setDesignation(req.getParameter("designation"));
                model.getProduit().setPrix(Double.parseDouble(req.getParameter("prix")));
                model.getProduit().setQuantite(Integer.parseInt(req.getParameter("quantite")));
                cs.addProduit(model.getProduit());
                model.setProduits(cs.listeProduits());
            }
        }

        req.getRequestDispatcher("catalogue.jsp").forward(req,resp);
    }
}
