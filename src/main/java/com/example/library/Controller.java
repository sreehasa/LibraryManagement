package com.example.library;

import com.example.library.Model.Books;
import com.example.library.Model.Customer;
import com.example.library.Model.Issues;
import com.example.library.Model.issue_template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Servicee service;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return service.getAllBooks();
    }

    @RequestMapping(method= RequestMethod.POST,value="/books/add")
    public String addBook(@RequestBody Books book){
        return service.addBook(book);
    }
    @DeleteMapping("/book/delete/{id}")
    public String deletebyidb(@PathVariable Integer id) {
        return service.deleteByIdB(id);
    }




    @RequestMapping(method= RequestMethod.POST,value="/cust/add")
    public String addCust(@RequestBody Customer customer){
        return service.addCust(customer);
    }

    @GetMapping("/cust")
    public List<Customer> getAllCust(){
        return service.getAllCust();
    }

    @GetMapping ("/cust/{status}")
    public List<Customer> getStatus(@PathVariable String status){
        return service.getStatus(status);
    }

    @GetMapping ("/cust/blacklist")
    public List<Customer> getStatus(){
        return service.getBlacklist();
    }

    @RequestMapping(method= RequestMethod.PUT,value="/cust/{id}")
    public void setblacklist(@RequestBody Customer customer, @PathVariable Integer id){
        service.setblacklist(id);
    }

    @DeleteMapping("cust/delete/{id}")
    public String deletebyid(@PathVariable Integer id) {
        return service.deleteById(id);
    }




    @RequestMapping(method= RequestMethod.POST,value="/issue/add")
    public String addIssue(@RequestBody issue_template issue){
        return service.addIssue(issue);
    }
    @DeleteMapping("issue/delete/{issueid}")
    public String deletebyissueid(@PathVariable Integer issueid) {
        return service.deleteByIssueId(issueid);
    }

}
