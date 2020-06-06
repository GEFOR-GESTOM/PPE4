package src;

import java.lang.reflect.Field;

public class Article {

    private int idArticle;

    public Categorie appartient;

    private String reference;

    private String description;

    private int stock;

    private String libelle;

    private double prix;

    public java.util.Collection ligneDeCommande;

    public int getIdArticle() {
        return idArticle;
    }


    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }


    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    public String getLibelle() {
        return libelle;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public double getPrix() {
        return prix;
    }


    public void setPrix(double prix) {
        this.prix = prix;
    }


    @SuppressWarnings("rawtypes")
    public java.util.Collection getLigneDeCommande() {
        return ligneDeCommande;
    }


    public void setLigneDeCommande(java.util.Collection ligneDeCommande) {
        this.ligneDeCommande = ligneDeCommande;
    }






    public Categorie getAppartient() {
        return appartient;
    }

    public String getLibelleCatArt() {

        return appartient.getLibelleCat();
    }



    public void setAppartient(Categorie newCategorie) {
        if (this.appartient == null || !this.appartient.equals(newCategorie))
        {
            if (this.appartient != null)
            {
                Categorie oldCategorie = this.appartient;
                this.appartient = null;
                oldCategorie.removeArticle(this);
            }
            if (newCategorie != null)
            {
                this.appartient = newCategorie;
                this.appartient.addArticle(this);
            }
        }
    }
    public String[] viewCarac() {
        String [] str = new String[this.getClass().getDeclaredFields().length];
        int cpt=0;
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);//Obligatoire si le field est private
            str[cpt]=field.getName();
            cpt++;
        }	return str;
    }

}
