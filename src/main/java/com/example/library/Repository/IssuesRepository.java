package com.example.library.Repository;

import com.example.library.Model.Customer;
import com.example.library.Model.Issues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface IssuesRepository extends JpaRepository<Issues,Integer> {
    @Query(value = "Select * from Issues c WHERE c.bookID= ?1 ",nativeQuery = true)
    Optional<Issues> findByBookId(Integer bookID);

    @Query(value = "Select * from Issues c WHERE c.custID= ?1 ",nativeQuery = true)
    Optional<Issues> findByCustId(Integer bookID);

    @Query(value = "DELETE from Issues WHERE cust_issues= ?1 ",nativeQuery = true)
    void deleteByCustId(Integer bookID);



}
