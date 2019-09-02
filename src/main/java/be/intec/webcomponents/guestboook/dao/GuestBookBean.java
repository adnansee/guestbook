package be.intec.webcomponents.guestboook.dao;


import java.util.Date;

public class GuestBookBean {
    public Date data;
    public String name;
    public String message;

    @Override
    public String toString() {
        return "GuestBookBean{" +
                "data=" + data +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Date getData() {
        return data;
    }

    public GuestBookBean setData(Date data) {
        this.data = data;
        return this;
    }

    public String getName() {
        return name;
    }

    public GuestBookBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GuestBookBean setMessage(String message) {
        this.message = message;
        return this;
    }
}

