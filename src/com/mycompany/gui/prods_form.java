/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import static com.codename1.ui.Image.createImage;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.ServiceTask;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dhake
 */
public class prods_form extends SideMenuBaseForm {
    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    String username1;
    int id1;
    String img1;
    ServiceTask srv = new ServiceTask();
    
    
    Form current;
  

    public prods_form(Resources res,int id)  {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
     
        ArrayList<Produit> prods=srv.getAllp(id);
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        ArrayList<Categorie> cats = srv.getAllTasks();
       // System.err.println(sprints);
      int k = cats.size();
      
       // completedTasks.setUIID("CompletedTasks");
  FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
         
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButton");
            new Sprint_ajout_Form(res,id).show();
            
            
      
        });
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.west(
                                BoxLayout.encloseY(
                                    new Label("PRODUCTS"+"", "Title"),
                                    new Label("connected as "+"Stock Manager", "SubTitle")
                                )
                            ),
                        GridLayout.encloseIn(2)
                );
        
        
        tb.setTitleComponent(titleCmp);
                        
   for (int i=0;i<prods.size();i++){
       cont(prods.get(i));
   }
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
         
        
     
        setupSideMenu(res);
    }

private void cont (Produit p){
      Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
      Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      Label l = new Label("reference:" + p.getReference());
      Label l3 = new Label("Nom produit:" + p.getNom_produit());
      Label l5 = new Label("Quantite:" + p.getQuantite());
      Label l6 = new Label("PU:" + p.getPrix_unitaire());
      Label l7 = new Label("PV:" + p.getPrix_vente());
      Label l8 = new Label("DF:" + p.getDate_fabrication());
      Label l9 = new Label("DE:" + p.getDate_expiration());
      Label l11 = new Label("       ");
      Label l12 = new Label("       ");
      
      c1.add(l);
      c1.add(l3);
      c1.add(l5);
      c1.add(l6);
      c1.add(l7);
      c1.add(l8);
      c1.add(l9);
      c1.add(l11);
      c1.add(l12);
      
      
      
       Image i=null;
      try {
         
          System.out.println(p.getPhotoProduit());
           i = createImage("file://wamp64/www/finalpi/web/uploads/post/"+p.getPhotoProduit());
           i=i.scaled(300, 300);
          
        } catch (IOException ex) {
            
        }
      c.add(i);
      c.add(c1);
      add(c);
      
              
}
    
    private void addButtonBottom(Resources res,Image arrowDown, String text,String date, int color, boolean first,int x,int id) {
        SpanButton finishLandingPage = new SpanButton(date);
     
       // finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
       // finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
          add(new Label(text));
        finishLandingPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    
            }
        });
        add(FlowLayout.encloseIn(finishLandingPage));
        
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        /*       g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);*/
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
new ProfileFormSM(res).show();    }
    protected void showOtherForm1(Resources res) {
        new ProfileFormSM(res);
    }
    
    protected void showsprint(Resources res,int id) {
        
    }
    @Override
    protected void editprofile(Resources res) {
new ProfileFormSM(res).show();    }

    @Override
    protected void showForm2(Resources res) {
new ProfileFormSM(res).show();
    }
    

    

    

}