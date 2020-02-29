
package stockapp;

import java.sql.*;
import javax.swing.JOptionPane;


public class StockApp {

    public static Connection con;
    
    public static void main(String[] args) {
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://ISHITA\\ISHITA:49598;databaseName=stockdb;username=sa;password=ishita");
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);

        }//catch
        Login obj = new Login(null, true);
        obj.setVisible(true);
    }//func
    
 }//class
