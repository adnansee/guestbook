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

    GuestBookDao guestBookDao ;
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
            out.println("HHJHHHH");
            out.println("<h1>");
            out.println(guestBookDao.getGuestBookItems());
            out.println("</h1>");
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

}

