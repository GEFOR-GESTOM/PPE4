package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ModelClient {


    public Client getClientsParId(int id) {

        Connection conn=BdConnection.getConnection();
        Client c = new Client();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CLIENT "
                    + "where ID_CLIENT=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                c.setIdClient(rs.getInt("ID_CLIENT"));
                c.setNom(rs.getString("NOM"));
                c.setPrenom(rs.getString("PRENOM"));
                c.setRaisonSociale(rs.getString("RAISON_SOCIALE"));
                c.setAdresse(rs.getString("ADRESSE"));
                c.setCodePostal(rs.getString("CODE_POSTAL"));
                c.setVille(rs.getString("VILLE"));
                c.setTel(rs.getString("TEL"));


            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return c;
    }

    public int  getClientParLib(String lib) {

        Connection conn=BdConnection.getConnection();
        int idCat=0 ;

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CLIENT "
                    + "WHERE NOM=?");
            ps.setString(1,lib);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                idCat = rs.getInt("ID_CLIENT");

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return idCat;
    }

    public Object[][] getClientsParMotCle(String mc) {
        Collection<Client> clients= new ArrayList<Client>();
        Connection conn=BdConnection.getConnection();
        mc=mc.toUpperCase();
        try {
            PreparedStatement ps= conn.prepareStatement("select * from CLIENT "
                    + "where NOM LIKE ?");
            ps.setString(1, "%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setIdClient(rs.getInt("ID_CLIENT"));
                c.setNom(rs.getString("NOM"));
                c.setPrenom(rs.getString("PRENOM"));
                c.setRaisonSociale(rs.getString("RAISON_SOCIALE"));
                c.setAdresse(rs.getString("ADRESSE"));
                c.setCodePostal(rs.getString("CODE_POSTAL"));
                c.setVille(rs.getString("VILLE"));
                c.setTel(rs.getString("TEL"));
                clients.add(c);
            }
            Object[][] objClient = new Object[clients.size()][8];
            int cpt =0;
            for(Client cl: clients) {

                objClient[cpt][0]=cl.getIdClient();
                objClient[cpt][1]=cl.getNom();
                objClient[cpt][2]=cl.getPrenom();
                objClient[cpt][3]=cl.getRaisonSociale();
                objClient[cpt][4]=cl.getAdresse();
                objClient[cpt][5]=cl.getCodePostal();
                objClient[cpt][6]=cl.getVille();
                objClient[cpt][7]=cl.getTel();
                cpt++;

            }
            return objClient;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;
    }

    public Object[][] findAll() {
        List<Client> clients= new ArrayList<Client>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CLIENT ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Client c = new Client();
                c.setIdClient(rs.getInt("ID_CLIENT"));
                c.setNom(rs.getString("NOM"));
                c.setPrenom(rs.getString("PRENOM"));
                c.setRaisonSociale(rs.getString("RAISON_SOCIALE"));
                c.setAdresse(rs.getString("ADRESSE"));
                c.setCodePostal(rs.getString("CODE_POSTAL"));
                c.setVille(rs.getString("VILLE"));
                c.setTel(rs.getString("TEL"));
                clients.add(c);

            }
            Object[][] objClient = new Object[clients.size()][8];
            int cpt =0;
            for(Client cl: clients) {

                objClient[cpt][0]=cl.getIdClient();
                objClient[cpt][1]=cl.getNom();
                objClient[cpt][2]=cl.getPrenom();
                objClient[cpt][3]=cl.getRaisonSociale();
                objClient[cpt][4]=cl.getAdresse();
                objClient[cpt][5]=cl.getCodePostal();
                objClient[cpt][6]=cl.getVille();
                objClient[cpt][7]=cl.getTel();
                cpt++;

            }
            return objClient;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;
    }




    public void addClient(HashMap<String, String> myList) {
        Connection conn=BdConnection.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO CLIENT(NOM,PRENOM,RAISON_SOCIALE,ADRESSE,CODE_POSTAL,VILLE,TEL)"
                    + " VALUES(?,?,?,?,?,?,?)");

            ps.setString(1, myList.get("src.Client0"));
            ps.setString(2, myList.get("src.Client1"));
            ps.setString(3, myList.get("src.Client2"));
            ps.setString(4, myList.get("src.Client3"));
            ps.setString(5, myList.get("src.Client4"));
            ps.setString(6, myList.get("src.Client5"));
            ps.setString(7, myList.get("src.Client6"));


            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void modClient(HashMap<String, String> myList,Object bufferId) {
        Connection conn=BdConnection.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("UPDATE CLIENT SET NOM=?, PRENOM=?, RAISON_SOCIALE=?,"
                    + " ADRESSE=?, CODE_POSTAL=?, VILLE=?, TEL=? WHERE ID_CLIENT=?");

            ps.setString(1, myList.get("src.Client1"));
            ps.setString(2, myList.get("src.Client2"));
            ps.setString(3, myList.get("src.Client3"));
            ps.setString(4, myList.get("src.Client4"));
            ps.setString(5, myList.get("src.Client5"));
            ps.setString(6, myList.get("src.Client6"));
            ps.setString(7, myList.get("src.Client7"));
            ps.setInt(8, (int) bufferId);


            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void deleteClient(Object bufferId) {

        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("DELETE from CLIENT WHERE ID_CLIENT=? ");
            ps.setInt(1,(int) bufferId);
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public void deleteClient(Client c) {

        deleteClient(c.getIdClient());

    }



}
