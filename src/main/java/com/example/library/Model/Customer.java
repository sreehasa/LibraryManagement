package com.example.library.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerid;

    @Column(name="FirstName")
    private String firstname;

    @Column(name="LastName")
    private String lastname;

    @Column(name="Address")
    private String address;

    @Column(name="Sex")
    private String sex;

    @Column(name="Status")
    private String status;

    public Customer(String firstname, String lastname, String address, String sex, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.sex = sex;
        this.status = status;
    }

    public Customer() {
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
