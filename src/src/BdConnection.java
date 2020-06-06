package src;

import java.sql.Connection;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;



public class BdConnection {

    public  static Connection connection;


    static {

        Properties props=new Properties();
        try (FileInputStream fis = new FileInputStream ("conf.properties")){
            props.load( fis );

        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class.forName(props.getProperty("jdbc.driver.class"));
            String url = props.getProperty("jdbc.url");
            String login = props.getProperty("jdbc.login");
            String mdp = props.getProperty("jdbc.password");
            connection =DriverManager.getConnection(url, login, mdp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }



}