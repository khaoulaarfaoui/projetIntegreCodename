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
import com.mycompany.gui.ProfileFormSMBlog;
import com.mycompany.gui.SideMenuBaseFormBlog;
import com.mycompany.myapp.entities.post;
import com.mycompany.myapp.services.ServiceTaskBlog;
import java.util.ArrayList;

/**
 *
 * @author azizl
 */
public class Sprint_form_blog  extends SideMenuBaseFormBlog{
      private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
       ServiceTaskBlog srv = new ServiceTaskBlog();
       Form current;
       
       
       public Sprint_form_blog (Resources res )
       {
            super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        ArrayList<post> cats = srv.getAllTasks();
        int k = cats.size();
        
        

        
        
            Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.west(
                                BoxLayout.encloseY(
                                    new Label("POSTS"+"", "Title"),
                                    new Label("connected as "+"Blog Manager", "SubTitle")
                                )
                        )
                        
                );
            
                tb.setTitleComponent(titleCmp);
                
                
                FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
         
        
        for (int i=0;i<k;i++){
        addButtonBottom(res,arrowDown, cats.get(i).getTitle(), 0x5ae29d, true,i,cats.get(i).getId());
        }
        setupSideMenu(res);
            
            
       }

 
           private void addButtonBottom(Resources res,Image arrowDown, String text, int color, boolean first,int x,int id) {
        SpanButton finishLandingPage = new SpanButton(text);
     
       // finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
       // finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
          
        finishLandingPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Sprints_form_blog(res, x).show();     
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
        new ProfileFormSMBlog(res).show();  
    }

    @Override
    protected void showOtherForm1(Resources res) {
        new ProfileFormSMBlog(res).show();  
    }

    @Override
    protected void editprofile(Resources res) {
        new ProfileFormSMBlog(res).show();  
    }

    @Override
    protected void showForm2(Resources res) {
       new ProfileFormSMBlog(res).show();  
    }
    
}
