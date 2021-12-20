package com.example.bookmanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookmanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Book b set b.availableCopies = ?1 where b.id = ?2")
    public int updateBookById(Integer availableCopies, String bookId);

}
