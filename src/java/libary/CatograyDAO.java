/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author esra
 */
public class CatograyDAO {
    public static ArrayList<Catogray> getAllCatogries() {
        ArrayList<Catogray> catograies = new ArrayList<>();
        try {
            Connection c = PostgreSql.getConnection();
            Statement stmt = c.createStatement();
            String sql = "select * from catogray order by catogray_id;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int id = rs.getInt("catogray_id");
            String name = rs.getString("catogray_name");
            Catogray catogray=new Catogray(id,name);
            catograies.add(catogray);
            }
        } catch (Exception e) {
        }
        return catograies;
    }
  
}
