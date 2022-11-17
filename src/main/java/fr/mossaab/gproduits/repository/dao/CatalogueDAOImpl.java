package fr.mossaab.gproduits.repository.dao;

import fr.mossaab.gproduits.model.Produit;
import fr.mossaab.gproduits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogueDAOImpl implements CatalogueDAO{
    @Override
    public void addProduit(Produit p) {
        Connection connnection = DatabaseConnection.getConnection();
        try {
            PreparedStatement pr = connnection.prepareStatement("INSERT INTO  produit (ref_prod,designation,prix,quantite)  values (?,?,?,?) ");
            pr.setString(1, p.getReference());
            pr.setString(2, p.getDesignation());
            pr.setDouble(3, p.getPrix());
            pr.setInt(4, p.getQuantite());
            pr.executeUpdate();  // pour la modification de la bdd on utilise executeUpdate(), et executeQuery() pour la lecture
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> listeProduits() {
        List<Produit> prods = new ArrayList<>();
        try {
            Connection connnection = DatabaseConnection.getConnection();
            PreparedStatement pr = connnection.prepareStatement("SELECT * FROM  produit");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Produit p=new Produit();
                p.setReference(rs.getString("REF_PROD"));
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
                prods.add(p);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prods;
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        List<Produit> prodsParMc = new ArrayList<>();

        try {
            Connection connnection = DatabaseConnection.getConnection();
            PreparedStatement pr = connnection.prepareStatement("SELECT * FROM  produit WHERE designation like ?");
            pr.setString(1 , "%"+mc+"%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Produit p=new Produit();
                p.setReference(rs.getString("REF_PROD"));
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
                prodsParMc.add(p);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prodsParMc;
    }

    @Override
    public Produit getProduit(String ref) {
        Produit p= null;
        try {
            Connection connnection = DatabaseConnection.getConnection();
            PreparedStatement pr = connnection.prepareStatement("SELECT * FROM  produit WHERE ref_prod = ?");
            pr.setString(1 , ref);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                p = new Produit();
                p.setReference(rs.getString("ref_prod"));
                p.setDesignation(rs.getString("de"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (p == null) throw new RuntimeException("Produit "+ref +" introuvable");
        return p;
    }

    @Override
    public void updateProduit(Produit p) {
        try {
            Connection connnection = DatabaseConnection.getConnection();
            PreparedStatement pr = connnection.prepareStatement("UPDATE produit set designation = ? , prix= ? , quantite= ? where ref_prod=?");
            pr.setString(1, p.getDesignation());
            pr.setDouble(2, p.getPrix());
            pr.setInt(3, p.getQuantite());
            pr.setString(4, p.getReference());
            pr.executeUpdate();
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduit(String ref)  {
        try {
            Connection connnection = DatabaseConnection.getConnection();
            PreparedStatement pr = connnection.prepareStatement(" DELETE FROM produit WHERE ref_prod= ?");
            pr.setString(1,ref);
            pr.executeUpdate();
            pr.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
