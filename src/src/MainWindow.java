package src;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

    public JFrame mainFrame;
    public JTable MainTableClient;
    public JTable MainTableArticle;
    public JTable MainTableCommande;
    public JTextField SearchField_1;
    public JTextField SearchField_2;
    public JTextField SearchField_3;
    private PanelAffichage Client;
    private TableAffiche Client2;
    /**
     * Initialize the contents of the table.
     * and constants colors
     */
    public static final Color BGM = new Color(223,231,236);
    public static final Color BR = new Color(83,129,142);
    public static final Color BGS = new Color(117,149,179);
    public static final Color BLK = new Color(0,0,0);
    public Object[][] DATACLIENT;
    public String[] COLONNECLIENT= {"Ref. Client","Nom","Prenom","Raison Sociale","Adresse","Code Postal","Ville","Téléphone"};
    public Object[][] DATACOMMANDE;
    public String[] COLONNECOMMANDE= {"Ref. Commande ","Client","Date de Commande"};
    public Object[][] DATAARTICLE;
    public String[] COLONNEARTICLE= {"Ref. Article","Ref. Catégories","Ref. Art. Fournisseur","Description","Stock","Libellé","Prix"};
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
    }



    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {

        mainFrame = new JFrame();
        mainFrame.getContentPane().setBackground(new Color(192,192,192));
        mainFrame.setBounds(100, 100, 1152, 864);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(null);

        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(BGM);
        MainPanel.setBounds(0, 0, 1152, 864);
        mainFrame.getContentPane().add(MainPanel);
        MainPanel.setLayout(null);
        JPanel PanelCache = new JPanel();
        PanelCache.setBounds(2, 98, 96, 4);
        PanelCache.setBackground(BGM);
        // ==================== Panel Commande =======================
        JPanel PanelCommande = new JPanel();
        JLabel LabelCommandePicto = new JLabel(new ImageIcon("Resources/Commandes0.png"));
        JLabel LabelCommandePicto2 = new JLabel(new ImageIcon("Resources/Commandes1.png"));
        JLabel LabelCommandeText = new JLabel("Commande");
        JLabel LabelCommandeText2 = new JLabel("Commande");
        PanelCommande.setLayout(null);
        PanelCommande.setBackground(BGS);
        PanelCommande.setBorder(new LineBorder(BR, 2, true));
        PanelCommande.setBounds(10, 22, 100, 100);
        LabelCommandePicto.setBackground(BGS);
        LabelCommandePicto.setBounds(0, 20, 100, 80);
        LabelCommandePicto2.setBackground(BGM);
        LabelCommandePicto2.setBounds(0, 20, 100, 80);
        LabelCommandeText.setForeground(BLK);
        LabelCommandeText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCommandeText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelCommandeText.setBackground(BGS);
        LabelCommandeText.setBounds(0, 0, 100, 30);
        LabelCommandeText2.setForeground(BGS);
        LabelCommandeText2.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCommandeText2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelCommandeText2.setBackground(BGM);
        LabelCommandeText2.setBounds(0, 0, 100, 30);
        PanelCommande.add(LabelCommandePicto);
        PanelCommande.add(LabelCommandeText);
        MainPanel.add(PanelCommande);
        // =========================================================
        // ====================== Panel Client ==================
        //Panel Client Déclaration
        JPanel PanelClient = new JPanel();
        JLabel LabelClientPicto = new JLabel(new ImageIcon("Resources/Client0.png"));
        JLabel LabelClientPicto2 = new JLabel(new ImageIcon("Resources/Client1.png"));
        JLabel LabelClientText = new JLabel("Client");
        JLabel LabelClientText2 = new JLabel("Client");
        // Panel Client définition
        PanelClient.setLayout(null);
        PanelClient.setBackground(BGS);
        PanelClient.setBorder(new LineBorder(BR, 2, true));
        PanelClient.setBounds(120, 22, 100, 100);
        LabelClientPicto.setBackground(BGS);
        LabelClientPicto.setBounds(0, 20, 100, 80);
        LabelClientPicto2.setBackground(BGM);
        LabelClientPicto2.setBounds(0, 20, 100, 80);
        LabelClientText.setForeground(BLK);
        LabelClientText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelClientText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelClientText.setBackground(BGS);
        LabelClientText.setBounds(0, 0, 100, 30);
        LabelClientText2.setForeground(BGS);
        LabelClientText2.setHorizontalAlignment(SwingConstants.CENTER);
        LabelClientText2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelClientText2.setBackground(BGM);
        LabelClientText2.setBounds(0, 0, 100, 30);
        // Panel Client Add
        PanelClient.add(LabelClientPicto);
        PanelClient.add(LabelClientText);
        MainPanel.add(PanelClient);
        // =========================================================
        // ====================== Panel Article ==================
        //Panel Article Déclaration
        JPanel PanelArticle = new JPanel();
        JLabel LabelArticlePicto = new JLabel(new ImageIcon("Resources/Article0.png"));
        JLabel LabelArticlePicto2 = new JLabel(new ImageIcon("Resources/Article1.png"));
        JLabel LabelArticleText = new JLabel("Article");
        JLabel LabelArticleText2 = new JLabel("Article");
        // Panel Article définition
        PanelArticle.setLayout(null);
        PanelArticle.setBackground(BGS);
        PanelArticle.setBorder(new LineBorder(BR, 2, true));
        PanelArticle.setBounds(230, 22, 100, 100);
        LabelArticlePicto.setBackground(BGS);
        LabelArticlePicto.setBounds(0, 20, 100, 80);
        LabelArticlePicto2.setBackground(BGM);
        LabelArticlePicto2.setBounds(0, 20, 100, 80);
        LabelArticleText.setForeground(BLK);
        LabelArticleText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelArticleText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelArticleText.setBackground(BGS);
        LabelArticleText.setBounds(0, 0, 100, 30);
        LabelArticleText2.setForeground(BGS);
        LabelArticleText2.setHorizontalAlignment(SwingConstants.CENTER);
        LabelArticleText2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelArticleText2.setBackground(BGM);
        LabelArticleText2.setBounds(0, 0, 100, 30);
        // Panel Article Add
        PanelArticle.add(LabelArticlePicto);
        PanelArticle.add(LabelArticleText);
        MainPanel.add(PanelArticle);
        // =========================================================
        // Panels Accesoires Déclaration
        JPanel PanelPrint = new JPanel();
        JLabel LabelPrintPicto = new JLabel(new ImageIcon("Resources/Printer0.png"));
        JLabel LabelPrintText = new JLabel("Imprimer");
        JPanel PanelOption = new JPanel();
        JLabel LabelOptionPicto = new JLabel(new ImageIcon("Resources/073-settings1.png"));
        JLabel LabelOptionText = new JLabel("Stats&Graphs");
        JPanel PanelQuit = new JPanel();
        JLabel LabelQuitPicto = new JLabel(new ImageIcon("Resources/069-log-in1.png"));
        JLabel LabelQuitText = new JLabel("Deconexion");
        // Panel Accessoires Définition
        PanelPrint.setLayout(null);
        LabelPrintText.setForeground(BGS);
        LabelPrintText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelPrintText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelPrintText.setBounds(0, 0, 100, 30);
        PanelPrint.setBounds(532, 10, 100, 100);
        PanelPrint.setBorder(new LineBorder(BR, 5, true));
        LabelPrintPicto.setBounds(0, 20, 100, 80);
        PanelOption.setLayout(null);
        LabelOptionText.setForeground(BGS);
        LabelOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelOptionText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelOptionText.setBounds(0, 0, 100, 30);
        PanelOption.setBorder(new LineBorder(BR, 5, true));
        PanelOption.setBounds(768, 10, 100, 100);
        LabelOptionPicto.setBounds(0, 20, 100, 80);
        PanelQuit.setLayout(null);
        LabelQuitText.setForeground(BGS);
        LabelQuitText.setHorizontalAlignment(SwingConstants.CENTER);
        LabelQuitText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelQuitText.setBounds(0, 0, 100, 30);
        PanelQuit.setBounds(878, 10, 100, 100);
        PanelQuit.setBorder(new LineBorder(BR, 5, true));
        LabelQuitPicto.setBounds(0, 20, 100, 80);
        //Add Panel Accessoires
        PanelPrint.add(LabelPrintPicto);
        PanelPrint.add(LabelPrintText);
        PanelOption.add(LabelOptionPicto);
        PanelOption.add(LabelOptionText);
        PanelQuit.add(LabelQuitPicto);
        PanelQuit.add(LabelQuitText);
        MainPanel.add(PanelPrint);
        MainPanel.add(PanelQuit);
        MainPanel.add(PanelOption);
// =================================================================
        //---------------AFFICHAGE-------------------------
        JPanel PanelMain = new JPanel();
        PanelMain.setBounds(10, 120, 1125, 705);
        MainPanel.add(PanelMain);
        PanelMain.setLayout(null);


        //panel affichage client
        //PanelAffichage Client = new PanelAffichage(COLONNECLIENT,new Client());

        //panel affichage articles
        PanelAffichage Article = new PanelAffichage(COLONNEARTICLE,new Article(),PanelMain);

        //panel affichage commande

        PanelAffichage Commande = new PanelAffichage(COLONNECOMMANDE, new Commande(),PanelMain);
        //panel Affichage Client
		/*JScrollPane MainScrollPaneClient = new JScrollPane();
		MainScrollPaneClient.setBorder(new LineBorder(BR,2,true));
		MainScrollPaneClient.setBounds(145, 56, 813, 290);
		Client.add(MainScrollPaneClient);


		ModelClient mod=new ModelClient();
		DATACLIENT = mod.findAll();
		ZModel model3 = new ZModel(DATACLIENT,COLONNECLIENT);
		MainTableClient = new JTable(model3);
		MainTableClient.setBorder(null);
		MainTableClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MainScrollPaneClient.setViewportView(MainTableClient);
		MainTableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel3 = MainTableClient.getSelectionModel();
		selectionModel3.addListSelectionListener(new ListSelectionListener() {
				@Override

			  public void valueChanged(ListSelectionEvent event) {
				if(MainTableClient.getSelectedRow() > -1) {
					if(event.getValueIsAdjusting()) {

					}else
					{
						Client.textJ(model3.getValuesAt(MainTableClient.getSelectedRow()));					}
						Client.setBufferId(model3.getValueAt(MainTableClient.getSelectedRow(),0));

				}
			  }
			});
		*/

        Client = new PanelAffichage(COLONNECLIENT,new Client(),PanelMain);


        //pannel affichage Commande
       /* JScrollPane MainScrollPaneCommande = new JScrollPane();
        MainScrollPaneCommande.setBorder(new LineBorder(BR,2,true));
        MainScrollPaneCommande.setBounds(145, 56, 813, 290);
        Commande.add(MainScrollPaneCommande);
        ModelCommande modc=new ModelCommande();
        DATACOMMANDE = modc.findAll();
        ZModel model2 = new ZModel(DATAARTICLE,COLONNEARTICLE);
        MainTableCommande = new JTable(model2);
        MainTableCommande.setBorder(null);
        MainTableCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
        MainScrollPaneCommande.setViewportView(MainTableCommande);
        MainTableCommande.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel2 = MainTableCommande.getSelectionModel();
        selectionModel2.addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent event) {
                if(MainTableCommande.getSelectedRow() > -1) {
                    if(event.getValueIsAdjusting()) {

                    }else
                    {
                        System.out.println(model2.getValuesAt(MainTableCommande.getSelectedRow())[2]);
                    }

                }
            }
        });

        //panel affichage Article
        JScrollPane MainScrollPaneArticle = new JScrollPane();
        MainScrollPaneArticle.setBorder(new LineBorder(BR,2,true));
        MainScrollPaneArticle.setBounds(145, 56, 813, 290);
        Article.add(MainScrollPaneArticle);
        ModelArticle moda=new ModelArticle();
        DATAARTICLE = moda.findAll();
        ZModel model1 = new ZModel(DATAARTICLE,COLONNEARTICLE);
        MainTableArticle = new JTable(model1);
        MainTableArticle.setBorder(null);
        MainTableArticle.setFont(new Font("Tahoma", Font.PLAIN, 14));
        MainScrollPaneArticle.setViewportView(MainTableArticle);
        MainTableArticle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = MainTableArticle.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent event) {
                if(MainTableArticle.getSelectedRow() > -1) {
                    if(event.getValueIsAdjusting()) {

                    }else
                    {

                        Article.textJ(model1.getValuesAt(MainTableArticle.getSelectedRow()));
                        Article.setBufferId(model1.getValueAt(MainTableArticle.getSelectedRow(),0));
                    }

                }
            }
        });*/


        JPanel PanelMainAcceuil = new JPanel();
        PanelMainAcceuil.setBackground(BGM);
        PanelMainAcceuil.setBorder(new LineBorder(BR, 2, true));
        PanelMainAcceuil.setBounds(0, 0, 1125, 705);
        PanelMainAcceuil.setLayout(null);
        JLabel LabelMainAcceuilPicto = new JLabel(new ImageIcon("Resources/Shopping05.jpg"));
        LabelMainAcceuilPicto.setBounds(0, 0, 1125, 705);
        PanelMainAcceuil.add(LabelMainAcceuilPicto);
        PanelMain.add(PanelMainAcceuil);
// =============================================================================================================
// PANEL PRINCIPAUX LISTENERS
        PanelClient.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        /* Allume button Client
                         * Eteint Commande
                         * Eteint Article
                         * Désaffiche Article/Commande
                         * Affiche Client
                         */
                        PanelArticle.setBackground(BGS);
                        PanelClient.setBackground(BGM);
                        PanelCommande.setBackground(BGS);
                        PanelCommande.removeAll();
                        PanelClient.removeAll();
                        PanelArticle.removeAll();
                        PanelMain.removeAll();
                        PanelMain.add(Client);
                        PanelClient.add(PanelCache);
                        PanelCommande.add(LabelCommandePicto);
                        PanelCommande.add(LabelCommandeText);
                        PanelClient.add(LabelClientPicto2);
                        PanelClient.add(LabelClientText2);
                        PanelArticle.add(LabelArticleText);
                        PanelArticle.add(LabelArticlePicto);
                        PanelCommande.repaint();
                        PanelArticle.repaint();//Refresh
                        PanelClient.repaint();
                        PanelMain.repaint();

                        /*
                         * Afficher PannelMainAffichage
                         * Cacher MainAcceuil
                         */
                    }
                }
        );
        PanelArticle.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        /* Allume button Article
                         * Eteint CLient
                         * Eteint Commande
                         * Désafiche Commande/Client
                         * Affiche Article
                         * Désaficher actuel
                         */
                        PanelArticle.setBackground(BGM);
                        PanelClient.setBackground(BGS);
                        PanelCommande.setBackground(BGS);
                        PanelCommande.removeAll();
                        PanelClient.removeAll();
                        PanelArticle.removeAll();
                        PanelMain.removeAll();
                        PanelMain.add(Article);
                        PanelArticle.add(PanelCache);
                        PanelCommande.add(LabelCommandePicto);
                        PanelCommande.add(LabelCommandeText);
                        PanelClient.add(LabelClientPicto);
                        PanelClient.add(LabelClientText);
                        PanelArticle.add(LabelArticleText2);
                        PanelArticle.add(LabelArticlePicto2);
                        PanelCommande.repaint();
                        PanelArticle.repaint();//Refresh
                        PanelClient.repaint();
                        PanelMain.repaint();
                    }
                }
        );
        PanelCommande.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        /* Allume button Commamde
                         * Eteint CLient
                         * Eteint Article
                         * Désafiche Article/Client
                         * Affiche Commande
                         */
                        PanelArticle.setBackground(BGS);
                        PanelClient.setBackground(BGS);
                        PanelCommande.setBackground(BGM);
                        PanelCommande.removeAll();
                        PanelClient.removeAll();
                        PanelArticle.removeAll();
                        PanelMain.removeAll();
                        PanelMain.add(Commande);
                        PanelCommande.add(PanelCache);
                        PanelCommande.add(LabelCommandePicto2);
                        PanelCommande.add(LabelCommandeText2);
                        PanelClient.add(LabelClientPicto);
                        PanelClient.add(LabelClientText);
                        PanelArticle.add(LabelArticleText);
                        PanelArticle.add(LabelArticlePicto);
                        PanelCommande.repaint();
                        PanelArticle.repaint();//Refresh
                        PanelClient.repaint();
                        PanelMain.repaint();



                    }
                }
        );
        PanelOption.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        System.out.println("hello eve");

                        Stats test = new Stats();

                    }
                }
        );

    }
}
