package com.example.library.Model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="issues")
@Data
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueid;

//    @Column(name="custID")
//    private Integer custID;
//
//    @Column(name="bookID")
//    private Integer bookID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name="cust_issues")
    Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name="books_issue")
    Books books;

    public Issues() {
    }

    public Integer getIssueid() {
        return issueid;
    }

    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}