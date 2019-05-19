/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author esra
 */
public class DisplayBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        JSONObject json = new JSONObject();
        JSONArray books = new Book().displayAllBooks(BookDAO.getAllBooks());
        try {
            json.put("books", books);
            response.getWriter().write(json.toString());
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
