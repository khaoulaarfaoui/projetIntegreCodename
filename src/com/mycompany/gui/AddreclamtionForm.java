/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import codename1.sms.twilio.TwiliosmsSender;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.Servicereclamation;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author abdallah
 */

public class AddreclamtionForm  extends SideMenuBaseForm {
private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    Form current;
    private String imgPath;
     String a;
     DatePicker date;

    public AddreclamtionForm(Resources res) {
        
        
        
        super("Newsfeed", BoxLayout.y());

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title"),
                        new Label("19", "InboxNumber")));

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
                                new Label("Reclamation", "Title"),
                                new Label("connected as " + "Admin", "abouda")
                        )
                )
        );
        
          tb.setTitleComponent(titleCmp);

        setupSideMenu(res);
        
        
      //  setTitle("Add a new task");
        setLayout(BoxLayout.y());
     //  AjouterReclamation = new Form("Ajouter une Reclamation");
        // TextField id_reclamation = new TextField(""," id_reclamation");
        TextField description = new TextField(""," description");
        
                  Picker date = new Picker();

       // TextField tfStatus= new TextField("", "Employee");
        Button btnValider = new Button("Add reclamation");
                          //Button bt_chart =new Button("chart");

                  Button bt_affiche =new Button("Affichage");

        btnValider.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SAVE, btnValider.getUnselectedStyle()));

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((description.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                         Reclamation t = new Reclamation(0,description.getText(),(Date) date.getDate());
                        if( Servicereclamation.getInstance().addreclamation(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("Success", "ajouter réclamation et envoyer sms", new Command("OK"));
                    } catch (NumberFormatException e) {
                     //   Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                

            }
        });
        
        
        
        
        
        btnValider.addActionListener((e)->{ Message m = new Message("reclamation sur une faute au niveau de données");
                String textAttachmentUri = "il y'a un probleme";
m.getAttachments().put(textAttachmentUri, "text/plain");
                String imageAttachmentUri = "testina";
m.getAttachments().put(imageAttachmentUri, "image/png");
Display.getInstance().sendMessage(new String[] {"bejia62@gmail.com"}, "reclamation", m);
   
    
     //   TwiliosmsSender s = new TwiliosmsSender();
//s.sendsms();
//Button SendSms = new Button("Sms");
        

                // f2.add(SendSms);
 });
  
      
            
 

    
 // bt_chart.addActionListener((e)->{
      
   //   AbstractDemoChart b =new AbstractDemoChart();
//b.createLineChartForm();
 // });  

   //  AjouterReclamation.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        bt_affiche.addActionListener((e)->{
        AfficheReclamation AfficheReclamation=new AfficheReclamation(res);
        AfficheReclamation.getAfficheReclamation().show();
        });     
              /* Toolbar tb = AjouterReclamation.getToolbar(); 
			   tb.addCommandToSideMenu("Facture",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
				   AddfactureForm1 ajouterdem = new AddfactureForm1();
                                    ajouterdem.getAjoutefacture().show(); 
				 
				       Toolbar tb2 = AjouterReclamation.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
			                            Connecter Connecter=new Connecter();
                                                    Connecter.getConnecter().show();
					      }
				      });
		                       AjouterReclamation.show();
				   }
			   });   
                           
			   tb.addCommandToSideMenu("Reclamation",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
				     AddreclamtionForm ajouterrec = new AddreclamtionForm();
                                                      ajouterrec .getAjouterReclamation().show(); 
				 
				       Toolbar tb2 = AjouterReclamation.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
			                            Connecter Connecter=new Connecter();
                                                    Connecter.getConnecter().show();
					      }
				      });
		                      AjouterReclamation.show();
				   }
			   }); 
                           
                           
                           
                            Toolbar tb1 = AjouterReclamation.getToolbar(); 
			    tb1.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
			                            Connecter Connecter=new Connecter();
                                                    Connecter.getConnecter().show();
////				 
////				       Toolbar tb4 = AjouterReclamation.getToolbar();
				       
				     
		                       AjouterReclamation.show();
				   }
			   });  */ 
                           
      
   
            addAll(description,date,btnValider,bt_affiche);

    } 

  

    
  

  

    public void createDemo(Resources res) {
        getContentPane().setScrollVisible(false);
        TextField desc = new TextField("", "Description", 20, TextField.EMAILADDR);
        desc.setUIID("TextFieldBlack");
        addStringValue("Description", desc);

        TextField email = new TextField("" + "", "E-Mail", 20, TextField.EMAILADDR);
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

    protected void showsprint(Resources res, int id) {

    }

    @Override
    protected void editprofile(Resources res) {
    }

    @Override
    protected void showForm2(Resources res) {

    }
        
    
}
