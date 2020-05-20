/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.services.ServiceTask;

import java.io.IOException;
import java.util.Date;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;

/**
 *
 * @author Hajer
 */
public class cat_ajout extends SideMenuBaseForm{
    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    String username1;
    int id1;
    String img1;
    ServiceTask srv = new ServiceTask();
    int id_bs;
    
    Form current;
    
    
    public cat_ajout(Resources res){
 super("Newsfeed", BoxLayout.y());        
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title"),
                        new Label("19", "InboxNumber")
                )
        );
     
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
                                    new Label("CATEGORIES", "Title"),
                                    new Label("connected as "+"StockManager", "SubTitle")
                                )
                            )
                        
                );
        
                tb.setTitleComponent(titleCmp);
                

        setupSideMenu(res);
         
         
         Button b = new Button("Ajouter");
        Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));     
        Label desc1 = new Label("Nom");
        desc1.setUIID("PaddedLabel");
        TextField desc = new TextField("", "Nom catégorie", 20, TextField.EMAILADDR);
        desc.setUIID("TextFieldBlack");
        c.add(desc1);
        c.add(desc);
        add(c);
        
        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));     
        Label desc2 = new Label("Description");
        desc2.setUIID("PaddedLabel");
        TextField desc3 = new TextField("", "Description catégorie", 20, TextField.EMAILADDR);
        desc3.setUIID("TextFieldBlack");
        c1.add(desc2);
        c1.add(desc3);
        add(c1);
        
        Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));     
        Label desc4 = new Label("Type");
        desc4.setUIID("PaddedLabel");
        TextField desc5 = new TextField("", "Type de Stockage", 20, TextField.EMAILADDR);
        desc5.setUIID("TextFieldBlack");
        c3.add(desc4);
        c3.add(desc5);
        add(c3);
        
      
        
         
       
    
       
     
    
 
         
         b.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent evt) {
        
         
         Categorie s = new Categorie(5, desc.getText(), desc3.getText(), desc5.getText());
         srv.add_cat(s);
         
      
      //   Sprint s = new Sprint(4, desc.getText(), datedb, datefn,Integer.parseInt(qteLabel.getText()), " ", " ", id_bs);
     //   srv.add_sprint(s);
        new Sprint_form(res).show();
         
         
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
