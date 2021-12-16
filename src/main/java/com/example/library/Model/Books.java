package com.example.library.Model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="Books")
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookid;

    @Column(name="Title")
    private String title;
    @Column(name="Author")
    private String author;
    @Column(name="PublicationYear")
    private String publicationyear;


    public Books(String title, String author, String publicationyear) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
    }

    public Books() {    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

    public String getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(String publicationyear) {
        this.publicationyear = publicationyear;
    }

}