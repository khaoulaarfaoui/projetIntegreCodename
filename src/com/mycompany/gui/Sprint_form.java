/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.gui.SideMenuBaseForm;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.models.XYSeries;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.CubicLineChart;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanButton;
import com.codename1.io.File;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.services.ServiceTask;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Asus
 */
public class Sprint_form extends SideMenuBaseForm {
    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    String username1;
    int id1;
    String img1;
    ServiceTask srv = new ServiceTask();
    
    
    Form current;
  

    public Sprint_form(Resources res)  {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
     
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        ArrayList<Categorie> cats = srv.getAllTasks();
       // System.err.println(sprints);
      int k = cats.size();
      Container remainingTasks = BoxLayout.encloseY(
                        new Label("Team", "CenterTitle"),
                        new Label("gg", "CenterSubTitle")
                );
        remainingTasks.setUIID("RemainingTasks");
        Container completedTasks = BoxLayout.encloseY(
                        new Label("Project", "CenterTitle"),
                        new Label("gg", "CenterSubTitle")
        );
        completedTasks.setUIID("CompletedTasks");
  FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
         
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButton");
            
            
            
      
        });
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.west(
                                BoxLayout.encloseY(
                                    new Label("CATEGORIES"+"", "Title"),
                                    new Label("connected as "+"Stock Manager", "SubTitle")
                                )
                            ),
                        GridLayout.encloseIn(2, remainingTasks, completedTasks)
                );
        
        
        tb.setTitleComponent(titleCmp);
                        
     
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
         
        
        for (int i=0;i<k;i++){
        addButtonBottom(res,arrowDown, cats.get(i).getNom_categorie(),cats.get(i).getDescription_categorie(), 0x5ae29d, true,i,cats.get(i).getId_categorie());
        }
        setupSideMenu(res);
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
                new Sprints_form(res, x).show();     
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
