package com.example.library.Repository;

import com.example.library.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {
    @Query(value = "Select * from books u where u.bookid = ?1", nativeQuery = true)
    Optional<Books> findByBookId(Integer id);

}
