/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.payment.Receipt;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
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
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
//import com.mycompany.Entite.Demande;
//import com.mycompany.Service.ServiceDemande;
import com.mycompany.myapp.services.Servicereclamation;

import java.util.Date;

/**
 *
 * @author djebb
 */
public class AfficheReclamation  {

    static void add(Label label) {
    }
    
    Form AfficheReclamation;
    SpanLabel lb;
    Button bt_supprimer , bt_modifier;
      private Resources theme;

    public AfficheReclamation (Resources res) {
             theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
   
        AfficheReclamation = new Form();
//        lb = new SpanLabel("");
//        AfficheReclamation.add(lb);
        Servicereclamation serviceReclamation=new Servicereclamation();
         for (int i = 0; i < serviceReclamation.getAllTasks().size(); ++i)  {
      
      int id_reclamation = serviceReclamation.getAllTasks().get(i).getIdReclamation(); 
       String description = serviceReclamation.getAllTasks().get(i).getDescription(); 
              Date daterec= serviceReclamation.getAllTasks().get(i).getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

          //  SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
             Servicereclamation service=new Servicereclamation();
         
           
//             Label l2 =new Label("Date: ");
//l2.getAllStyles().setFgColor(0xff000);
//AfficheDemande.add(l2);
//        AfficheDemande.add(new Label( formatter.format(datedem)));
           

//Label l111 =new Label("_______________");
//l111.getAllStyles().setFgColor(0xEAEAEA);

         
        Label ll =new Label("Date: ");
   ll.getAllStyles().setFgColor(0x0E36D7);
AfficheReclamation.add(ll);
Label l111 =new Label("_______________");
       

        
               Label l1 =new Label("Description: ");
l1.getAllStyles().setFgColor(0x0E36D7);
AfficheReclamation.add(l1);


        AfficheReclamation.add(new Label(description));
     
        
         
//Label l1113 =new Label("_______________");
//l1113.getAllStyles().setFgColor(0xEAEAEA);
        //AfficheDemande.add(l1113);
        
         bt_supprimer=new Button("Supprimer");
        
         bt_supprimer.addActionListener((e)->{
            Servicereclamation ser = new Servicereclamation();
           // Reclamation t = new Reclamation();
            ser.SupprimerReclamation(id_reclamation);
         });
         
         AfficheReclamation.add(bt_supprimer);
      
            bt_modifier=new Button("Modifier");
       bt_modifier.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
               /// Form aff= new Form(" Demande "+ iddem);
             Form   AjouterReclamation = new Form("Ajouter une Reclamation"+ id_reclamation);
                            Button bt_ajout;
 //AjouterReclamation.getToolbar().addCommandToRightBar("Retour", null, (ev)->{AddreclamtionForm h=new AddreclamtionForm();
        //  h.getAjouterReclamation().show();
         // });
                     Button btnValider = new Button("modifier");

        // TextField id_reclamation = new TextField(""," id_reclamation");
        TextField description = new TextField(""," description");
        
                  Picker date = new Picker();
      Container c1 = new Container(BoxLayout.y());
                c1.add(date);
  c1.add(description);
 AjouterReclamation.add(c1);
       // TextField tfStatus= new TextField("", "Employee");
                         




        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((description.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                   
                         Reclamation t = new Reclamation(id_reclamation,description.getText(),(Date) date.getDate());
                        //if( Servicereclamation.getInstance().addreclamation1(t,id_reclamation))
                        //    Dialog.show("Success","modification accepted",new Command("OK"));
                       
                  
                    
                }
                  Servicereclamation ser = new Servicereclamation();
           // Reclamation t = new Reclamation();
          
            ser.SupprimerReclamation(id_reclamation);
        Reclamation  t = new Reclamation(id_reclamation,description.getText(),(Date) date.getDate());
                         Servicereclamation.getInstance().addreclamation1(t,id_reclamation);
                         Dialog.show("Success","modification accepted",new Command("OK"));
                         

            }
            
        });
         
         
        AjouterReclamation.add(btnValider); 
         AjouterReclamation.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), ev->{
           
        new HomeForm(res).show();

          
        });
         
// AfficheReclamation.add(bt_modifier);        
        
        
                
            
             // Servicereclamation ser = new Servicereclamation();
               
            //  Reclamation NVreclamation = new Reclamation();
            //ModifierReclamation ModifierReclamation = new ModifierReclamation(NVreclamation);
           // ModifierReclamation.getModifierReclamation().show();
          //  ser.ModifierReclamation(id_reclamation,  description );
          AjouterReclamation.show();

            }
         });
         AfficheReclamation.add(bt_modifier);
                
              //Label l11 =new Label("---------------------------------------------------------------");
              Label l11 =new Label("__________________________________________________________________");
l11.getAllStyles().setFgColor(0xC0C0C0);
AfficheReclamation.add(l11);
  
  















 
       
        
         }  
 
     AfficheReclamation.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), ev->{
           
        new HomeForm(res).show();

            
        });
       
//        lb.setText(serviceReclamation.getListDemande().toString());
        
//          AfficheReclamation.getToolbar().addCommandToRightBar("Retour", null, (ev)->{AddreclamtionForm h=new AddreclamtionForm();
        //  h.getAjouterReclamation().show();
        //  });
          
          Toolbar tb = AfficheReclamation.getToolbar(); 
			   tb.addCommandToSideMenu("Demande",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
				  //   AjouterDemande ajouterdem = new AjouterDemande();
                                   //  ajouterdem.getAjouterDemande().show();  
				 
				       Toolbar tb2 = AfficheReclamation.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
//			                            Connecter Connecter=new Connecter();
                                                  //  Connecter.getConnecter().show();
					      }
				      });
		                       AfficheReclamation.show();
				   }
			   });   
                           
			   tb.addCommandToSideMenu("Reclamation",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
				    // AddreclamtionForm ajouterrec = new AddreclamtionForm();
                                                    //  ajouterrec .getAjouterReclamation().show(); 
				 
				       Toolbar tb2 = AfficheReclamation.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
//			                            Connecter Connecter=new Connecter();
                                                 //   Connecter.getConnecter().show();
					      }
				      });
		                      AfficheReclamation.show();
				   }
			   }); 
                           
                           
                           
                            Toolbar tb1 = AfficheReclamation.getToolbar(); 
			    tb1.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
//			                            Connecter Connecter=new Connecter();
                                                 //   Connecter.getConnecter().show();
////				 
////				       Toolbar tb4 = AjouterReclamation.getToolbar();
				       
				     
		                       AfficheReclamation.show();
				   }
			   });  
                            
    
        
    }

    public Form getAfficheReclamation() {
        return AfficheReclamation;
    }

    public void setAfficheReclamation(Form AfficheReclamation) {
        this.AfficheReclamation = AfficheReclamation;
    }

    public SpanLabel getLb() {
        return lb;
    }

    public void setLb(SpanLabel lb) {
        this.lb = lb;
    }
    
    
}
