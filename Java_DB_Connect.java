/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaseapp;
/**
 *
 * @author kiffg
 */
import java.sql.*;
public class DBaseApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
    try{
        String database = "test.accdb";
        String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.accdb);"
                + " DBQ="+ database + ";DriverID=22;READONLY=true";
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection(url);
        Statement st = con.createStatement();
        String sql = " SELECT * FROM tbl_playlist";
        ResultSet result_set = st.executeQuery(sql);
        
        while(result_set.next()){
            System.out.println("\n" + result_set.getString(0) + "\t");
            System.out.println("\n" + result_set.getString(1) + "\t");
            System.out.println("\n" + result_set.getString(2) + "\t");
            System.out.println("\n" + result_set.getString(3) + "\t"); 
        }
    
        } catch(Exception e) {
            System.out.println(e.getMessage() + " connection failed.");
        }
    }
    
}
