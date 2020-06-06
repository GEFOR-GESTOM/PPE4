package src;

import java.util.*;

import com.mysql.jdbc.Extension;


public class Commande {

    private int idCommande;

    private String DateCmd;

    public java.util.Collection ligneDeCommande;

    public Client client;
    public String client2;



    public Client getClient() {
        return client;
    }


    public void setClient(Client newClient) {
        if (this.client == null || !this.client.equals(newClient))
        {
            if (this.client != null)
            {
                Client oldClient = this.client;
                this.client = null;
                oldClient.removeCommande(this);
            }
            if (newClient != null)
            {
                this.client = newClient;
                this.client.addCommande(this);
            }
        }
    }

    public String getClient2() {
        return client2;
    }


    public void setClient2() {
        this.client2 = this.client.getNom();
    }

    public int getIdCommande() {
        return idCommande;
    }


    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }







    public String getDateCmd() {
        return DateCmd;
    }


    public void setDateCmd(String dateCmd) {
        DateCmd = dateCmd;
    }


    public java.util.Collection getLigneDeCommande() {
        return ligneDeCommande;
    }


    public void setLigneDeCommande(java.util.Collection ligneDeCommande) {
        this.ligneDeCommande = ligneDeCommande;
    }

}