/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import com.codename1.ui.TextField;
import java.util.Date;

/**
 *
 * @author abdallah
 */
public class Reclamation {
    private  int id_reclamation;
    private String description;
    Date date;

    public Reclamation() {
    }

    public Reclamation(int id_reclamation, String description, Date date) {
        this.id_reclamation = id_reclamation;
        this.description = description;
        this.date = date;
    }

    

    public Reclamation(TextField spec) {
    }

    public int getIdReclamation() {
        return id_reclamation;
    }

    public void setIdReclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", description=" + description + ", date=" + date + '}';
    }

   
    

    


   

    
    
}
