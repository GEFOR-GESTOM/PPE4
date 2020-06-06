package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ModelCategorie {

    public Collection<Categorie> getCategoriesParMotCle(String mc) {
        Collection<Categorie> Categories= new ArrayList<Categorie>();
        Connection conn=BdConnection.getConnection();
        mc=mc.toUpperCase();
        try {
            PreparedStatement ps= conn.prepareStatement("select * from CATEGORIE "
                    + "where UPPER(NOM) LIKE ?");
            ps.setString(1, "%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categorie cat = new Categorie();
                cat.setIdCategorie(rs.getInt("ID_CATEGORIE"));
                cat.setLibelleCat(rs.getString("LIBELLE_CAT"));
                Categories.add(cat);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return Categories;
    }


    public Categorie getCategoriesParId(int id) {

        Connection conn=BdConnection.getConnection();
        Categorie cat = new Categorie();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CATEGORIE "
                    + "WHERE ID_CATEGORIE=?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cat.setIdCategorie(rs.getInt("ID_CATEGORIE"));
                cat.setLibelleCat(rs.getString("LIBELLE_CAT"));
                System.out.println(cat.getLibelleCat()+" hello");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return cat;
    }
    public int  getCategoriesParLib(String lib) {

        Connection conn=BdConnection.getConnection();
        int idCat=0 ;

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CATEGORIE "
                    + "WHERE LIBELLE_CAT=?");
            ps.setString(1,lib);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                idCat = rs.getInt("ID_CATEGORIE");

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return idCat;
    }


    public List<Categorie> findAll() {
        List<Categorie> Categories= new ArrayList<Categorie>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from CATEGORIE ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categorie cat = new Categorie();
                cat.setIdCategorie(rs.getInt("ID_CATEGORIE"));
                cat.setLibelleCat(rs.getString("LIBELLE_CAT"));

                Categories.add(cat);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return Categories;
    }


    /*@Override*/
    public void addCategorie(Categorie cat) {
        Connection conn=BdConnection.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO CATEGORIE(LIBELLE_CAT)"
                    + " VALUES(?)");
            ps.setString(1, cat.getLibelleCat());



            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void deleteCategorie(int id) {

        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("DELETE from CATEGORIE WHERE ID_CATEGORIE=? ");
            ps.setInt(1, id);
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public void deleteCategorie(Categorie cat) {

        deleteCategorie(cat.getIdCategorie());

    }



}


