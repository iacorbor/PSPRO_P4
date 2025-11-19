package Modelo;

import java.sql.Blob;
import java.util.GregorianCalendar;

public class Client {
    private int id;
    private String name;
    private String password;
    private GregorianCalendar registerDate;
    private Blob image;
    private float totalSalary;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(GregorianCalendar registerDate) {
        this.registerDate = registerDate;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }
}
