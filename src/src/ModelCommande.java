package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ModelCommande {

    public Object[][] getCommandesParMotCle(String mc) {
        Collection<Commande> Commandes= new ArrayList<Commande>();
        Connection conn=BdConnection.getConnection();
        mc=mc.toUpperCase();
        try {
            PreparedStatement ps= conn.prepareStatement("select * from COMMANDE,CLIENT where COMMANDE.ID_CLIENT=CLIENT.ID_CLIENT and NOM LIKE ?");
            ps.setString(1, "%"+mc+"%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commande cmd = new Commande();

                ModelClient model= new ModelClient();
                cmd.setIdCommande(rs.getInt("ID_COMMANDE"));
                cmd.setClient(model.getClientsParId(rs.getInt("ID_CLIENT")));
                cmd.setClient2();
                cmd.setDateCmd(rs.getString("DATE"));
                Commandes.add(cmd);
            }
            Object[][] objCommande = new Object[Commandes.size()][3];
            int cpt =0;
            for(Commande cl: Commandes) {

                objCommande[cpt][0]=cl.getIdCommande();
                objCommande[cpt][1]=cl.getClient2();
                objCommande[cpt][2]=cl.getDateCmd();

                cpt++;

            }
            return objCommande;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;
    }

    public Collection<Commande> getCommandesParIdClient(int id) {
        Collection<Commande> Commandes= new ArrayList<Commande>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from COMMANDE "
                    + "where ID_CLIENT=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commande cmd = new Commande();

                ModelClient model= new ModelClient();
                cmd.setIdCommande(rs.getInt("ID_COMMANDE"));
                cmd.setClient(model.getClientsParId(rs.getInt("ID_CLIENT")));
                cmd.setDateCmd(rs.getString("DATE"));
                Commandes.add(cmd);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return Commandes;
    }

    public Commande getCommandesParIdCommande(int id) {

        Connection conn=BdConnection.getConnection();
        Commande cmd = new Commande();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from COMMANDE "
                    + "where ID_COMMANDE=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {


                ModelClient model= new ModelClient();
                cmd.setIdCommande(rs.getInt("ID_COMMANDE"));
                cmd.setClient(model.getClientsParId(rs.getInt("ID_CLIENT")));
                cmd.setDateCmd(rs.getString("DATE"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return cmd;
    }



    public Object[][] findAll() {
        List<Commande> Commandes= new ArrayList<Commande>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from COMMANDE ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commande cmd = new Commande();

                ModelClient model= new ModelClient();
                cmd.setIdCommande(rs.getInt("ID_COMMANDE"));
                cmd.setClient(model.getClientsParId(rs.getInt("ID_CLIENT")));
                cmd.setClient2();
                cmd.setDateCmd(rs.getString("DATE"));
                Commandes.add(cmd);
            }
            Object[][] objCommande = new Object[Commandes.size()][3];
            int cpt =0;
            for(Commande cl: Commandes) {

                objCommande[cpt][0]=cl.getIdCommande();
                objCommande[cpt][1]=cl.getClient2();
                objCommande[cpt][2]=cl.getDateCmd();

                cpt++;

            }
            return objCommande;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;
    }



    /*@Override*/
    public void addCommande(HashMap<String,String> myList) {
        Connection conn=BdConnection.getConnection();
        ModelClient cat = new ModelClient();
        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO COMMANDE(ID_CLIENT,DATE)"
                    + " VALUES(?,?)");
            ps.setInt(1,  cat.getClientParLib(myList.get("src.Commande0")));
            ps.setString(2, myList.get("src.Commande1"));
            System.out.println(cat.getClientParLib(myList.get("src.Commande1")));
            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void deleteCommande(int id) {

        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("DELETE from COMMANDE WHERE ID_Commande=? ");
            ps.setInt(1, id);
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public void deleteCommande(Commande cmd) {

        deleteCommande(cmd.getIdCommande());

    }



}

