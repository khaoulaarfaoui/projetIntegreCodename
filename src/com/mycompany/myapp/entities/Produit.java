/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Dhake
 */
public class Produit {
    private String reference;
    private int categorie;
    private String nom_produit ;
    private String description_produit;
    private int quantite;
    private int prix_unitaire;
    private int prix_vente;
    private String date_fabrication;
    private String date_expiration;
    private String photoProduit;

    public Produit(String reference, int categorie, String nom_produit, String description_produit, int quantite, int prix_unitaire, int prix_vente, String date_fabrication, String date_expiration, String photoProduit) {
        this.reference = reference;
        this.categorie = categorie;
        this.nom_produit = nom_produit;
        this.description_produit = description_produit;
        this.quantite = quantite;
        this.prix_unitaire = prix_unitaire;
        this.prix_vente = prix_vente;
        this.date_fabrication = date_fabrication;
        this.date_expiration = date_expiration;
        this.photoProduit = photoProduit;
    }

    public Produit() {
        ; 
    }
    
    
    

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(int prix_vente) {
        this.prix_vente = prix_vente;
    }

    public String getDate_fabrication() {
        return date_fabrication;
    }

    public void setDate_fabrication(String date_fabrication) {
        this.date_fabrication = date_fabrication;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }

    public String getPhotoProduit() {
        return photoProduit;
    }

    public void setPhotoProduit(String photoProduit) {
        this.photoProduit = photoProduit;
    }

    @Override
    public String toString() {
        return "Produit{" + "reference=" + reference + ", categorie=" + categorie + ", nom_produit=" + nom_produit + ", description_produit=" + description_produit + ", quantite=" + quantite + ", prix_unitaire=" + prix_unitaire + ", prix_vente=" + prix_vente + ", date_fabrication=" + date_fabrication + ", date_expiration=" + date_expiration + ", photoProduit=" + photoProduit + '}';
    }
  
     ;

}
