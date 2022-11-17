package fr.mossaab.gproduits.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class Produit implements Serializable {

    private String reference;
    private String designation;
    private Double prix;
    private int quantite;

}
