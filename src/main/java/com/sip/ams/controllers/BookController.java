package com.sip.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.demo.entities.Book;
import com.sip.demo.repositories.BookRepository;
import java.util.List;
import javax.validation.Valid;
@Controller
@RequestMapping("/book/")
public class BookController {
private final BookRepository bookRepository;
@Autowired
public BookController(BookRepository bookRepository) {
this.bookRepository = bookRepository;
}
@GetMapping("list")

// @ResponseBody
public String listBooks(Model model) {
List<Book> lb = (List<Book>) bookRepository.findAll();
if (lb.size() == 0)
lb = null;
model.addAttribute("books", lb);
return "book/listBooks";
// System.out.println(lp);
// return "Nombre de fournisseur = " + lp.size();
}
@GetMapping("add")
public String showAddBookForm(Model model) {
Book book = new Book();// object dont la valeur des attributs par defaut
model.addAttribute("book", book);
return "book/addBook";
}
@PostMapping("add")
public String addBook(@Valid Book book, BindingResult result, Model
model) {
if (result.hasErrors()) {
return "book/addBook";
}
bookRepository.save(book);
 
return "redirect:list";
}
@GetMapping("delete/{id}")
public String deleteBook(@PathVariable("id") long id, Model model) {
// long id2 = 100L;
Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalidbook Id:" + id));
System.out.println("suite du programme...");
bookRepository.delete(book);
/*
* model.addAttribute("providers", providerRepository.findAll()); return
* "provider/listProviders";
*/
return "redirect:../list";
}
@GetMapping("edit/{id}")
public String showBookFormToUpdate(@PathVariable("id") long id, Model model)
{
Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalidbook Id:" + id));

model.addAttribute("book", book);
return "book/updateBook";
}
@PostMapping("update")
public String updateBook(@Valid Book book, BindingResult result, Model
model) {
if (result.hasErrors()) {
return "book/updateBook";
}
bookRepository.save(book);
return "redirect:list";
}
}