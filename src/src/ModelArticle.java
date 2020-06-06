package src;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ModelArticle {

    public Object[][] getArticlesParMotCle(String mc) {
        Collection<Article> articles= new ArrayList<Article>();
        Connection conn=BdConnection.getConnection();
        mc=mc.toUpperCase();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from ARTICLE where LIBELLE LIKE ?");
            ps.setString(1, "%"+mc+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Article art = new Article();

                ModelCategorie model= new ModelCategorie();
                art.setIdArticle(rs.getInt("ID_ARTICLE"));
                System.out.println(" hello");
                int idCat = rs.getInt("ID_CATEGORIE");
                System.out.println(idCat);
                Categorie cat = model.getCategoriesParId(idCat);
                System.out.println(cat);
                art.setAppartient(cat);
                System.out.println(" hello");
                art.setReference(rs.getString("REFERENCE"));
                art.setDescription(rs.getString("DESCRIPTION"));
                art.setStock(rs.getInt("STOCK"));
                art.setLibelle(rs.getString("LIBELLE"));
                art.setPrix(rs.getDouble("PRIX"));
                articles.add(art);
            }
            Object[][] objArticle = new Object[articles.size()][7];
            int cpt =0;
            for(Article cl: articles) {

                objArticle[cpt][0]=cl.getIdArticle();
                objArticle[cpt][1]=cl.getLibelleCatArt();

                objArticle[cpt][2]=cl.getReference();
                objArticle[cpt][3]=cl.getDescription();
                objArticle[cpt][4]=cl.getStock();
                objArticle[cpt][5]=cl.getLibelle();
                objArticle[cpt][6]=cl.getPrix();

                cpt++;

            }

            return objArticle;
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
            return obj;
    }


    public Article getArticlesParId(int id) {

        Connection conn=BdConnection.getConnection();
        Article art = new Article();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from ARTICLE "
                    + "where ID_ARTICLE=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ModelCategorie model= new ModelCategorie();
                art.setIdArticle(rs.getInt("ID_ARTICLE"));
                art.setAppartient(model.getCategoriesParId(rs.getInt("ID_ARTICLE")));
                art.setReference(rs.getString("REFERENCE"));
                art.setDescription(rs.getString("DESCRIPTION"));
                art.setStock(rs.getInt("STOCK"));
                art.setLibelle(rs.getString("LIBELLE"));
                art.setPrix(rs.getDouble("PRIX"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return art;
    }

    public Object[][] findAll() {
        List<Article> articles= new ArrayList<Article>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("select * from ARTICLE ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Article art = new Article();
                ModelCategorie model= new ModelCategorie();
                art.setIdArticle(rs.getInt("ID_ARTICLE"));
                art.setAppartient(model.getCategoriesParId(rs.getInt("ID_CATEGORIE")));
                art.setReference(rs.getString("REFERENCE"));
                art.setDescription(rs.getString("DESCRIPTION"));
                art.setStock(rs.getInt("STOCK"));
                art.setLibelle(rs.getString("LIBELLE"));
                art.setPrix(rs.getDouble("PRIX"));
                articles.add(art);
                //System.out.println();
            }
            Object[][] objArticle = new Object[articles.size()][7];
            int cpt =0;
            for(Article cl: articles) {

                objArticle[cpt][0]=cl.getIdArticle();
                objArticle[cpt][1]=cl.getLibelleCatArt();
                objArticle[cpt][2]=cl.getReference();
                objArticle[cpt][3]=cl.getDescription();
                objArticle[cpt][4]=cl.getStock();
                objArticle[cpt][5]=cl.getLibelle();
                objArticle[cpt][6]=cl.getPrix();

                cpt++;

            }
            return objArticle;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;

    }

    public Object[][] stat() {
        //List<Article> articles= new ArrayList<Article>();
        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("SELECT CATEGORIE.LIBELLE_CAT as lib, sum(STOCK)as stkTotal FROM ARTICLE,CATEGORIE WHERE ARTICLE.ID_CATEGORIE=CATEGORIE.ID_CATEGORIE GROUP BY ARTICLE.ID_CATEGORIE");

            ResultSet rs = ps.executeQuery();
            int cpt = 0;
            while (rs.next()) {

                cpt++;
            }
            Object[][] objArticle = new Object[cpt][2];
            cpt =0;
            while (rs.previous()) {

                objArticle[cpt][0]=rs.getString("lib");
                objArticle[cpt][1]=rs.getInt("stkTotal");

                cpt++;

            }
            return objArticle;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Object[][] obj= new Object[0][0];
        return obj;

    }

    /*@Override*/
    public void addArticle(HashMap<String,String> myList) {

        Connection conn=BdConnection.getConnection();
        ModelCategorie cat = new ModelCategorie();

        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO ARTICLE(ID_CATEGORIE,REFERENCE,DESCRIPTION,STOCK,LIBELLE,PRIX)"
                    + " VALUES(?,?,?,?,?,?)");
            ps.setInt(1, cat.getCategoriesParLib(myList.get("src.Article0")));
            ps.setString(2, myList.get("src.Article1"));
            ps.setString(3, myList.get("src.Article2"));
            ps.setInt(4, Integer.parseInt(myList.get("src.Article3")));
            ps.setString(5, myList.get("src.Article4"));
            ps.setDouble(6, Double.parseDouble(myList.get("src.Article5")));


            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void modArticle(HashMap<String,String> myList,Object bufferId) {

        Connection conn=BdConnection.getConnection();
        ModelCategorie cat = new ModelCategorie();

        try {
            PreparedStatement ps= conn.prepareStatement("UPDATE ARTICLE SET ID_CATEGORIE=?,"
                    + "REFERENCE=?,DESCRIPTION=?,STOCK=?,LIBELLE=?,PRIX=? WHERE ID_ARTICLE=?");
            ps.setInt(1, cat.getCategoriesParLib(myList.get("src.Article1")));
            ps.setString(2, myList.get("src.Article2"));
            ps.setString(3, myList.get("src.Article3"));
            ps.setInt(4, Integer.parseInt(myList.get("src.Article4")));
            ps.setString(5, myList.get("src.Article5"));
            ps.setDouble(6, Double.parseDouble(myList.get("src.Article6")));
            ps.setInt(7, (int) bufferId);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void deleteArticle(Object bufferId) {

        Connection conn=BdConnection.getConnection();

        try {
            PreparedStatement ps= conn.prepareStatement("DELETE from Article WHERE ID_Article=? ");
            ps.setInt(1,(int) bufferId);
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public void deleteArticle(Article art) {

        deleteArticle(art.getIdArticle());

    }



}
