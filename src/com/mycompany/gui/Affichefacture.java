/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceFacture;
//import com.mycompany.Entite.Demande;
//import com.mycompany.Service.ServiceDemande;
import com.mycompany.myapp.services.Servicereclamation;

import java.util.Date;

/**
 *
 * @author djebb
 */
public class Affichefacture {
    
    Form Affichefacture;
    SpanLabel lb;
    Button bt_supprimer , bt_modifier;
        private Resources theme;

    public Affichefacture (Resources res) {
          theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
        Affichefacture = new Form();
//        lb = new SpanLabel("");
//        AfficheReclamation.add(lb);
        ServiceFacture ServiceFacture=new ServiceFacture();
         for (int i = 0; i < ServiceFacture.getAllTasks().size(); ++i)  {
      
      int idFacture = ServiceFacture.getAllTasks().get(i).getIdFacture(); 
       int Quantite = ServiceFacture.getAllTasks().get(i).getQuantite(); 
              int Prix = ServiceFacture.getAllTasks().get(i).getPrix(); 
           //  int montant = ServiceFacture.getAllTasks().get(i).getMontant(); 
       String typeProduct = ServiceFacture.getAllTasks().get(i).getTypeProduct(); 

       
              //Date daterec= ServiceFacture.getAllTasks().get(i).getDate();
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

          //  SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
             Servicereclamation service=new Servicereclamation();
         
           
//             Label l2 =new Label("Date: ");
//l2.getAllStyles().setFgColor(0xff000);
//AfficheDemande.add(l2);
//        AfficheDemande.add(new Label( formatter.format(datedem)));
           

//Label l111 =new Label("_______________");
//l111.getAllStyles().setFgColor(0xEAEAEA);

         
        Label ll =new Label("Quantite: ");
   ll.getAllStyles().setFgColor(0x0E36D7);
Affichefacture.add(ll);
Label l111 =new Label("_______________");

   Affichefacture.add(new Label(Integer.toString(Quantite)));      

        
               Label l1 =new Label("Prix: ");
l1.getAllStyles().setFgColor(0x0E36D7);
Affichefacture.add(l1);
 Affichefacture.add(new Label(Integer.toString(Prix)));      
 Label l1111 =new Label("_______________");

 
 
    //Label l2 =new Label("mo: ");
//l2.getAllStyles().setFgColor(0x0E36D7);
//Affichefacture.add(l2);
// Affichefacture.add(new Label(Integer.toString(montant)));      

 Label l3 =new Label("pr: ");
l3.getAllStyles().setFgColor(0x0E36D7);
Affichefacture.add(l3);
  AfficheReclamation.add(new Label(typeProduct));
 
      //  Affichefacture.add(new Label(Prix));
     
        
         
//Label l1113 =new Label("_______________");
//l1113.getAllStyles().setFgColor(0xEAEAEA);
        //AfficheDemande.add(l1113);
         // Form hi = new Form("PDF Viewer", BoxLayout.y());
/*Button devGuide = new Button("Show PDF");
devGuide.addActionListener(e -> {
    FileSystemStorage fs = FileSystemStorage.getInstance();
    String fileName = fs.getAppHomePath() + "pdf.pdf";
    if(!fs.exists(fileName)) {
        Util.downloadUrlToFile("http://localhost/finalpi/web/app_dev.php/Facture/pdf", fileName, true);
    }
    Display.getInstance().execute(fileName);
});
Affichefacture.add(devGuide);

Affichefacture.show();*/




Button pdfButton = new Button();
Style closeStyle5 = pdfButton.getAllStyles();
closeStyle5.setFgColor(0xffffff);
closeStyle5.setBgTransparency(0);
closeStyle5.setPaddingUnit(Style.UNIT_TYPE_DIPS);
closeStyle5.setPadding(3, 3, 3, 3);
closeStyle5.setBorder(RoundBorder.create().shadowOpacity(100));
FontImage.setMaterialIcon(pdfButton, FontImage.MATERIAL_FILE_DOWNLOAD);      
           
           
           
           
           
           
           
             
     pdfButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
  
                ConnectionRequest req = new ConnectionRequest();               
           
              Display.getInstance().execute("http://localhost/finalpi/web/app_dev.php/pdf");
      
            }
        });
      
           








Affichefacture.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), ev->{
           
        new HomeForm(res).show();

            
        });


         bt_supprimer=new Button("Supprimer");
        
         bt_supprimer.addActionListener((e)->{
            ServiceFacture ser = new ServiceFacture();
           // Reclamation t = new Reclamation();
            ser.Supprimerfac(idFacture);
         });
         
         Affichefacture.add(bt_supprimer);
       Affichefacture.add(pdfButton);
           
              //Label l11 =new Label("---------------------------------------------------------------");
              Label l11 =new Label("__________________________________________________________________");
l11.getAllStyles().setFgColor(0xC0C0C0);
Affichefacture.add(l11);
  
  















 
       
        
         }  
        
      
        
       
//        lb.setText(serviceReclamation.getListDemande().toString());
        
//          Affichefacture.getToolbar().addCommandToRightBar("Retour", null, (ev)->{AddreclamtionForm h=new AddreclamtionForm();
      //    h.getAjouterReclamation().show();
        //  });
          
          Toolbar tb = Affichefacture.getToolbar(); 
			   tb.addCommandToSideMenu("Facture",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
				    // AddfactureForm1 ajouterdem = new AddfactureForm1();
                                    //ajouterdem.getAjoutefacture().show();  
				 
				       Toolbar tb2 = Affichefacture.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
//			                            Connecter Connecter=new Connecter();
                                                  //  Connecter.getConnecter().show();
					      }
				      });
		                       Affichefacture.show();
				   }
			   });   
                           
			   tb.addCommandToSideMenu("Reclamation",null,new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent evt) {
//				     AddreclamtionForm ajouterrec = new AddreclamtionForm();
                                                  //    ajouterrec .getAjouterReclamation().show(); 
				 
				       Toolbar tb2 = Affichefacture.getToolbar();
				       
				       tb2.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
			                         //   Connecter Connecter=new Connecter();
                                                    //Connecter.getConnecter().show();
					      }
				      });
		                      Affichefacture.show();
				   }
			   }); 
                           
                           
                           
                            Toolbar tb1 = Affichefacture.getToolbar(); 
			    tb1.addCommandToOverflowMenu("Déconnecter",null, new ActionListener() {
					      @Override
					      public void actionPerformed(ActionEvent evt) {
//			                            Connecter Connecter=new Connecter();
                                                  //  Connecter.getConnecter().show();
////				 
////				       Toolbar tb4 = AjouterReclamation.getToolbar();
				       
				     
		                       Affichefacture.show();
				   }
			   });  
                            
    
        
    }

   
    public Form getAffichefacture() {
        return Affichefacture;
    }

    public void setAffichefacture(Form Affichefacture) {
        this.Affichefacture = Affichefacture;
    }

    
    public SpanLabel getLb() {
        return lb;
    }

    public void setLb(SpanLabel lb) {
        this.lb = lb;
    }
    
}
