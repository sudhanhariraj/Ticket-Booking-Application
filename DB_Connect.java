/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;
/**
 *
 * @author LENOVO
 */
public class DB_Connect {
        public static Connection getCon() 
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
                return con;
            }
            catch(Exception e)
            {
                return null;
            }
        }
}
    