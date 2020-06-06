package src;


import src.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TableAffiche extends JScrollPane{

    public JTable MainTableClient;
    public Object[][] DATA;
    public String[] COLONNE;
    private ZModel model3;
    public static final Color BR = new Color(83,129,142);
    private PanelAffichage panAffi;
    private TableAfficheCommande tabCommande;

    public TableAffiche(String[] COLONNEImport, Object variable, PanelAffichage panAffiImport)
    {
        panAffi = panAffiImport;
        this.setBorder(new LineBorder(BR,2,true));



        if(variable.getClass().getName().equals("src.Client"))
        {
            this.setBounds(10, 56, 1105, 415);
            ModelClient mod=new ModelClient();
            DATA = mod.findAll();
        }
        else if(variable.getClass().getName().equals("src.Article"))
        {
            this.setBounds(10, 56, 1105, 415);
            ModelArticle mod=new ModelArticle();
            DATA = mod.findAll();
        }
        else if(variable.getClass().getName().equals("src.Commande"))
        {
            this.setBounds(10, 56, 1105, 140);
            ModelCommande mod=new ModelCommande();
            DATA = mod.findAll();
        }


        model3 = new ZModel(DATA,COLONNEImport);
        MainTableClient = new JTable(model3);
        MainTableClient.setBorder(null);
        MainTableClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.setViewportView(MainTableClient);
        MainTableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel3 = MainTableClient.getSelectionModel();
        selectionModel3.addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent event) {
                if(MainTableClient.getSelectedRow() > -1) {
                    if(event.getValueIsAdjusting()) {

                    }else
                    {
                        panAffi.textJ(model3.getValuesAt(MainTableClient.getSelectedRow()));					}
                        panAffi.setBufferId(model3.getValueAt(MainTableClient.getSelectedRow(),0));
                        if(variable.getClass().getName().equals("src.Commande"))
                        {
                            panAffi.setBufferId(model3.getValueAt(MainTableClient.getSelectedRow(),0));
                            System.out.println(panAffi.getPanExt());
                            if(panAffi.getPanExt()==null)
                            {
                                Object buf = panAffi.getBufferId();
                                PanelLigneCommande panExt = new PanelLigneCommande(buf,panAffi);
                                panAffi.setPanExt(panExt);
                                panAffi.add(panAffi.getPanExt());
                            }
                            else
                            {
                                panAffi.getPanExt().setBufferId(model3.getValueAt(MainTableClient.getSelectedRow(),0));
                                Object buf = panAffi.getPanExt().getBufferId();
                                System.out.println(buf);
                                panAffi.remove(panAffi.getPanExt().getTabExt());
                                TableAfficheCommande tableExt = new TableAfficheCommande(buf,  panAffi, panAffi.getPanExt().getL5(),panAffi.getPanExt().getSecondPanel(),panAffi.getPanExt());


                            }
                        }
                }
            }
        });


    }

}
