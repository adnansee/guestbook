package be.intec.webcomponents.guestboook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {



    public GuestBookDao(String url, String user, String pwd) {
    }

    public List<GuestBookBean> getGuestBookItems(){
         List<GuestBookBean> guestBookBeans = new ArrayList<>();
        String url = "jdbc:mysql://noelvaes.eu/StudentDB";
        String user = "student";
        String pwd = "student123";

        try {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, user, pwd);
        var p = c.prepareStatement("SELECT * FROM GuestBook ");
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("Name"));
            guestBookBeans.add(new GuestBookBean().setName(rs.getString("name")).setData(rs.getDate("date")).setMessage(rs.getString("message")));


        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return guestBookBeans;
}

public void addGuestBookItem(GuestBookBean item){
    //getGuestBookItems().add(item);


}
}

/* */