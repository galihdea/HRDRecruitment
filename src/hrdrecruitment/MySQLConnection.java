/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdrecruitment;
import java.sql.*;

/**
 *
 * @author Galih Dea
 */
public class MySQLConnection {
    
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from karyawan");
            while(rs.next()){
                System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
