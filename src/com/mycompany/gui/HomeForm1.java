/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
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
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm1 extends SideMenuBaseForm {

    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
    Form current;
    public HomeForm1(Resources res) {
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
                                 new Label("facture", "Title"),
                                new Label("connected as " + "Admin", "abouda")
                        )
                )
        );
 tb.setTitleComponent(titleCmp);

        setupSideMenu(res);
        
        
        //current=this;
       // setTitle("Home");
      //  setLayout(BoxLayout.y());
        
       // add(new Label("Choose an option"));
           //     Button btnAddfacture = new Button("Add reclamation");

       // Button btnAddTask = new Button("Add Task");
       // Button btnListTasks = new Button("List Tasks");
      //  Button btnListrec = new Button("affiche reclamation");
       // Button btnListFac= new Button("List fac");
                Button btnaddFac= new Button("affiche facture");

      //  Button Ajouterrec = new Button("affiche facture");
        Label espace = new Label("");
  Label espace1 = new Label("");

          
     
        
          

       
        
        
                btnaddFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddfactureForm1(res).show();
            }
        });
                add(btnaddFac);

     //   btnAddfacture.addActionListener(e-> new AddreclamtionForm(current).show());
     //   btnAddTask.addActionListener(e-> new AddTaskForm(current).show());
     //   btnListTasks.addActionListener(e-> new ListTasksForm(current).show());
     //   btnListrec.addActionListener(e-> new ListrecForm(current).show());
       // btnListFac.addActionListener(e-> new ListfacForm1(current).show());


        
        
    }

    public HomeForm1() {
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
