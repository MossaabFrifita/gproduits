package fr.mossaab.gproduits.service;

import fr.mossaab.gproduits.model.Produit;

import java.util.List;

public interface CatalogueService {

    public void addProduit(Produit p);
    public List<Produit> listeProduits();
    public   List<Produit> produitsParMC(String mc);
    public Produit getProduit(String ref);
    public void updateProduit(Produit p);
    public void deleteProduit(String ref);

}
