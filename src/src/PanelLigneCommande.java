package src;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

public class PanelLigneCommande extends JPanel {
    public static final Color BGM = new Color(223,231,236);
    public static final Color BR = new Color(83,129,142);
    public static final Color BGS = new Color(117,149,179);
    public static final Color BLK = new Color(0,0,0);
    private Object variable,bufferId;
    private JButton CrationButton,ModifyButton,DeleteButton,FilterButton,CrationButtonCommande,ModifyButtonCommande,DeleteButtonCommande;
    private String[] titre1;
    private Map<String,String> tabVerif;
    private boolean verifProps;
    private TableAffiche panelScroll;
    private String[] titre;
    private JTextField SearchField_1,tQuantite,tQuantite2;
    private JPanel SecondaryPanel,TertiaryPanel,SecondaryPanelCommande,TertiaryPanelCommande;
    private JPanel parent;
    private JComboBox tCommande;
    private JScrollPane tabLigneCommande;
    private JLabel l5;
    private PanelAffichage panelImport;
    private TableAfficheCommande tableExt;

    public PanelLigneCommande(Object bufferIdImport, PanelAffichage panelImport)
    {
        this.bufferId = bufferIdImport;
        this.panelImport = panelImport;
        tableExt = new TableAfficheCommande(this.bufferId,  panelImport, l5,SecondaryPanelCommande,this);
        panelImport.add(this);
        this.setBounds(5, 520, 1115, 170);
        //this.setBorder(new LineBorder(BR, 2, true));
        this.setBackground(BGM);
        this.setLayout(null);


        SecondaryPanelCommande = new JPanel();
        SecondaryPanelCommande.setBorder(new LineBorder(BR, 2, true));
        SecondaryPanelCommande.setBounds(5, 15, 1105, 70);
        SecondaryPanelCommande.setBackground(BGM);
        this.add(SecondaryPanelCommande);
        SecondaryPanelCommande.setLayout(null);
        TertiaryPanelCommande = new JPanel();
        TertiaryPanelCommande.setBorder(new LineBorder(BR, 2, true));
        TertiaryPanelCommande.setBounds(5, 100, 1105, 70);
        TertiaryPanelCommande.setBackground(BGM);
        this.add(TertiaryPanelCommande);
        TertiaryPanelCommande.setLayout(null);
        System.out.println(TertiaryPanelCommande.getParent());



        //CrationButtonCommande.addActionListener(this::actionPerformed);

        JLabel l=new JLabel("Articles");
        l.setBounds(10, 15, 100, 25);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        TertiaryPanelCommande.add(l);

        JLabel l2 =new JLabel("Quantité");
        l2.setBounds(320, 15, 100, 25);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        TertiaryPanelCommande.add(l2);

        ModelArticle modca = new ModelArticle();
        Object[][] art =   modca.findAll();
        String[] tab = new String[art.length];
        int cpt1=0;
        for(int i =0; i < art.length;i++) {

            tab[cpt1] = (Integer.toString((Integer) art[i][0]))+ " | " +(Integer.toString((Integer) art[i][4]))+ " | " +((String) art[i][5]);
            cpt1++;

        }
        tCommande =new JComboBox(tab);
        tCommande.setBounds(10, 35, 300, 25);
        //myMap.put(nv,t);
        TertiaryPanelCommande.add(tCommande);
        tCommande.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    //System.out.println(e);
                    tCommande.setSelectedItem(e.getItem());
                    //System.out.println(tCommande.getSelectedItem());
                }

            }
        });



        tQuantite =new JTextField();
        tQuantite.setBounds(320, 35, 100, 25);
        //myMap.put(nv,t);
        TertiaryPanelCommande.add(tQuantite);
        tQuantite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                tQuantite.setText(tQuantite.getText());
                //System.out.println(tQuantite.getText());
                // e.getKeyChar() est le caractère correspondant à la touche pressée
            }
        });

        CrationButtonCommande = new JButton("Ajouter");
        CrationButtonCommande.setForeground(BGS);
        CrationButtonCommande.setBackground(BGM);
        CrationButtonCommande.setBorder(new LineBorder(BR,2,true));
        CrationButtonCommande.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CrationButtonCommande.setVerticalAlignment(SwingConstants.TOP);
        CrationButtonCommande.setBounds(985, 32, 100, 25);
        TertiaryPanelCommande.add(CrationButtonCommande);
        CrationButtonCommande.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //System.out.println(tCommande.getSelectedItem());
                String idArticle = (String) tCommande.getSelectedItem();
                //System.out.println(idArticle);
                idArticle = idArticle.substring(0,1);
                //System.out.println(idArticle);
                int idArticle2 = Integer.parseInt(idArticle);
                int idCommande = (int) bufferId;
                int Quantite = Integer.parseInt(tQuantite.getText());
                ModelLigneCmd modl = new ModelLigneCmd();
                modl.addLigneDeCommande(idCommande,idArticle2,Quantite);

                refresh();
                tQuantite.setText("");
            }
        });


        JLabel l3=new JLabel("Articles");
        l3.setBounds(10, 15, 300, 25);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        SecondaryPanelCommande.add(l3);

        JLabel l4 =new JLabel("Quantité");
        l4.setBounds(320, 15, 100, 25);
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        SecondaryPanelCommande.add(l4);

        l5=new JLabel("");
        l5.setBounds(10, 35, 300, 25);
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        SecondaryPanelCommande.add(l5);

        tQuantite2 =new JTextField();
        tQuantite2.setBounds(320, 35, 100, 25);
        //myMap.put(nv,t);
        SecondaryPanelCommande.add(tQuantite2);
        tQuantite2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                tQuantite2.setText(tQuantite2.getText());
                //System.out.println(tQuantite.getText());
                // e.getKeyChar() est le caractère correspondant à la touche pressée
            }
        });

        ModifyButtonCommande = new JButton("Modifier");
        ModifyButtonCommande.setBackground(BGM);
        ModifyButtonCommande.setForeground(BGS);
        ModifyButtonCommande.setBorder(new LineBorder(BR,2,true));
        ModifyButtonCommande.setVerticalAlignment(SwingConstants.TOP);
        ModifyButtonCommande.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ModifyButtonCommande.setBounds(875, 15, 100, 25);
        SecondaryPanelCommande.add( ModifyButtonCommande);
        ModifyButtonCommande.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                String idArticle = (String) l5.getText();
                idArticle = idArticle.substring(0,1);
                //System.out.println(idArticle);
                int idArticle2 = Integer.parseInt(idArticle);
                int idCommande = (int) bufferId;
                int Quantite = Integer.parseInt(tQuantite2.getText());

                ModelLigneCmd modl = new ModelLigneCmd();
                modl.modLigneDeCommande(idCommande,idArticle2,Quantite);

                refresh();
                tQuantite2.setText("");
                l5.setText("");
            }
        });

        DeleteButtonCommande = new JButton("Supprimer");
        DeleteButtonCommande.setBackground(BGM);
        DeleteButtonCommande.setForeground(BGS);
        DeleteButtonCommande.setBorder(new LineBorder(BR,2,true));
        DeleteButtonCommande.setVerticalAlignment(SwingConstants.TOP);
        DeleteButtonCommande.setBounds(985, 15, 100, 25);
        DeleteButtonCommande.setFont(new Font("Tahoma", Font.PLAIN, 18));
        SecondaryPanelCommande.add(DeleteButtonCommande);
        DeleteButtonCommande.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                String idArticle = (String) l5.getText();
                //System.out.println(idArticle);
                idArticle = idArticle.substring(0,1);
                //System.out.println(idArticle);
                int idArticle2 = Integer.parseInt(idArticle);
                int idCommande = (int) bufferId;


                ModelLigneCmd modl = new ModelLigneCmd();
                modl.deleteLigneDeCommande(idCommande,idArticle2);

                refresh();
            }
        });

        this.repaint();


    }

    public void setTextL5(String tab)
    {
        l5.setText(tab);
        SecondaryPanelCommande.repaint();
    }

    public void refresh()
    {
        this.panelImport.remove(tableExt);
        tableExt = new TableAfficheCommande(this.bufferId,  panelImport, l5,SecondaryPanelCommande,this);
        this.panelImport.add(tableExt);
    }

    public TableAfficheCommande getTabExt()
    {
        return tableExt;
    }

    public JLabel getL5()
    {
        return l5;
    }

    public JPanel getSecondPanel()
    {
        return SecondaryPanelCommande;
    }

    public Object getBufferId() {
        return bufferId;
    }
    public void setBufferId(Object bufferId) {
        this.bufferId = bufferId;
    }
}
