package com.sip.ams.entities;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Book {

	
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;

 @NotBlank(message = "Title is mandatory")
 @Column(name = "title")
 private String title;

 @NotBlank(message = "Author is mandatory")
 @Column(name = "author")
 private String author;

 //@NotBlank(message = "Price is mandatory")
 @Column(name = "price")
 private double price;
 
 @NotBlank(message = "Release Date is mandatory")
 @Column(name = "releaseDate")
 private String releaseDate;

 

public Book() {

}

public Book(String title,
		 String author, double price,
	String releaseDate) {
	
	this.title = title;
	this.author = author;
	this.price = price;
	this.releaseDate = releaseDate;

}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}



public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
 

 

}