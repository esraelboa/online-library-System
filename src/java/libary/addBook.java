package libary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author esra
 */
public class addBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsobj = new JSONObject();
        try {
            Book book = new Book();
            book.setBookTitle(request.getParameter("title"));
            book.setBookDecscrption(request.getParameter("descscrption"));
            book.setBookAutor(request.getParameter("autor"));
            int catid = Integer.parseInt(request.getParameter("catid"));
            book.setCatid(new Catogray(catid));
            int id = BookDAO.insertBook(book);
            if (id > 0) {
                jsobj.put("id", id);
            } else {
                jsobj.put("id", "id =" + id + " inserted failed!");
            }

            response.getWriter().write(jsobj.toString());

        } catch (Exception ex) {
            System.out.println(ex.getClass() + "\n" + ex.getMessage());
        }
    }
}
