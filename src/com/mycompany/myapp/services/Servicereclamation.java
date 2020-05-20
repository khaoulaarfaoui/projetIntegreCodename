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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




/**
 *
 * @author bhk
 */
public class Servicereclamation {

    public ArrayList<Reclamation> reclamation1;
    
    public static Servicereclamation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public Servicereclamation() {
         req = new ConnectionRequest();
    }

    public static Servicereclamation getInstance() {
        if (instance == null) {
            instance = new Servicereclamation();
        }
        return instance;
    }

    public boolean addreclamation(Reclamation t)
    {
       ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion   id_reclamation="+id_reclamation+"&description="+description
        String Url = "http://localhost/finalpi/web/app_dev.php/Reclamation/new2?&description=" + t.getDescription()+ "&date=" + t.getDate();   
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return false;
    }
    
 public boolean addreclamation1(Reclamation t,int id_reclamation)
    {
       ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion   id_reclamation="+id_reclamation+"&description="+description
        String Url = "http://localhost/finalpi/web/app_dev.php/Reclamation/new2?&description=" + t.getDescription()+ "&date=" + t.getDate();   
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return false;
    }
    

    public ArrayList<Reclamation> parsetereclamation(String jsonText){
        try {
            reclamation1=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
            
            
         
                           

                
               Reclamation t = new Reclamation();
            //  int id = (int) Float.parseFloat(obj.get("id").toString());
            //t.setIdReclamation((int) Float.parseFloat(obj.get("Id_reclamation").toString()));
             float id_reclamation = Float.parseFloat(obj.get("id_reclamation").toString());
                t.setIdReclamation((int)id_reclamation);  
            
            
                 //  t.setIdReclamation(( int )Float.parseFloat(obj.get("id_reclamation").toString()));
                t.setDescription(obj.get("description").toString());
              //  t.setEmployee(((int)Float.parseFloat(obj.get("Employee").toString())));
//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //     Date date;
               /// try {
                 //   date = formatter.parse(obj.get("daterec").toString());
                  //  t.setDate(date);
              //  } catch (ParseException ex) {
                    
               // }
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
     public void SupprimerReclamation(int id_reclamation) {
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/finalpi/web/app_dev.php/Reclamation/del/"+id_reclamation);
        System.out.println("//////////////////////////////////////");
        System.out.println(id_reclamation);
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }
     public void ModifierReclamation( int id_reclamation , String description ) {
             ConnectionRequest con = new ConnectionRequest();

       con.setUrl( "http://localhost/finalpi/web/app_dev.php/reclamation/edit?id_reclamation="+id_reclamation
        + "&description=" + description) ;
         
           //System.out.println(url);
          // ConnectionRequest con = new ConnectionRequest();
          // con.setUrl(url);
           System.out.println("//////////////////////////////////////");
        System.out.println(id_reclamation);
        System.out.println("//////////////////////////////////////");
        System.out.println(id_reclamation + "&description=" + description);
           NetworkManager.getInstance().addToQueue(con);    
    }
     
    
 public ArrayList<Reclamation> getAllTasks(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/finalpi/web/app_dev.php/Reclamation/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Servicereclamation ser = new Servicereclamation();
                reclamation1 = ser.parsetereclamation(new String(con.getResponseData()));
            }
        });
      
        NetworkManager.getInstance().addToQueueAndWait(con);
        return reclamation1;
    }    

}
