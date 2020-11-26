package com.sip.ams.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Book;
import com.sip.ams.exceptions.ResourceNotFoundException;
import com.sip.ams.repositories.BookRepository;


import java.util.List;
import javax.validation.Valid;
@RestController
@RequestMapping({"/book"})
public class BookRestController {
@Autowired
private BookRepository bookRepository;
@GetMapping("/list")
 public List<Book> getAllBook() {
 return (List<Book>) bookRepository.findAll();
 }
@PostMapping("/add")
 public Book createBook(@Valid @RequestBody Book book) {
 return bookRepository.save(book);
 }
@PutMapping("/{bookId}")
 public Book updateBook(@PathVariable Long bookId, @Valid
@RequestBody Book bookRequest) {
 return bookRepository.findById(bookId).map(book -> {
 book.setTitle(bookRequest.getTitle());
 book.setAuthor(bookRequest.getAuthor());
 book.setPrice(bookRequest.getPrice());
 book.setReleaseDate(bookRequest.getReleaseDate());
 return bookRepository.save(book);
 }).orElseThrow(() -> new ResourceNotFoundException("BookId " +
bookId + " not found"));
 }
 @DeleteMapping("/{bookId}")
 public Book deleteBook(@PathVariable Long bookId) {
	 Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
		System.out.println("suite du programme...");
		bookRepository.delete(book);
		return book ;
		
 }

}
