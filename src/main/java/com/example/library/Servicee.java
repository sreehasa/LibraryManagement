package com.example.library;

import com.example.library.Model.Books;
import com.example.library.Model.issue_template;
import com.example.library.Repository.BooksRepository;
import com.example.library.Model.Customer;
import com.example.library.Repository.CustomerRepository;
import com.example.library.Model.Issues;
import com.example.library.Repository.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Servicee {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    IssuesRepository issuesRepository;

/*
    private List<Customer> c= new ArrayList<>(Arrays.asList(new Customer("hasa","k","hyderabad","f","false")    ));
    private List<Books> b= new ArrayList<>(Arrays.asList(new Books("The alchemist", "panlo coelho","1988") ));
    private List<Books> i= new ArrayList<>(Arrays.asList());
    public List<Books> getAllBooks() { return b; }
    public List<Customer> getAllCust() {  return c; }
*/


    public String addBook(Books book) {
//        b.add(book);
        booksRepository.save(book);
        return "Added book";
    }

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Optional<Books> getBookByBookId(Integer id)
    {
        return booksRepository.findByBookId(id);
    }

    public String deleteByIdB(Integer id) {
        booksRepository.deleteById(id);
        return "Deleted book";
    }





    public String addCust(Customer customer) {
        customerRepository.save(customer);
        return "Added customer";
    }

    public List<Customer> getAllCust(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByCustomerId(Integer id)
    {
        return customerRepository.findByCustomerId(id);
    }

    public List<Customer> getStatus(String status) {
//        return c.stream().filter(cc -> cc.getStatus().equals(status)).findAll().get();
        return customerRepository.findByStatus(status);
    }

    public List<Customer> getBlacklist() {
        return customerRepository.getBlacklist();
    }

    public void setblacklist(Integer id) {
        Optional<Customer> t = customerRepository.findById(id);
        Customer tModel = new Customer();
        tModel.setCustomerid(id);
        tModel.setFirstname(t.get().getFirstname());
        tModel.setLastname(t.get().getLastname());
        tModel.setAddress(t.get().getAddress());
        tModel.setSex(t.get().getSex());

        tModel.setStatus("blacklisted");
        customerRepository.save(tModel);
    }

    public String deleteById(Integer id) {
        customerRepository.deleteById(id);
        return "Deleted customer";
    }

    public String addIssue(issue_template issues)
    {
        /*
        Optional<Issues> x=issuesRepository.findByBookId(issues.getBookID());
        if(!x.isEmpty()){
            return "Book is already issued";
        }
        Optional<Issues> y=issuesRepository.findByCustId(issues.getBookID());
        if(!y.isEmpty()){
            return "Customer already issued";
        }
        */
        Issues new_issue = new Issues();
        new_issue.setBooks(getBookByBookId(issues.getBook_id()).get());
        new_issue.setCustomer(getCustomerByCustomerId(issues.getCust_id()).get());
        issuesRepository.save(new_issue);
        return "Issue added";
    }

    public String deleteByIssueId(Integer id) {
        issuesRepository.deleteById(id);
        return "Book returned";
    }


}