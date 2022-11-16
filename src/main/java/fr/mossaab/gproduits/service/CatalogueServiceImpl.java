package fr.mossaab.gproduits.service;

import fr.mossaab.gproduits.model.Produit;
import fr.mossaab.gproduits.repository.dao.CatalogueDAO;
import fr.mossaab.gproduits.repository.dao.CatalogueDAOImpl;

import java.util.List;

public class CatalogueServiceImpl implements  CatalogueService{
    CatalogueDAO dao = new CatalogueDAOImpl(); // Attention au couplage fort !
    @Override
    public void addProduit(Produit p) {
        dao.addProduit(p);
    }

    @Override
    public List<Produit> listeProduits() {
        return dao.listeProduits();
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        return dao.produitsParMC(mc);
    }

    @Override
    public Produit getProduit(String ref) {
        return dao.getProduit(ref);
    }

    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }

    @Override
    public void deleteProduit(String ref) {
        dao.deleteProduit(ref);
    }
}
