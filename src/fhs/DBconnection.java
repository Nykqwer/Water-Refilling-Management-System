/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fhs;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Nyko
 */
public class DBconnection {
        public static Connection conns(){
        try{
            String dbRoot ="jdbc:mysql://";
            String hostname = "localhost:3306/";
            String dbName ="fhs_station1";
            String dbUrl = dbRoot+hostname+dbName;
            String hostUsername ="root";
            String hostPassword= "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
            return myConn;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Connection Error");
            return null;
        }
    }
    static Connection getConnection(){
        throw new UnsupportedOperationException("Not Supported yet.");
    }
    
}
