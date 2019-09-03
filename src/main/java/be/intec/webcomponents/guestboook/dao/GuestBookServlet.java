package be.intec.webcomponents.guestboook.dao;

import be.intec.webcomponents.guestboook.dao.GuestBookDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("")
public class GuestBookServlet extends HttpServlet {

    GuestBookDao guestBookDao;
    String enteredName;
    String enteredMessage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        String url = "jdbc:mysql://noelvaes.eu/StudentDB";
        String user = "student";
        String pwd = "student123";
        guestBookDao = new GuestBookDao(url, user, pwd);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {


            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>GUESTBOOK</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println();
            out.println("</h1>");
            out.println("WELCOME TO THE GUESTBOOK");
            out.println();


            out.println("<table>  <tr>    <td>");
            guestBookDao.getGuestBookItems().forEach(g -> {
                out.println(" <tr>\n   <td>");
                out.print(g.getData() + "     ");
                out.print(g.getName() + "     ");
                out.print(g.getMessage());
                out.println("</td>    <td>Doe</td>  </tr>");
            });
            out.println("</table>");
            out.println("ENTERING SECTION");
            out.println(" <form method = 'post' action =''>" +
                    "  name:<br>" +
                    "  <input type='text' name='name'><br>" +
                    "  message:<br>" +
                    "  <input type='text' name='message'>" +
                    "<input type='submit' name='enter'>" +
                    "</form> ");


            out.println("DELETE SECTION");
           out.println("<textarea name= 'deleteText'>Enter name to delete</textarea>" );







            /*Footer begin*/
            out.println("<footer>");
            out.println("<p>");
            out.println("-----------------");
            out.println("</p>");
            out.println("   <p><a href=");

            out.println("<p>");
            out.println("-----------------");
            out.println("</p>");
            out.println("</footer>");
            /*Footer end*/
            out.println("</body>");
            out.println("<html>");

        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String message = req.getParameter("message");
        guestBookDao.addGuestBookItem(name, message);
        doGet(req, resp);


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        guestBookDao.deleteGuestBookItem(name);
        doGet(req, resp);
    }
}