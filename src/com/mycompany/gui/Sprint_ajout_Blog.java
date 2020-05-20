/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.post;
import com.mycompany.myapp.services.ServiceTaskBlog;
import java.io.OutputStream;
import java.util.Date;

/**
 *
 * @author azizl
 */
public class Sprint_ajout_Blog extends SideMenuBaseFormBlog{
       private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};

    String username1;
    int id1;
    String img1;
    ServiceTaskBlog srv = new ServiceTaskBlog();
   // ServiceBS srv = new ServiceBS();
    int id_bs;
    String pa="";
    Form current;

    Sprint_ajout_Blog(Resources res, int id) {
        
         Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.west(
                                BoxLayout.encloseY(
                                    new Label("Blog", "Title"),
                                    new Label("connected as Blog Manager"+ "SubTitle")
                                )
                            )
                        
                );
        
                tb.setTitleComponent(titleCmp);
                

        setupSideMenu(res);
        
              Button b = new Button("Ajouter");
         
          Container c5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc4= new Label("Title");
        desc4.setUIID("PaddedLabel");
        TextField desc5 = new TextField("", "Title", 20, TextField.EMAILADDR);
        desc5.setUIID("TextFieldBlack");
        c5.add(desc4);
        c5.add(desc5);
      
        add(c5);
        
        
               Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc1 = new Label("Description");
        desc1.setUIID("PaddedLabel");
        TextField desc = new TextField("", "Description", 20, TextField.EMAILADDR);
        desc.setUIID("TextFieldBlack");
        c.add(desc1);
        c.add(desc);
      
        add(c);
        
            Label picture = new Label("", "Container");

        Container c8 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc10= new Label("Photo");
        desc10.setUIID("PaddedLabel");
        TextField desc11 = new TextField("", "Description", 20, TextField.EMAILADDR);
        desc.setUIID("TextFieldBlack");
        c8.add(desc10);
        c8.add(picture);
                
                Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
Image camera = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
this.getToolbar().addCommandToRightBar("", camera, ev -> {
             String filePath = Capture.capturePhoto();
        if (filePath != null) {
            try {
                String pathToBeStored = "file://wamp64/www/finalpi/web/uploads/post/"+ desc5.getText()+".png";
                
                Image img1 = Image.createImage(filePath);
                picture.setIcon(img1);
                revalidate();
                OutputStream os = FileSystemStorage.getInstance().openOutputStream(pathToBeStored );
                System.err.println(os);
                ImageIO.getImageIO().save(img1, os, ImageIO.FORMAT_JPEG, 0.9f);
                pa= desc5.getText()+".png";
                System.err.println(pa);
                os.close();
               
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            }
        });
    
        add(c8);
        
                 b.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent evt) {
         System.err.println(desc.getText());
      
         Date date = new Date(System.currentTimeMillis());
           String datedb=(new SimpleDateFormat("yyyy-MM-dd")).format(date);

         post p = new post( desc5.getText(),desc.getText(),pa);
         srv.add_post(p);
         new Sprint_form_blog(res).show();
      //   Sprint s = new Sprint(4, desc.getText(), datedb, datefn,Integer.parseInt(qteLabel.getText()), " ", " ", id_bs);
       //  srv.add_sprint(s);
       //   new Sprint_form(res,username,id,img).show();
         
         
     }
 });
         add(b);
    }

    @Override
    protected void showOtherForm(Resources res) {
        
    }

    @Override
    protected void showOtherForm1(Resources res) {
    }

    @Override
    protected void editprofile(Resources res) {
       
    }

    @Override
    protected void showForm2(Resources res) {
       
    }
    
}
