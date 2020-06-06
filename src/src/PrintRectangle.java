package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintRectangle implements Printable {

    /** Constructeur par défaut de PrintRectangle */
    public PrintRectangle() {
    }


    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // Par défaut, retourne NO_SUCH_PAGE => la page n'existe pas
        int retValue = Printable.NO_SUCH_PAGE;
        switch(pageIndex){
            case 0 : {
                // Dessin de la première page
                // Récupère la dimension de la zone imprimable
                double xLeft  = pageFormat.getImageableX();
                double yTop   = pageFormat.getImageableY();
                double width  = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();

                /*BufferedImage tamponSauvegarde = new BufferedImage(
                        fenetre.getPreferredSize().width,
                        fenetre.getPreferredSize().height,
                        BufferedImage.TYPE_3BYTE_BGR
                );
                Graphics g = tamponSauvegarde.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, fenetre.getSize().width, fenetre.getSize().height);
                fenetre.paint(g);
                // Dessine le rectangle
                graphics.setColor(Color.BLACK);
                graphics.drawRect((int)xLeft,
                        (int)yTop,
                        (int)width,
                        (int)height);
                // La page est valide
                retValue = Printable.PAGE_EXISTS;
                break;*/
            }
            case 1 : {
                // Dessin de la seconde page
                // Récupère la dimension de la zone imprimable
                double xLeft  = pageFormat.getImageableX();
                double yTop   = pageFormat.getImageableY();
                double width  = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();

                // Dessine l'ellipse
                graphics.setColor(Color.BLACK);
                graphics.drawOval((int)xLeft,
                        (int)yTop,
                        (int)width,
                        (int)height);
                // La page est valide
                retValue = Printable.PAGE_EXISTS;
                break;
            }
        }
        return retValue;
    }

}