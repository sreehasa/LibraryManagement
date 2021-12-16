package com.example.library.Model;

public class issue_template {
    private Integer cust_id;
    private Integer book_id;

    public issue_template(Integer cust_id, Integer book_id) {
        this.cust_id = cust_id;
        this.book_id = book_id;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
}
