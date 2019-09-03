package be.intec.webcomponents.guestboook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {

    String url = "jdbc:mysql://noelvaes.eu/StudentDB";
    String user = "student";
    String pwd = "student123";
    Connection c;



    public GuestBookDao(String url, String user, String pwd) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            c = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<GuestBookBean> getGuestBookItems() {
        List<GuestBookBean> guestBookBeans = new ArrayList<>();
        try {
            var p = c.prepareStatement("SELECT * FROM GuestBook ");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                guestBookBeans.add(new GuestBookBean().setName(rs.getString("name")).setData(rs.getDate("date")).setMessage(rs.getString("message")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestBookBeans;
    }


    public void addGuestBookItem(String entererdName, String enteredMessage) {

        try {

            var p = c.prepareStatement("INSERT INTO GuestBook (Name, Message) VALUES (?,?)");
            p.setString(1, entererdName);
            p.setString(2, enteredMessage);
            p.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGuestBookItem(String entererdName) {

        try {
            var p = c.prepareStatement("DELETE FROM GuestBook WHERE Name = ?");
            p.setString(1, entererdName);
            p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

