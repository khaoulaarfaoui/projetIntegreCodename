 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceTask {

    public ArrayList<Categorie> categorie;
    public ArrayList<Produit> prods;
    
    public static ServiceTask instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceTask() {
         req = new ConnectionRequest();
    }

    public static ServiceTask getInstance() {
        if (instance == null) {
            instance = new ServiceTask();
        }
        return instance;
    }

    public boolean addCategorie(Categorie t) {
        String url = Statics.BASE_URL + "/categorie/" + t.getNom_categorie()+ "/" + t.getDescription_categorie()+ "/" + t.getType_stockage(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Categorie> parseCategorie(String jsonText){
        try {
            
            categorie=new ArrayList<>();
         
            JSONParser j = new JSONParser();
            Map<String,Object> categorieListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)categorieListJson.get("root");
                       for(Map<String,Object> obj : list){
                Categorie t = new Categorie();
                float id = Float.parseFloat(obj.get("idCategorie").toString());
                t.setId_categorie((int) id);
                t.setNom_categorie(obj.get("nomCategorie").toString());
                t.setDescription_categorie(obj.get("descriptionCategorie").toString());
                t.setType_stockage(obj.get("typeStockage").toString());
                categorie.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
    
         System.out.println(categorie);
        return categorie;
    }
    
    public ArrayList<Categorie> getAllTasks(){
        String url = Statics.BASE_URL+"/parsingaff";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categorie = parseCategorie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categorie;
    }
    
    public ArrayList<Produit> parseProduit(String jsonText){
        try {
            
            prods=new ArrayList<>();
         
            JSONParser j = new JSONParser();
            Map<String,Object> categorieListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)categorieListJson.get("root");
                       for(Map<String,Object> obj : list){
                Produit t = new Produit();
               
                t.setReference(obj.get("reference").toString());
                t.setNom_produit(obj.get("nom_produit").toString());
                t.setDescription_produit(obj.get("description_produit").toString());
                float pu = Float.parseFloat(obj.get("prix_unitaire").toString());
                t.setPrix_unitaire((int) pu);
                float pv = Float.parseFloat(obj.get("prix_vente").toString());
                t.setPrix_vente((int) pv);
                float qte = Float.parseFloat(obj.get("quantite").toString());
                t.setQuantite((int) qte);
                t.setDate_fabrication(obj.get("date_fabrication").toString());
                t.setDate_expiration(obj.get("date_expiration").toString());
                t.setPhotoProduit(obj.get("photoProduit").toString());
                
 
                 
                prods.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
    
         System.out.println(categorie);
        return prods;
    }
    
    public ArrayList<Produit> getAllp(int id){
        String url = Statics.BASE_URL+"/parsingfind/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                prods = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return prods;
    }
    
      public boolean add_cat(Categorie s) {
        String url = Statics.BASE_URL + "/createcat/new?nom=" + s.getNom_categorie()+ "&desc=" + s.getDescription_categorie()+ "&type=" + s.getType_stockage();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return true;
    }
      
       public boolean del_cat(int id) {
        String url = Statics.BASE_URL + "/delcat/"+id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return true;
    }
       
       
       
     public boolean add_prod(Produit s) {
        String url = Statics.BASE_URL + "/createprod/new?reference=" + s.getReference()+ "&desc=" + s.getDescription_produit()+ "&nom=" + s.getNom_produit()+ "&date_fabrication=" + s.getDate_fabrication()+ "&date_expiration=" + s.getDate_expiration()+ "&quantite=" + s.getQuantite()+ "&prix_unitaire=" + s.getPrix_unitaire()+ "&prix_vente=" + s.getPrix_vente()+ "&photo=" + s.getPhotoProduit()+"&id="+s.getCategorie();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return true;
    }
}
