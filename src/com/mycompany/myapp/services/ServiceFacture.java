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
import com.mycompany.myapp.entities.Facture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 *
 * @author bhk
 */
public class ServiceFacture {

    public ArrayList<Facture> reclamation1;
    
    public static ServiceFacture instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceFacture() {
         req = new ConnectionRequest();
    }

    public static ServiceFacture getInstance() {
        if (instance == null) {
            instance = new ServiceFacture();
        }
        return instance;
    }

    public void Supprimerfac(int idFacture) {
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("localhost/finalpi/web/app_dev.php/Facture/del"+idFacture);
        System.out.println("//////////////////////////////////////");
        System.out.println(idFacture);
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }

    public ArrayList<Facture> parsetereclamation(String jsonText){
        try {
            reclamation1=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
            
            
         
                           

                
               Facture t = new Facture();
            //  int id = (int) Float.parseFloat(obj.get("id").toString());
            //t.setIdReclamation((int) Float.parseFloat(obj.get("Id_reclamation").toString()));
            float idFacture = Float.parseFloat(obj.get("idFacture").toString());
                t.setIdFacture((int)idFacture);  
            
            
                 //  t.setIdReclamation(( int )Float.parseFloat(obj.get("id_reclamation").toString()));
                t.setTypeProduct(obj.get("typeProduct").toString());
                                //t.setTypeProduct(obj.get("typeProduct").toString());
                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                t.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
              //  t.setMontant(((int)Float.parseFloat(obj.get("montant").toString())));
                t.setTelephone(((int)Float.parseFloat(obj.get("telephone").toString())));


          
                t.setAdresse(obj.get("Adresse").toString());

                
              //  t.setEmployee(((int)Float.parseFloat(obj.get("Employee").toString())));

                reclamation1.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return reclamation1;
    }
    
    
    
    
    
    
 
         
    
    
    
    
    
    
    
    
    
    
/*public ArrayList<reclamation> getAllTasks(){
        String url = Statics.BASE_URL1+"/all/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation1 = parsetereclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation1;
    }*/

 public ArrayList<Facture> getAllTasks(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/finalpi/web/app_dev.php/Facture/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceFacture ser = new ServiceFacture();
                reclamation1 = ser.parsetereclamation(new String(con.getResponseData()));
            }
        });
      
        NetworkManager.getInstance().addToQueueAndWait(con);
        return reclamation1;
    }    

}
