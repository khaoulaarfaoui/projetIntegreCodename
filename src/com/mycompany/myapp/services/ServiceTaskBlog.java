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

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.post;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azizl
 */
public class ServiceTaskBlog {
     public ArrayList<post> post;
     public static ServiceTaskBlog instance=null;
     public boolean resultOK;
     private ConnectionRequest req;
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
     
        public ServiceTaskBlog() {
         req = new ConnectionRequest();
    }

    public static ServiceTaskBlog getInstance() {
        if (instance == null) {
            instance = new ServiceTaskBlog();
        }
        return instance;
    }
    
    
    public ArrayList<post> getAllTasks(){
        String url = Statics.BASE_URL+"/parslist";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                post = parsePost(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return post;
    }
    
    
      public ArrayList<post> parsePost(String jsonText){
        try {
            
            post=new ArrayList<>();
         
            JSONParser j = new JSONParser();
            Map<String,Object> categorieListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)categorieListJson.get("root");
                       for(Map<String,Object> obj : list){
                post t = new post();
            float foo = Float.parseFloat(obj.get("id").toString());
            System.out.println(foo);
                t.setId((int) foo);
                
 
                t.setTitle(obj.get("title").toString());
                t.setDescription(obj.get("description").toString());
                t.setPhoto(obj.get("photo").toString());
                
             
                
                t.setPostdate("null");
                
               
            
          post.add(t);


            }
            
            
        } catch (IOException ex) {
            
        } 
    
         System.out.println(post);
        return post;
    }

    public Boolean del_post(int id) {
             String url = Statics.BASE_URL + "/delpost/"+id;
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
    
         public boolean add_post(post s) {
        String url = Statics.BASE_URL + "/createpost/new?title=" +s.getTitle()+ "&description=" + s.getDescription()+"&photo=" +s.getPhoto();
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
