package be.intec.webcomponents.guestboook.dao;

import java.sql.*;

public class MainApp1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://noelvaes.eu/StudentDB";
        String user = "student";
        String pwd = "student123";
        try {
            Connection c = DriverManager.getConnection(url, user, pwd);
            var p = c.prepareStatement("SELECT * FROM GuestBook ");

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    }
