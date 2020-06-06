package src;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TableAfficheCommande  extends JScrollPane{
    public JTable MainTableLigneCommande;
    public Object[][] DATA;
    public String[] COLONNE= {"Ref. Commande","Ref. Article","Libellé","Prix","Quantité","Total par Article"};;
    private ZModel model3;
    public static final Color BR = new Color(83,129,142);
    private PanelAffichage panAffi;
    private JLabel l5;
    private JPanel SecondaryPanel;
    private PanelLigneCommande mainPan;

    public TableAfficheCommande(Object bufferIdImport, PanelAffichage panelImport,JLabel l5Import,JPanel SecondaryPanelImport,PanelLigneCommande panImport)
    {
        l5 = l5Import;
        SecondaryPanel = SecondaryPanelImport;
        mainPan = panImport;
        panelImport.add(this);
        ModelLigneCmd mod=new ModelLigneCmd();
        DATA = mod.getLigneDeCommandesParIdCmd((Integer) bufferIdImport);
        ZModel model3 = new ZModel(DATA,COLONNE);

        this.setBorder(new LineBorder(BR,2,true));
        this.setBounds(10,380 , 1105, 140);
        MainTableLigneCommande = new JTable(model3);
        MainTableLigneCommande.setBorder(null);
        MainTableLigneCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.setViewportView(MainTableLigneCommande);
        MainTableLigneCommande.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel3 = MainTableLigneCommande.getSelectionModel();
        selectionModel3.addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent event) {
                if(MainTableLigneCommande.getSelectedRow() > -1) {

                    if(event.getValueIsAdjusting()) {

                    }else
                    {
                        String[] tabExtract = model3.getValuesAt(MainTableLigneCommande.getSelectedRow());
                        String tab = tabExtract[1] + " | " + tabExtract[4] + " | " + tabExtract[2];
                        mainPan.setTextL5(tab);

                    }

                }
            }
        });
    }
}
