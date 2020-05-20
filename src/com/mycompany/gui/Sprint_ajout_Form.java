/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.isTablet;
import static com.codename1.ui.CN.openGallery;
import static com.codename1.ui.CN1Constants.GALLERY_IMAGE;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.ServiceTask;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;

/**
 *
 * @author Hajer
 */
public class Sprint_ajout_Form extends SideMenuBaseForm{
    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    String username1;
    int id1;
    String img1;
    ServiceTask srv = new ServiceTask();
   // ServiceBS srv = new ServiceBS();
    int id_bs;
    String pa="";
    Form current;
    
    
    public Sprint_ajout_Form(Resources res,int id){
 super("Newsfeed", BoxLayout.y());        
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title"),
                        new Label("19", "InboxNumber")
                )
        );
      //  id_bs=srv.getid_bs(username);
        // createDemo(res);
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
                                    new Label("Stock", "Title"),
                                    new Label("connected as Stock Manager"+ "SubTitle")
                                )
                            )
                        
                );
        
                tb.setTitleComponent(titleCmp);
                

        setupSideMenu(res);
         
         
         Button b = new Button("Ajouter");
         
          Container c5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc4= new Label("Refrence");
        desc4.setUIID("PaddedLabel");
        TextField desc5 = new TextField("", "Refrence", 20, TextField.EMAILADDR);
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
        
        Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc2= new Label("Nom Produit");
        desc2.setUIID("PaddedLabel");
        TextField desc3 = new TextField("", "Nom Produit", 20, TextField.EMAILADDR);
        desc3.setUIID("TextFieldBlack");
        c4.add(desc2);
        c4.add(desc3);
      
        add(c4);
        
   
         Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Label d = new Label("Date Fabrication");
         d.setUIID("PaddedLabel");
        Picker d1 = new Picker();
     
        d1.setUIID("TextFieldBlack");
        c1.add(d);
        c1.add(d1);
        add(c1);
        
        Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label d0 = new Label("Date Expiration");
        d0.setUIID("PaddedLabel");
        Picker d2 = new Picker();
     
        d2.setUIID("TextFieldBlack");
        c2.add(d0);
        c2.add(d2);
        add(c2);
        
        
        
         Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Label d5 = new Label("Quantité");
         d5.setUIID("PaddedLabel");
         
         Slider qte = new Slider();
        qte.setMinValue(1);
        qte.setMaxValue(50000);
        qte.setEditable(true);
        Label qteLabel = new Label("Qte : Non specifié");

        qte.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                qteLabel.setText("Quantité: " + qte.getProgress());
                
              qteLabel.setText(""+qte.getProgress());
                
            }
        });
      
         c3.add(d5);
         c3.add(qte);
        c3.add(qteLabel);
       
        add(c3);
        
      
        
        Container c6 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc6= new Label("Prix U");
        desc6.setUIID("PaddedLabel");
        TextField desc7 = new TextField("", "Prix Unitaire", 20, TextField.EMAILADDR);
        desc7.setUIID("TextFieldBlack");
        c6.add(desc6);
        c6.add(desc7);
      
        add(c6);
        
        Container c7 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label desc8= new Label("Prix V");
        desc8.setUIID("PaddedLabel");
        TextField desc9 = new TextField("", "Prix Vente", 20, TextField.EMAILADDR);
        desc9.setUIID("TextFieldBlack");
        c7.add(desc8);
        c7.add(desc9);
      
        add(c7);
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
                String pathToBeStored = "file://wamp64/wamp64/www/finalpi/web/uploads/post/"+ desc3.getText()+  ".png";
                
                Image img1 = Image.createImage(filePath);
                picture.setIcon(img1);
                revalidate();
                OutputStream os = FileSystemStorage.getInstance().openOutputStream(pathToBeStored );
                System.err.println(os);
                ImageIO.getImageIO().save(img1, os, ImageIO.FORMAT_JPEG, 0.9f);
                pa= desc3.getText() +  ".png";
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
         String datedb=(new SimpleDateFormat("yyyy-MM-dd")).format(d1.getDate());
         String datefn=(new SimpleDateFormat("yyyy-MM-dd")).format(d2.getDate());
         

         Produit p = new Produit( desc5.getText(),id, desc3.getText(), desc.getText(), Integer.parseInt(qteLabel.getText()), Integer.parseInt(desc7.getText()),Integer.parseInt(desc9.getText()), datedb, datefn,pa);
         srv.add_prod(p);
         new prods_form(res, id).show();
      //   Sprint s = new Sprint(4, desc.getText(), datedb, datefn,Integer.parseInt(qteLabel.getText()), " ", " ", id_bs);
       //  srv.add_sprint(s);
       //   new Sprint_form(res,username,id,img).show();
         
         
     }
 });
         add(b);
         
        
    }
  
    public void createDemo(Resources res) {
        getContentPane().setScrollVisible(false);
        TextField desc = new TextField("", "Description", 20, TextField.EMAILADDR);
        desc.setUIID("TextFieldBlack");
        addStringValue("Description", desc);

        
        TextField email = new TextField(""+"", "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("E-Mail", email);
        
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("Password", password);
        
        
        
    }
      private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
      public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(100);
        separator.setShowEvenIfBlank(true);
        return separator;
    }
  
    @Override
    protected void showOtherForm(Resources res) {
    }
    protected void showOtherForm1(Resources res) {
    }
    
    protected void showsprint(Resources res,int id) {
        
    }
    @Override
    protected void editprofile(Resources res) {
    }

    @Override
    protected void showForm2(Resources res) {

    }
    
    
    
}
