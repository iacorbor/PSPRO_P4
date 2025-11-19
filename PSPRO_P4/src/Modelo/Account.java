package Modelo;

import java.util.GregorianCalendar;

public class Account {
    private int id;
    private float balance;
    private GregorianCalendar openDate;
    private int clientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public GregorianCalendar getOpenDate() {
        return openDate;
    }

    public void setOpenDate(GregorianCalendar openDate) {
        this.openDate = openDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
