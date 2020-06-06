package src;



import java.util.*;


public class LigneDeCommande {

    private int quantite;

    private double prixUnitDate;

    public Commande commande;
    public Article article;


    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double getPrixUnitDate() {
        return prixUnitDate;
    }
    public void setPrixUnitDate(double prixUnitDate) {
        this.prixUnitDate = prixUnitDate;
    }
    public Commande getCommande() {
        return commande;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

}