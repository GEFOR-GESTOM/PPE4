package src;

import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.print.*;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Stats extends JFrame  {
    public static final Color BGM = new Color(223,231,236);
    public static final Color BR = new Color(83,129,142);
    public static final Color BGS = new Color(117,149,179);
    public static final Color BLK = new Color(0,0,0);
    public JTable MainTableClient;
    public Object[][] DATA;
    public String[] COLONNE= {"Libellé Catégorie","Stock Total"};
    private ZModel model3;
    public JScrollPane jspStat;
    private JPanel MainPanel,statPanel;
    private ChartPanel cPanel;

    public Stats() {
        //panneau principal
        this.getContentPane().setBackground(new Color(192,192,192));
        this.setBounds(100, 100, 1152, 864);
        this.getContentPane().setLayout(null);


        MainPanel = new JPanel();
        MainPanel.setBackground(BGM);
        MainPanel.setBounds(0, 0, 1152, 864);
        MainPanel.setLayout(null);

        ModelArticle mod=new ModelArticle();
        DATA = mod.stat();
        model3 = new ZModel(DATA,COLONNE);
        MainTableClient = new JTable(model3);
        MainTableClient.setBorder(null);
        MainTableClient.setFont(new Font("Tahoma", Font.PLAIN, 14));

        jspStat=new JScrollPane();
        jspStat.setBorder(new LineBorder(BR,2,true));
        jspStat.setBounds(0, 0, 1132, 624);
        jspStat.setViewportView(MainTableClient);

        System.out.println(DATA.length);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0;i < DATA.length; i++)
        {
            String key = (String) DATA[i][0];
            Integer value = (Integer) DATA[i][1];
            Double value2 = value.doubleValue();
            dataset.addValue(value2, "Produit 1", key);
        }




        /*JFreeChart barChart = ChartFactory.createBarChart("Evolution des ventes", "",
                "Unité vendue", dataset, PlotOrientation.VERTICAL, false, true, false);
        cPanel = new ChartPanel(barChart);
        cPanel.setBounds(10, 0, 1132, 720);*/

        statPanel = new JPanel();
        statPanel.setBackground(BGM);
        statPanel.setBounds(10, 100, 1132, 720);
        statPanel.setLayout(null);
        statPanel.add(jspStat);
        MainPanel.add(statPanel);

        //MainPanel.add(statPanel);
        this.add(MainPanel);
        this.setVisible(true);
        //panneau bouton

        JPanel boutonPanel = new JPanel();
        boutonPanel.setBackground(BGM);
        boutonPanel.setBounds(0, 0, 1152, 100);
        MainPanel.add(boutonPanel);
        boutonPanel.setLayout(null);
        JButton stat = new JButton("Stats");
        stat.setBounds(317, 37, 100, 25);
        stat.addActionListener(this::actionPerformed);
        boutonPanel.add(stat);
        JButton graph = new JButton("Graph");
        graph.setBounds(734, 37, 100, 25);
        boutonPanel.add(graph);
        //panneau stat


        //MainPanel.add(statPanel);

    }

   private void actionPerformed(ActionEvent actionEvent) {
       printComponenet(jspStat);
    }

 /*
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }


        Paper paper = new Paper();
        paper.setSize( 1132, 720);
        paper.setImageableArea(0, 0, 2400, 3600);

        // Disposition de la feuille

        pf.setOrientation(PageFormat.PORTRAIT );
        pf.setPaper(paper);
        Graphics2D g2d = (Graphics2D) g;


        AffineTransform originalTransform = g2d.getTransform();
        System.out.println(this.getWidth());
        System.out.println(pf.getImageableWidth());
        double scaleX = pf.getImageableWidth() / (this.getWidth()*2);
        double scaleY = pf.getImageableHeight() / (this.getHeight()*2);
// Maintain aspect ratio
        double scale = Math.min(scaleX, scaleY);
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.scale(scale, scale);

        statPanel.printAll(g2d);
        g2d.setTransform(originalTransform);

        return PAGE_EXISTS;
    }*/

    public void printComponenet(Component component){
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable (new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum){
                if (pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                pf.setOrientation(PageFormat.LANDSCAPE);
                g2.scale(0.39,0.39);
                component.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false)
            return;

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }
}