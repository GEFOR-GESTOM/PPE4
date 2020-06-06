package src;


import java.util.*;


public class Categorie {

    private int idCategorie;

    private String libelleCat;


    public java.util.Collection<Article> article;



    public java.util.Collection<Article> getArticle() {
        if (article == null)
            article = new java.util.HashSet<Article>();
        return article;
    }


    public java.util.Iterator getIteratorArticle() {
        if (article == null)
            article = new java.util.HashSet<Article>();
        return article.iterator();
    }


    public void setArticle(java.util.Collection<Article> newArticle) {
        removeAllArticle();
        for (java.util.Iterator iter = newArticle.iterator(); iter.hasNext();)
            addArticle((Article)iter.next());
    }


    public void addArticle(Article newArticle) {
        if (newArticle == null)
            return;
        if (this.article == null)
            this.article = new java.util.HashSet<Article>();
        if (!this.article.contains(newArticle))
        {
            this.article.add(newArticle);
            newArticle.setAppartient(this);
        }
    }


    public void removeArticle(Article oldArticle) {
        if (oldArticle == null)
            return;
        if (this.article != null)
            if (this.article.contains(oldArticle))
            {
                this.article.remove(oldArticle);
                oldArticle.setAppartient((Categorie)null);
            }
    }


    public void removeAllArticle() {
        if (article != null)
        {
            Article oldArticle;
            for (java.util.Iterator iter = getIteratorArticle(); iter.hasNext();)
            {
                oldArticle = (Article)iter.next();
                iter.remove();
                oldArticle.setAppartient((Categorie)null);
            }
        }
    }


    public int getIdCategorie() {
        return idCategorie;
    }


    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }


    public String getLibelleCat() {
        return libelleCat;
    }


    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

}