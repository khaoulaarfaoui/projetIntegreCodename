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
public class Categorie {
    private int id_categorie;
    private String nom_categorie;
    private String description_categorie;
    private String type_stockage;

    public Categorie(int id_categorie, String nom_categorie, String description_categorie, String type_stockage) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.description_categorie = description_categorie;
        this.type_stockage = type_stockage;
    }

    public Categorie() {
       
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getDescription_categorie() {
        return description_categorie;
    }

    public void setDescription_categorie(String description_categorie) {
        this.description_categorie = description_categorie;
    }

    public String getType_stockage() {
        return type_stockage;
    }

    public void setType_stockage(String type_stockage) {
        this.type_stockage = type_stockage;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", description_categorie=" + description_categorie + ", type_stockage=" + type_stockage + '}';
    }
    
  
}
