package fr.mossaab.gproduits.web.model;

import fr.mossaab.gproduits.model.Produit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CatalogueModel {
    private String motCle;
    private List<Produit> produits = new ArrayList<Produit>();
    private Produit produit = new Produit();
    private String action="";   //attribut pour savoir l action a invoquer
    private String saveORediter="save";
}
