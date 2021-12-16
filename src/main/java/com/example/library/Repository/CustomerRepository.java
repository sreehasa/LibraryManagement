package com.example.library.Repository;

import com.example.library.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Integer>{

    @Query(value = "Select * from Customer c WHERE c.Status= ?1 ",nativeQuery = true)
    List<Customer> findByStatus(String status);

    @Query(value ="SELECT * FROM Customer c WHERE c.Status='blacklisted' ", nativeQuery = true)
    List<Customer> getBlacklist();

    @Query(value = "Select * from customer c where c.customerid = ?1", nativeQuery = true)
    Optional<Customer> findByCustomerId(Integer id);

}
