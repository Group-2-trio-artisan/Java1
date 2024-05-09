package libraryManagementSystem.entities;

import java.sql.Timestamp;
import java.util.Date;

public class Books {
    private int id;
    private String title;
    private String author;
    private String genre;
    private double price;
    private Date entry_date;
    private String status;

    public Books() {
    }

    public Books(int id, String title, String author, String genre, double price, Date entry_date, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.entry_date = entry_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public java.sql.Date getEntry_date(Timestamp timestamp) {
        return (java.sql.Date) entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
