

package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ModelLigneCmd {

    public Object[][] getLigneDeCommandesParIdCmd(int id) {
        Collection<LigneDeCommande> LigneDeCommandes= new ArrayList<LigneDeCommande>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from ligne_de_commande "
                    + "where ID_COMMANDE=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LigneDeCommande lcmd = new LigneDeCommande();

                ModelCommande modelcmd= new ModelCommande();
                ModelArticle modelArt= new ModelArticle();
                lcmd.setCommande(modelcmd.getCommandesParIdCommande(rs.getInt("ID_COMMANDE")));
                lcmd.setArticle(modelArt.getArticlesParId(rs.getInt("ID_ARTICLE")));
                lcmd.setQuantite(rs.getInt("QUANTITE"));
                lcmd.setPrixUnitDate(rs.getDouble("PRIXUNITDATE"));
                LigneDeCommandes.add(lcmd);
            }
            Object[][] objLigneCommande = new Object[LigneDeCommandes.size()][6];
            int cpt =0;
            for(LigneDeCommande cl: LigneDeCommandes) {

                objLigneCommande[cpt][0]=cl.getCommande().getIdCommande();
                objLigneCommande[cpt][1]=cl.getArticle().getIdArticle();
                objLigneCommande[cpt][2]=cl.getArticle().getLibelle();
                objLigneCommande[cpt][3]=cl.getArticle().getPrix();
                objLigneCommande[cpt][4]=cl.getQuantite();
                objLigneCommande[cpt][5]=(cl.getQuantite()*cl.getArticle().getPrix());

                cpt++;

            }
            return objLigneCommande;




        } catch (SQLException e) {

            e.printStackTrace();
        }

        Object[][] obj= new Object[0][0];
        return obj;
    }






    public List<LigneDeCommande> findAll() {
        List<LigneDeCommande> LigneDeCommandes= new ArrayList<LigneDeCommande>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from LigneDeCommande ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LigneDeCommande lcmd = new LigneDeCommande();

                ModelCommande modelcmd= new ModelCommande();
                ModelArticle modelArt= new ModelArticle();
                lcmd.setCommande(modelcmd.getCommandesParIdCommande(rs.getInt("ID_COMMANDE")));
                lcmd.setArticle(modelArt.getArticlesParId(rs.getInt("ID_ARTICLE")));
                lcmd.setQuantite(rs.getInt("QUANTITE"));
                lcmd.setPrixUnitDate(rs.getDouble("PRIXUNITDATE"));
                LigneDeCommandes.add(lcmd);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return LigneDeCommandes;
    }



    /*@Override*/
    public void addLigneDeCommande(int idCommande,int idArticle, int Quantite) {
        //System.out.println(idCommande);
        //System.out.println(idArticle);
        Connection conn=BdConnection.getConnection();
        ModelArticle moda = new ModelArticle();
        Article thisArticle = moda.getArticlesParId(idArticle);
        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO ligne_de_commande(ID_COMMANDE,ID_ARTICLE,QUANTITE,PRIXUNITDATE)"
                    + " VALUES(?,?,?,?)");
            ps.setInt(1, idCommande);
            ps.setInt(2, idArticle);
            ps.setInt(3, Quantite);
            ps.setDouble(4, thisArticle.getPrix());


            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void modLigneDeCommande(int idCommande,int idArticle, int Quantite) {
        //System.out.println("hello");
        Connection conn=BdConnection.getConnection();
        ModelArticle moda = new ModelArticle();
        Article thisArticle = moda.getArticlesParId(idArticle);

        try {
            PreparedStatement ps= conn.prepareStatement("UPDATE ligne_de_commande SET QUANTITE=? WHERE ID_COMMANDE=? AND ID_ARTICLE=?");
            ps.setInt(1, Quantite);
            ps.setInt(2, idCommande);
            ps.setInt(3, idArticle);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void deleteLigneDeCommande(int idCmd , int idArt ) {

        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("DELETE from ligne_de_commande WHERE ID_Commande=? "
                    + "AND ID_ARTICLE=?");
            ps.setInt(1, idCmd);
            ps.setInt(2, idArt);
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public void deleteLigneDeCommande(LigneDeCommande lcmd) {

        deleteLigneDeCommande(lcmd.getCommande().getIdCommande(), lcmd.getArticle().getIdArticle());

    }



}
