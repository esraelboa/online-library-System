package libary;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author esra
 */
public class Book {

    private int book_id;
    private String book_title;
    private String descrption;
    private String autor;
    private Catogray catid;

    public Book() {
    }

    public Book(int id, String title, String descrption, String name) {
        this.book_id = id;
        this.book_title = title;
        this.autor = name;
        this.descrption = descrption;
    }

    public void setBookId(int id) {
        this.book_id = id;
    }

    public int getBookId() {
        return this.book_id;
    }

    public void setBookTitle(String title) {
        this.book_title = title;
    }

    public String getBookTitle() {
        return this.book_title;
    }

    public void setBookAutor(String name) {
        this.autor = name;
    }

    public String getBookAutor() {
        return this.autor;
    }

    public void setBookDecscrption(String descrption) {
        this.descrption = descrption;
    }

    public String getBookDescrption() {
        return this.descrption;
    }

    public Catogray getCatid() {
        return catid;
    }

    public void setCatid(Catogray catid) {
        this.catid = catid;
    }

    public JSONObject convertToJson(Book book) {

        JSONObject jobj = new JSONObject();
        try {
            jobj.put("id", book.getBookId());
            jobj.put("book_title", book.getBookTitle());
            jobj.put("Descrption", book.getBookDescrption());
            jobj.put("Autor", book.getBookAutor());
        } catch (JSONException ex) {

            System.out.println(ex.getMessage());
        }

        return jobj;
    }

    public JSONArray displayAllBooks(ArrayList<Book> list) {
        JSONArray jarr = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jarr.put(convertToJson(list.get(i)));
        }
        return jarr;
    }

    public void search(String name) {
        try {
            Connection c = PostgreSql.getConnection();
            String sql = "select * from book where name =?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
