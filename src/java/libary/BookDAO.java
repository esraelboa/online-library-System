/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static libary.PostgreSql.getConnection;

/**
 *
 * @author esra
 */
public class BookDAO {

    public static ArrayList<Book> getAllBooks() {
        ArrayList<Book> list = new ArrayList<>();
        try {
            Connection c = getConnection();
            Statement stmt = c.createStatement();
            String sql = "select * from book;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("id"));
                book.setBookTitle(rs.getString("name"));
                book.setBookDecscrption(rs.getString("descrption"));
                book.setBookAutor(rs.getString("autor"));
                list.add(book);
            }
            rs.close();
            stmt.close();
            c.close();
            return list;
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;
    }

    public static Book getBookInf(String bookname) {
        Book book = new Book();
        try {
            Connection c = getConnection();
            String sql = "SELECT * FROM BOOK WHERE NAME ='" + bookname + "'";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                book.setBookId(rs.getInt("id"));
                book.setBookTitle(rs.getString("name"));
                book.setBookDecscrption(rs.getString("descrption"));
                book.setBookAutor(rs.getString("autor"));
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return book;
    }

    public static int insertBook(Book book) throws Exception {
        int st = 0;
        int id = 0;
        Connection c = getConnection();
        String sql = "INSERT INTO book(name,descrption,autor,catid)VALUES(?,?,?,?);";
        PreparedStatement pstmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, book.getBookTitle());
        pstmt.setString(2, book.getBookDescrption());
        pstmt.setString(3, book.getBookAutor());
        Catogray catogray = book.getCatid();
        pstmt.setInt(4, catogray.getCatid());
        st = pstmt.executeUpdate();      
        if (st > 0) {      
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            rs.close();
            System.out.println("book inserted succsfully : " + id);
        }
        pstmt.close();
        c.close();

        return id;
    }

    public static ArrayList<Catogray> getAllCatogries() {
        ArrayList<Catogray> catograies = new ArrayList<>();
        try {
            Connection c = getConnection();
            Statement stmt = c.createStatement();
            String sql = "select * from catogray order by catogray_id;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("catogray_id");
                String name = rs.getString("catogray_name");
                Catogray catogray = new Catogray(id, name);
                catograies.add(catogray);
            }
        } catch (Exception e) {
        }
        return catograies;
    }
}
