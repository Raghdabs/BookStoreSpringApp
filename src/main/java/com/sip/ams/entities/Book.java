package com.sip.demo.entities;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Book {
<<<<<<< HEAD
	private int id;
	private String title;
	private String Author;
	private double Price;
	private Date ReleaseDate;
	private String path;

	public Book(int id, String title, String author, double price, Date releaseDate, String path) {
		super();
		this.id = id;
		this.title = title;
		Author = author;
		Price = price;
		ReleaseDate = releaseDate;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", Author=" + Author + ", Price=" + Price + ", ReleaseDate="
				+ ReleaseDate + ", path=" + path + "]";
	}

=======
	
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
>>>>>>> 96ccd0ea73462efe47bf626a38495905cb0b5e10
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