package com.example.demo.models;

import javax.persistence.*;

@Entity
public class CourseBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer book_id;

    @Column(name = "book_name", nullable = false)
    private String book_name;

    @Column(name = "edition", nullable = true)
    private String edition;

    @Column(name = "price", nullable = true)
    private Integer price;


    public CourseBooks() {
        super();
    }

    public CourseBooks(String book_name, String edition, Integer price) {
        this.book_name = book_name;
        this.edition = edition;
        this.price = price;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "CourseBooks{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                '}';
    }
}
