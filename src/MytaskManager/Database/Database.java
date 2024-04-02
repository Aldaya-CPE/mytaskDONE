package MytaskManager.Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    
         private static Database instance;
    private Connection connection;
    public static Database getInstance(){
        if (instance==null) {
            instance = new Database();
        }
        return instance;
    }
        private Database(){
        
    }
    
     public void ConnectToDatabase() throws  SQLException, ClassNotFoundException{
        String server = "127.0.0.1";
//      String server = "192.168.113.188";
//      String server = "192.168.133.150";
//      String server = "192.168.133.128";


        String port = "3306";
        String database = "mytask";
        String user = "root";
//      String user = "mytask";
        String password = "Aldaya@1234";
//      String password = "aldaya@123";
//      String password = "mytask@0809";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
    }
    public Connection getConnection() {
        return connection;
    }
 
}




