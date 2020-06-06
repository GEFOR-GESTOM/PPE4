package src;

import java.util.*;


public class Client {

    private int idClient;

    private String nom;

    private String prenom;

    private String raisonSociale;

    private String adresse;

    private String codePostal;

    public int getIdClient() {
        return idClient;
    }


    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getRaisonSociale() {
        return raisonSociale;
    }


    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getCodePostal() {
        return codePostal;
    }


    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }


    public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }


    public String getTel() {
        return tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    private String ville;

    private String tel;


    public java.util.Collection<Commande> commande;



    public java.util.Collection<Commande> getCommande() {
        if (commande == null)
            commande = new java.util.HashSet<Commande>();
        return commande;
    }


    public java.util.Iterator getIteratorCommande() {
        if (commande == null)
            commande = new java.util.HashSet<Commande>();
        return commande.iterator();
    }


    public void setCommande(java.util.Collection<Commande> newCommande) {
        removeAllCommande();
        for (java.util.Iterator iter = newCommande.iterator(); iter.hasNext();)
            addCommande((Commande)iter.next());
    }


    public void addCommande(Commande newCommande) {
        if (newCommande == null)
            return;
        if (this.commande == null)
            this.commande = new java.util.HashSet<Commande>();
        if (!this.commande.contains(newCommande))
        {
            this.commande.add(newCommande);
            newCommande.setClient(this);
        }
    }


    public void removeCommande(Commande oldCommande) {
        if (oldCommande == null)
            return;
        if (this.commande != null)
            if (this.commande.contains(oldCommande))
            {
                this.commande.remove(oldCommande);
                oldCommande.setClient((Client)null);
            }
    }


    public void removeAllCommande() {
        if (commande != null)
        {
            Commande oldCommande;
            for (java.util.Iterator iter = getIteratorCommande(); iter.hasNext();)
            {
                oldCommande = (Commande)iter.next();
                iter.remove();
                oldCommande.setClient((Client)null);
            }
        }
    }

}