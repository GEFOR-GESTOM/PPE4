package src;


import src.Categorie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelAffichage extends JPanel {
    public static final Color BGM = new Color(223,231,236);
    public static final Color BR = new Color(83,129,142);
    public static final Color BGS = new Color(117,149,179);
    public static final Color BLK = new Color(0,0,0);
    private HashMap<String, JComponent> myMap;
    private HashMap<String, JComponent> myMap2;
    private HashMap<String, String> myList = new HashMap<String, String>();
    private HashMap<String, String> myList2 = new HashMap<String, String>();
    private HashMap<String, JTextField> mySearchList = new HashMap<String, JTextField>();
    private JComponent jc;
    private Object variable,bufferId;
    private JButton CrationButton,ModifyButton,DeleteButton,FilterButton,CrationButtonCommande,ModifyButtonCommande,DeleteButtonCommande;
    private String[] titre1;
    private Map<String,String> tabVerif;
    private boolean verifProps;
    private TableAffiche panelScroll;
    private TableAffiche2 panelScroll2;
    private String[] titre;
    private JTextField SearchField_1,tQuantite,tQuantite2;
    private JPanel SecondaryPanel,TertiaryPanel,SecondaryPanelCommande,TertiaryPanelCommande;
    private JPanel parent;
    private JComboBox tCommande;
    private JScrollPane tabLigneCommande;
    private JLabel l5;
    private PanelLigneCommande panExt;
    //private String[] tabRegex = {"[a-zA-Z]+","[a-zA-Z]+","","","codepostal","","tel"}




    public PanelAffichage(String[] titreImport,Object variable, JPanel parentImport) {
        /*
         * JComboBox jc1= new JComboBox(); jc1.addItem("TEST1"); jc1.addItem("TEST2");
         * jc = jc1; System.out.println(jc.getClass().getName());
         * jc.setToolTipText((String) jc1.getSelectedItem());
         * System.out.println(jc.getToolTipText().getClass());
         */
        this.parent = parentImport;
        titre = titreImport;
        this.variable = variable;
        panelScroll = new TableAffiche(titre,this.variable,this);
        this.add(panelScroll);
        this.setBounds(0, 0, 1125, 705);
        this.setBorder(new LineBorder(BR, 2, true));
        this.setBackground(BGM);
        this.setLayout(null);
        String mtdName = (String)this.variable.getClass().getName();
        if(mtdName.equals("src.Commande"))
        {
            SecondaryPanel = new JPanel();
            SecondaryPanel.setBorder(new LineBorder(BR, 2, true));
            SecondaryPanel.setBounds(10, 210, 1105, 70);
            SecondaryPanel.setBackground(BGM);
            this.add(SecondaryPanel);
            SecondaryPanel.setLayout(null);
            TertiaryPanel = new JPanel();
            TertiaryPanel.setBorder(new LineBorder(BR, 2, true));
            TertiaryPanel.setBounds(10, 295, 1105, 70);
            TertiaryPanel.setBackground(BGM);
            this.add(TertiaryPanel);
            TertiaryPanel.setLayout(null);
        }
        else
        {
            SecondaryPanel = new JPanel();
            SecondaryPanel.setBorder(new LineBorder(BR, 2, true));
            SecondaryPanel.setBounds(10, 483, 1105, 100);
            SecondaryPanel.setBackground(BGM);
            this.add(SecondaryPanel);
            SecondaryPanel.setLayout(null);
            TertiaryPanel = new JPanel();
            TertiaryPanel.setBorder(new LineBorder(BR, 2, true));
            TertiaryPanel.setBounds(10, 593, 1105, 100);
            TertiaryPanel.setBackground(BGM);
            this.add(TertiaryPanel);
            TertiaryPanel.setLayout(null);
        }


        CrationButton = new JButton("Ajouter");
        CrationButton.setForeground(BGS);
        CrationButton.setBackground(BGM);
        CrationButton.setBorder(new LineBorder(BR,2,true));
        CrationButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CrationButton.setVerticalAlignment(SwingConstants.TOP);
        CrationButton.setBounds(985, 32, 100, 25);
        TertiaryPanel.add(CrationButton);
        CrationButton.addActionListener(this::actionPerformed);

        if(!mtdName.equals("src.Commande"))
        {
            ModifyButton = new JButton("Modifier");
            ModifyButton.setBackground(BGM);
            ModifyButton.setForeground(BGS);
            ModifyButton.setBorder(new LineBorder(BR,2,true));
            ModifyButton.setVerticalAlignment(SwingConstants.TOP);
            ModifyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
            ModifyButton.setBounds(985, 15, 100, 25);
            SecondaryPanel.add(ModifyButton);
            ModifyButton.addActionListener(this::actionPerformed);
        }


        DeleteButton = new JButton("Supprimer");
        DeleteButton.setBackground(BGM);
        DeleteButton.setForeground(BGS);
        DeleteButton.setBorder(new LineBorder(BR,2,true));
        DeleteButton.setVerticalAlignment(SwingConstants.TOP);
        DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        if(mtdName.equals("src.Commande"))
        {
            DeleteButton.setBounds(985, 15, 100, 25);
        }
        else
        {
            DeleteButton.setBounds(985, 55, 100, 25);
        }

        SecondaryPanel.add(DeleteButton);
        DeleteButton.addActionListener(this::actionPerformed);

        /*
         * JPanel PanelSecondaryAffichage = new JPanel();
         * PanelSecondaryAffichage.setBackground(BGM);
         * PanelSecondaryAffichage.setBounds(10, 11, 813, 185);
         * SecondaryPanel.add(PanelSecondaryAffichage);
         * PanelSecondaryAffichage.setLayout(null);
         */




        SearchField_1 = new JTextField();
        SearchField_1.setBorder(new LineBorder(BR,2,true));
        SearchField_1.setBounds(500, 25, 100, 20);
        this.add(SearchField_1);

        SearchField_1.setColumns(10);
        /*JTextField SearchField_2 = new JTextField();
        SearchField_2.setBorder(new LineBorder(BR,2,true));
        SearchField_2.setBounds(466, 25, 100, 20);
        this.add(SearchField_2);
        SearchField_2.setColumns(10);
        JTextField SearchField_3 = new JTextField();
        SearchField_3.setBorder(new LineBorder(BR,2,true));
        SearchField_3.setBounds(691, 25, 100, 20);
        this.add(SearchField_3);
        SearchField_3.setColumns(10);*/



        /*JLabel SearchLabel_2 = new JLabel("SearchLabel");
        SearchLabel_2.setBounds(370, 25, 95, 15);
        this.add(SearchLabel_2);
        JLabel SearchLabel_3 = new JLabel("SearchLabel");
        SearchLabel_3.setBounds(580, 25, 95, 15);
        this.add(SearchLabel_3);*/

        if(mtdName.equals("src.Commande"))
        {
            JLabel SearchLabel_1 = new JLabel("Recherche par Nom de client");
            SearchLabel_1.setBounds(170, 25, 300, 15);
            this.add(SearchLabel_1);
            mySearchList.put("refCommande",SearchField_1);
        }
        else if(mtdName.equals("src.Client"))
        {
            JLabel SearchLabel_1 = new JLabel("Recherche par Nom");
            SearchLabel_1.setBounds(170, 25, 300, 15);
            this.add(SearchLabel_1);
            mySearchList.put("refCommande",SearchField_1);
        }
        else if(mtdName.equals("src.Article"))
        {
            JLabel SearchLabel_1 = new JLabel("Recherche par libellé");
            SearchLabel_1.setBounds(170, 25, 300, 15);
            this.add(SearchLabel_1);
            mySearchList.put("refCommande",SearchField_1);
        }

        FilterButton = new JButton("Rechercher");
        FilterButton.setForeground(BGS);
        FilterButton.setBackground(BGM);
        FilterButton.setBorder(new LineBorder(BR,2,true));
        FilterButton.setVerticalAlignment(SwingConstants.TOP);
        FilterButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        FilterButton.setBounds(806, 11, 139, 34);
        this.add(FilterButton);
        FilterButton.addActionListener(this::actionPerformed);
        //Article a = new Article();
        //String [] tit = a.viewCarac();

        int cpt=0;

        myMap = new HashMap<String, JComponent>();
        myMap2 = new HashMap<String, JComponent>();
        titre1 = new String[titre.length-1];
        for (int i = 1; i <titre.length;i++)
        {
            titre1[i-1] = titre[i];
        }

        int setb = 985/(titre1.length);
        for(String c:titre1) {
            String nv = (String)(this.variable.getClass().getName()+cpt);
            String nv2 = (String)(this.variable.getClass().getName()+(cpt+1));
            String nv3 = (String)(this.variable.getClass().getName()+(cpt+2));
            int setl=(setb*cpt)+(int)(setb*0.05);

            JLabel l=new JLabel(c);

            l.setBounds(setl, 15, 100, 25);
            l.setHorizontalAlignment(SwingConstants.CENTER);
            TertiaryPanel.add(l);
            JLabel l2=new JLabel(c);
            l2.setBounds(setl, 15, 100, 25);
            if(mtdName.equals("src.Commande"))
            {
                l.setBounds(setl, 10, 100, 25);
                l2.setBounds(setl, 10, 100, 25);
            }
            else
            {
                l.setBounds(setl, 20, 100, 25);
                l2.setBounds(setl, 20, 100, 25);
            }
            l2.setHorizontalAlignment(SwingConstants.CENTER);
            SecondaryPanel.add(l2);

            if(mtdName.equals("src.Article") && cpt==0) {
                ModelCategorie modca = new ModelCategorie();
                java.util.List<Categorie> cat =   modca.findAll();
                String[] tab = new String[cat.size()];
                int cpt1=0;
                for(Categorie catName:cat) {

                    tab[cpt1] = catName.getLibelleCat();
                    cpt1++;

                }
                JComboBox t =new JComboBox(tab);
                t.setBounds(setl, 50, 100, 25);
                myMap.put(nv,t);
                TertiaryPanel.add(t);
                JComboBox t2 =new JComboBox(tab);
                t2.setBounds(setl, 50, 100, 25);
                myMap2.put(nv2,t2);
                SecondaryPanel.add(t2);
            }
            else if(mtdName.equals("src.Article"))
            {
                JTextField t =new JTextField();
                t.setBounds(setl, 50, 100, 25);
                t.setHorizontalAlignment(SwingConstants.CENTER);
                myMap.put(nv, t);
                TertiaryPanel.add(t);
                JTextField t2 =new JTextField();
                t2.setBounds(setl, 50, 100, 25);
                t2.setHorizontalAlignment(SwingConstants.CENTER);
                myMap2.put(nv2, t2);
                SecondaryPanel.add(t2);
            }
            else if(mtdName.equals("src.Commande") && cpt==0) {
                ModelClient modca = new ModelClient();
                Object[][] cat =   modca.findAll();
                String[] tab = new String[cat.length];
                for(int i = 0; i < cat.length; i++) {
                    tab[i] = (String) cat[i][1];
                }
                JComboBox t =new JComboBox(tab);
                t.setBounds(setl, 35, 100, 25);
                myMap.put(nv,t);
                TertiaryPanel.add(t);
                JComboBox t2 =new JComboBox(tab);
                t2.setBounds(setl, 35, 100, 25);
                myMap2.put(nv2,t2);
                SecondaryPanel.add(t2);
            }
            else if(mtdName.equals("src.Commande"))
            {
                JTextField t =new JTextField();
                t.setBounds(setl, 35, 100, 25);
                t.setHorizontalAlignment(SwingConstants.CENTER);
                myMap.put(nv, t);
                TertiaryPanel.add(t);
                JTextField t2 =new JTextField();
                t2.setBounds(setl, 35, 100, 25);
                t2.setHorizontalAlignment(SwingConstants.CENTER);
                myMap2.put(nv2, t2);
                SecondaryPanel.add(t2);
            }
            else {

                JTextField t =new JTextField();
                t.setBounds(setl, 50, 100, 25);
                t.setHorizontalAlignment(SwingConstants.CENTER);
                myMap.put(nv, t);
                TertiaryPanel.add(t);
                JTextField t2 =new JTextField();
                t2.setBounds(setl, 50, 100, 25);
                t2.setHorizontalAlignment(SwingConstants.CENTER);
                myMap2.put(nv2, t2);
                SecondaryPanel.add(t2);

            }

            cpt++;
        }

    }
    public void textJ(String[] tabLigne) {

        for(String mapKey:myMap2.keySet()) {
            int cpt = Integer.parseInt(mapKey.substring(mapKey.length()- 1, mapKey.length()));

            if (mapKey.equals("src.Article0")|myMap2.get(mapKey).getClass().getName().equals("javax.swing.JComboBox"))
            {

            } else
            // if(cpt==2 |cpt==3|cpt==4|cpt==5|cpt==6)
            {
                ((JTextField) myMap2.get(mapKey)).setText((tabLigne[cpt]));
                //System.out.println(tabLigne[cpt]);
                //System.out.println(cpt);
            }

            //System.out.println(mapKey);
            //System.out.println(tabLigne[cpt]);
            //System.out.println(cpt);
            //System.out.println(mapKey);
        }

    }
    public void actionPerformed(ActionEvent e){

        System.out.println(e.getSource());
        System.out.println(CrationButtonCommande);
        if(e.getSource()==CrationButton) {
            this.ajouter(e);
        }else if(e.getSource()==ModifyButton) {
            this.modifier(e);
        }else if(e.getSource()==DeleteButton) {
            this.effacer(e);
        }
        else if(e.getSource()==FilterButton) {
            this.rechercher(e);
        }

    }
    public void ajouter(ActionEvent e){

        // TODO Auto-generated method stub
        for (String mapKey : myMap.keySet()) {

            if (myMap.get(mapKey).getClass().getName().equals("javax.swing.JComboBox")) {
                myMap.get(mapKey).setToolTipText((String) ((JComboBox) myMap.get(mapKey)).getSelectedItem());
            } else {

                myMap.get(mapKey).setToolTipText((String) ((JTextField) myMap.get(mapKey)).getText());
            }

        }

        for (String mapKey : myMap.keySet()) {
            myList.put(mapKey, myMap.get(mapKey).getToolTipText());
            //System.out.println(myList.get(mapKey));
        }

        if(this.verif(myList)) {

            String mtdName = (String) this.variable.getClass().getName();
            switch (mtdName) {
                case "src.Client":
                    ModelClient modc = new ModelClient();
                    modc.addClient(myList);
                    break;

                case "src.Article":
                    ModelArticle moda = new ModelArticle();
                    moda.addArticle(myList);
                    break;

                case "src.Commande":

                    ModelCommande modcl= new ModelCommande();
                    modcl.addCommande(myList);

                    break;

                default:
                    break;
            }
        }

        if(this.verif(myList)) {
            for (String mapKey : myMap.keySet()) {
                if (myMap.get(mapKey).getClass().getName().equals("javax.swing.JComboBox")) {

                } else {

                    ((JTextField) myMap.get(mapKey)).setText("");
                }

            }
        }

        refresh();

    }
    public void modifier(ActionEvent e){


        // TODO Auto-generated method stub
        for(String mapKey:myMap2.keySet()) {

            if (myMap2.get(mapKey).getClass().getName().equals("javax.swing.JComboBox"))
            {
                myMap2.get(mapKey).setToolTipText((String) ((JComboBox) myMap2.get(mapKey)).getSelectedItem());
            }
            else
            {

                myMap2.get(mapKey).setToolTipText((String) ((JTextField) myMap2.get(mapKey)).getText());
            }

        }

        for(String mapKey:myMap2.keySet()) {
            myList2.put(mapKey, myMap2.get(mapKey).getToolTipText());
            //System.out.println((mapKey));
        }

        if(this.verif(myList2)) {


            String mtdName = (String) this.variable.getClass().getName();
            switch (mtdName) {
                case "src.Client":
                    ModelClient modc = new ModelClient();
                    modc.modClient(myList2, this.getBufferId());
                    break;

                case "src.Article":
                    ModelArticle moda = new ModelArticle();
                    moda.modArticle(myList2, this.getBufferId());
                    break;

                case "src.Commande":
                    /*
                     * ModelCommande modcl= new ModelCommande(); modcl.addCommande(myList2);
                     */
                    break;

                default:
                    break;
            }
        }

        if(this.verif(myList2)) {
            for (String mapKey : myMap2.keySet()) {
                if (myMap2.get(mapKey).getClass().getName().equals("javax.swing.JComboBox")) {

                } else {

                    ((JTextField) myMap2.get(mapKey)).setText("");
                }
            }
        }
        refresh();
    }


    public void effacer(ActionEvent e){
        String mtdName = (String)this.variable.getClass().getName();
        switch (mtdName) {
            case "src.Client":
                ModelClient modc= new ModelClient();
                modc.deleteClient(this.getBufferId());
                break;

            case "src.Article":
                ModelArticle moda= new ModelArticle();
                moda.deleteArticle(this.getBufferId());
                break;

            case "src.Commande":

                 ModelCommande modcl= new ModelCommande();
                 modcl.deleteCommande((Integer) this.getBufferId());

                break;

            default:
                break;
        }

        if(!mtdName.equals("src.Commande"))
        {
            for (String mapKey : myMap2.keySet()) {
                ((JTextField) myMap2.get(mapKey)).setText("");
            }
        }
        else
        {
            JTextField textTest = (JTextField) myMap2.get("src.Commande2");
            textTest.setText("");
        }

        refresh();
    }

    public boolean verif(HashMap<String,String> myList) {

        setVerif(true);
        //verifProps =true;
        //verification des champs du formulaire avec message d'erreur
        String empty = ""; //pour vérif champs rempli
        String erreur = "";//pour stocker les champs vides et afficher dans un msgbox la variable
        //creation d'une hashmap attribuant un nom correctà mes variables à afficher en erreur et en face les données récuperées grace aux getters)

        int cpt = 0;

        //System.out.println(myList.equals(this.myList));
        if(myList.equals(this.myList)) {
            for (String mapKey : myList.keySet())// boucle sur la map pour verifier la valeur de mes champs)
            {

                if (myList.get(mapKey) == null || empty.equals(myList.get(mapKey)))//si les champs valeurs sont vides
                {

                    erreur = erreur + "Le champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))] + " est obligatoire! \n";//concatenation dans la string erreur de La phrase à afficher avec le nom 	                    System.out.println(myList);
                    setVerif(false);

                } else if (mapKey.equals("src.Client4") && !Pattern.matches("\\d{5}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))] + " doit avoir 5 chiffres! \n";
                    setVerif(false);

                }  else if (mapKey.equals("src.Client6") && !Pattern.matches("\\d{10}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))] + " doit avoir 10 chiffres! \n";
                    setVerif(false);

                }else if (mapKey.equals("src.Article3") && !Pattern.matches("\\d*", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))] + " n'est composé que de chiffres! \n";
                    setVerif(false);

                } else if (mapKey.equals("src.Article5") && !Pattern.matches("\\d*[.]\\d{2}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))] + " doit avoir un point et deux chiffres après la virgule! \n";
                    setVerif(false);

                }


                //System.out.println(getVerif()+"test");
                //du champs
            }    //si le formulaire est bien rempli alors ajout (si pas d'erreur!)
        }
        else
        {
            for (String mapKey : myList.keySet())// boucle sur la map pour verifier la valeur de mes champs)
            {

                if (myList.get(mapKey) == null || empty.equals(myList.get(mapKey)))//si les champs valeurs sont vides
                {

                    erreur = erreur + "Le champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))-1] + " est obligatoire! \n";//concatenation dans la string erreur de La phrase à afficher avec le nom 	                    System.out.println(myList);
                    setVerif(false);

                } else if (mapKey.equals("src.Client5") && !Pattern.matches("\\d{5}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))-1] + " doit avoir 5 chiffres! \n";
                    setVerif(false);

                } else if (mapKey.equals("src.Client7") && !Pattern.matches("\\d{10}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))-1] + " doit avoir 10 chiffres! \n";
                    setVerif(false);

                } else if (mapKey.equals("src.Article4") && !Pattern.matches("\\d*", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))-1] + " n'est composé que de chiffres! \n";
                    setVerif(false);

                } else if (mapKey.equals("src.Article6") && !Pattern.matches("\\d*[.]\\d{2}", myList.get(mapKey))) {
                    erreur = erreur + "Le format du champs " + titre1[Integer.parseInt(mapKey.substring(mapKey.length() - 1, mapKey.length()))-1] + " doit avoir un point et deux chiffres après la virgule! \n";
                    setVerif(false);

                }


                //System.out.println(getVerif()+"test");
                //du champs
            }    //si le formulaire est bien rempli alors ajout (si pas d'erreur!)
        }


        if (erreur.equals(empty))//si erreur est vide donc les champs sont remplis
        {

			/*Connexion con = new Connexion();//fonction connexion pour insert avec ma methode ajoutSalarie( dans la BDD)
			((Connexion) con).ajoutSalarie(civilite,nom ,prenom,ddn,nss,emploi,this.getStatut(),this.getTc(),ddc);
			JOptionPane msgInfo = new JOptionPane();
			//message info de reussite + refresh de la page
			msgInfo.showMessageDialog(null, "Le Salarié à bien été ajouté !", "Information", JOptionPane.INFORMATION_MESSAGE);
			this.getContentPane().add(panneau1());
			this.setVisible(true);*/

        }else {	//sinon message d'erreur construit grace à la hashmap mylist)
            JOptionPane msgErreur = new JOptionPane();
            msgErreur.showMessageDialog(null, erreur, "STOP", JOptionPane.ERROR_MESSAGE);

        }
        //System.out.println(getVerif()+" 2");
        return getVerif();
    }

    public void refresh()
    {
        this.remove(panelScroll);
        panelScroll = new TableAffiche(titre,this.variable,this);
        this.add(panelScroll);
    }

    public void rechercher(ActionEvent e)
    {
       String textSearch = SearchField_1.getText();
       if(panelScroll!=null){ this.remove(panelScroll);}
       else if(panelScroll2!=null){ this.remove(panelScroll2);}

        panelScroll2 = new TableAffiche2(titre,this.variable,this,textSearch);
        this.add(panelScroll2 );
        /*String mtdName = (String) this.variable.getClass().getName();
        switch (mtdName) {
            case "src.Client":
                this.remove(panelScroll);
                panelScroll2 = new TableAffiche2(titre,this.variable,this,textSearch);
                this.add(panelScroll2 );
                break;

            case "src.Article":
                this.remove(panelScroll);
                panelScroll2 = new TableAffiche2(titre,this.variable,this,textSearch);
                this.add(panelScroll2 );
                break;

            case "src.Commande":
                this.remove(panelScroll);
                panelScroll2 = new TableAffiche2(titre,this.variable,this,textSearch);
                this.add(panelScroll2 );
                break;

            default:
                break;
        }*/
    }

    public void afficherLigneCommande()
    {

        /*
        ModelLigneCmd mod=new ModelLigneCmd();
        //System.out.println(this.getBufferId().getClass());
        Object [][] DATA = mod.getLigneDeCommandesParIdCmd((Integer) this.getBufferId());
         String[] COLONNELIGNE= {"Ref. Commande","Ref. Article","Libellé","Prix","Quantité","Total par Article"};
        ZModel model3 = new ZModel(DATA,COLONNELIGNE);
        tabLigneCommande = new JScrollPane();
        tabLigneCommande.setBorder(new LineBorder(BR,2,true));
        tabLigneCommande.setBounds(10, 380, 1105, 140);
        JTable MainTableLigneCommande = new JTable(model3);
        MainTableLigneCommande.setBorder(null);
        MainTableLigneCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tabLigneCommande.setViewportView(MainTableLigneCommande);
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
                        l5.setText(tab);
                        System.out.println(l5.getText());
                        SecondaryPanelCommande.repaint();
                    }

                }
            }
        });
        this.add(tabLigneCommande);
        SecondaryPanelCommande = new JPanel();
        SecondaryPanelCommande.setBorder(new LineBorder(BR, 2, true));
        SecondaryPanelCommande.setBounds(10, 535, 1105, 70);
        SecondaryPanelCommande.setBackground(BGM);
        this.add(SecondaryPanelCommande);
        SecondaryPanelCommande.setLayout(null);
        TertiaryPanelCommande = new JPanel();
        TertiaryPanelCommande.setBorder(new LineBorder(BR, 2, true));
        TertiaryPanelCommande.setBounds(10, 620, 1105, 70);
        TertiaryPanelCommande.setBackground(BGM);
        this.add(TertiaryPanelCommande);
        TertiaryPanelCommande.setLayout(null);



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
                tQuantite.setText(tQuantite.getText()+e.getKeyChar());
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

                refreshLigneCommande();
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
                tQuantite2.setText(tQuantite2.getText()+e.getKeyChar());
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
                System.out.println(idArticle);
                int idArticle2 = Integer.parseInt(idArticle);
                int idCommande = (int) bufferId;
                int Quantite = Integer.parseInt(tQuantite2.getText());

                ModelLigneCmd modl = new ModelLigneCmd();
                modl.modLigneDeCommande(idCommande,idArticle2,Quantite);

                refreshLigneCommande();
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
                idArticle = idArticle.substring(0,1);
                System.out.println(idArticle);
                int idArticle2 = Integer.parseInt(idArticle);
                int idCommande = (int) bufferId;


                ModelLigneCmd modl = new ModelLigneCmd();
                modl.deleteLigneDeCommande(idCommande,idArticle2);

                refreshLigneCommande();
            }
        });

        parent.repaint();

        */
    }

    public void refreshLigneCommande()
    {
        this.remove(tabLigneCommande);
        ModelLigneCmd mod=new ModelLigneCmd();
        //System.out.println(this.getBufferId().getClass());
        Object [][] DATA = mod.getLigneDeCommandesParIdCmd((Integer) this.getBufferId());
        String[] COLONNELIGNE= {"Ref. Commande","Ref. Article","Libellé","Prix","Quantité","Total par Article"};
        ZModel model3 = new ZModel(DATA,COLONNELIGNE);
        tabLigneCommande = new JScrollPane();
        tabLigneCommande.setBorder(new LineBorder(BR,2,true));
        tabLigneCommande.setBounds(10, 380, 1105, 140);
        JTable MainTableLigneCommande = new JTable(model3);
        MainTableLigneCommande.setBorder(null);
        MainTableLigneCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tabLigneCommande.setViewportView(MainTableLigneCommande);
        this.add(tabLigneCommande);
    }

    public Object getBufferId() {
        return bufferId;
    }
    public void setBufferId(Object bufferId) {
        this.bufferId = bufferId;
    }

    public boolean getVerif()
    {
        return verifProps;
    }

    public void setVerif(boolean verif) {
        this.verifProps = verif;
    }

    public PanelLigneCommande getPanExt()
    {
        return this.panExt;
    }

    public void setPanExt(PanelLigneCommande panExtImport)
    {
        this.panExt = panExtImport;
    }
}
